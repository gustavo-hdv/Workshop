/*
    This file is part of Workshop.

    Workshop is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Workshop is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Workshop. If not, see <https://www.gnu.org/licenses/>

    Contact me:
        Email:   gustavohenrique0008@gmail.com
        Discord: TwoSouls#3428
*/
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.bean.AuditHistory;
import model.bean.Cliente;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ClienteDAO {

    public ClienteDAO() {
        
    }
    
    public boolean create(Cliente cliente) {

        String sql = "INSERT INTO clientes (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = null;     
        Connection connection = null;
        
        int insertClientValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getEndereco());
            
            insertClientValue = statement.executeUpdate();        
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        return insertClientValue != 0;
    }
    
    public List<Cliente> readAll() {
        
        String sql = "SELECT * FROM clientes ORDER BY id DESC";     
        
        PreparedStatement statement = null;     
        Connection connection = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setCodigo(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setEndereco(resultSet.getString("endereco"));
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return clientes;
    }
    
    public boolean update(Cliente cliente, int userId) {
        
        String sqlClientUpdate = "UPDATE clientes SET nome = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, cliente_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;     
        Connection connection = null;
        
        int updateClient = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlClientUpdate);
            
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getEndereco());
            statement.setInt(5, cliente.getCodigo());
            
            updateClient = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, cliente.getCodigo());
            statement.setString(3, "Cliente atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateClient != 0 && updateAuditHistory != 0;
    }
    
    public boolean delete(Cliente client) {
        
        String sqlClientDelete = "DELETE FROM clientes WHERE id = ?";
        String sqlAuditHistoryDelete = "DELETE FROM audit_history WHERE cliente_id=" + client.getCodigo();
        
        PreparedStatement statement = null;     
        Connection connection = null;
        
        int deleteClient = 0;
        int deleteAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlClientDelete);
            statement.setInt(1, client.getCodigo());

            deleteClient = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryDelete);
            
            deleteAuditHistory = statement.executeUpdate(); 
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return deleteClient != 0 && deleteAuditHistory != 0;
    }
    
    public List<Cliente> search(String nome) {
        
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        
        PreparedStatement statement = null; 
        ResultSet resultSet = null;
        Connection connection = null;
        
        List<Cliente> clientes = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            
            nome += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setCodigo(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setEndereco(resultSet.getString("endereco"));
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return clientes;
    }
    
    public List<AuditHistory> getAuditHistory(int clienteId) {
        List<AuditHistory> list = new ArrayList<>();
        
        String sql = "SELECT user_id, cliente_id, action, action_date_time, login "
                + "FROM audit_history, users "
                + "WHERE audit_history.user_id=users.id AND audit_history.cliente_id=" + clienteId;
        
        Statement statement = null; 
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()) {
                
                int userId = resultSet.getInt("user_id");
                String action = resultSet.getString("action");
                
                Timestamp timestamp = resultSet.getTimestamp("action_date_time");
                java.util.Date actionDateTime = new java.util.Date(timestamp.getTime());
                
                String userName = resultSet.getString("login");
                
                AuditHistory auditHistory = new AuditHistory(userId, clienteId, action, actionDateTime, userName);
                
                list.add(auditHistory);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return list;
    }
}
