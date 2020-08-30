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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.bean.AuditHistory;
import model.bean.Servico;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ServicoDAO {

    public ServicoDAO() {

    }
    
    public boolean create(Servico servico) {
        
        String sql = "INSERT INTO servicos (descricao, valor_unitario, quantidade) VALUES (?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, servico.getDescricao());
            statement.setString(2, servico.getValorUnitario().toString());
            statement.setInt(3, servico.getQuantidade());
            
            updateValue = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }  finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateValue != 0;
    }
    
    public List<Servico> readAll() {
        
        String sql = "SELECT * FROM servicos ORDER BY id DESC";
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        List<Servico> servicos = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Servico servico = new Servico();
                
                servico.setCodigo(resultSet.getInt("id"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setQuantidade(resultSet.getInt("quantidade"));
                servico.setValorUnitario(new BigDecimal(resultSet.getString("valor_unitario").replace(",", ".")));
                
                servicos.add(servico);
            }
        } catch (SQLException ex) {                     
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return servicos;
    }
    
    public boolean update(Servico servico, int userId) {
        
        String sqlServiceUpdate = "UPDATE servicos SET descricao = ?, quantidade = ?, valor_unitario = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, servico_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateService = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlServiceUpdate);
            
            statement.setString(1, servico.getDescricao());
            statement.setInt(2, servico.getQuantidade());
            statement.setString(3, servico.getValorUnitario().toString());
            statement.setInt(4, servico.getCodigo());
            
            updateService = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, servico.getCodigo());
            statement.setString(3, "Serviço atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateService != 0 && updateAuditHistory != 0;
    }
    
    public boolean delete(Servico servico) {
        String sqlServiceDelete = "DELETE FROM servicos WHERE id = ?";
        String sqlAuditHistoryDelete = "DELETE FROM audit_history WHERE servico_id=" + servico.getCodigo();
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int deleteService = 0;
        int deleteAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlServiceDelete);
            
            statement.setInt(1, servico.getCodigo());
            
            deleteService = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryDelete);
            
            deleteAuditHistory = statement.executeUpdate();   
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return deleteService != 0 && deleteAuditHistory != 0;
    }
    
    public List<Servico> search(String descricao) {
        
        String sql = "SELECT * FROM servicos WHERE descricao LIKE ?";
        
        List<Servico> servicos = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            descricao += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, descricao);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Servico servico = new Servico();
                
                servico.setCodigo(resultSet.getInt("id"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setQuantidade(resultSet.getInt("quantidade"));
                servico.setValorUnitario(new BigDecimal(resultSet.getString("valor_unitario").replace(",", ".")));
                
                servicos.add(servico);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return servicos;
    }
    
    public List<AuditHistory> getAuditHistory(int serviceId) {
        List<AuditHistory> list = new ArrayList<>();
        
        String sql = "SELECT user_id, servico_id, action, action_date_time, login "
                + "FROM audit_history, users "
                + "WHERE audit_history.user_id=users.id AND audit_history.servico_id=" + serviceId;
        
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
                
                AuditHistory auditHistory = new AuditHistory(userId, serviceId, action, actionDateTime, userName);
                
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
