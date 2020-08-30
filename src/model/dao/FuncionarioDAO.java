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
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.bean.AuditHistory;
import model.bean.Funcionario;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class FuncionarioDAO {
    
    public FuncionarioDAO() {
        
    }
    
    public boolean create(Funcionario funcionario) {
        
        String sql = "INSERT INTO funcionarios (nome) VALUES (?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, funcionario.getNome());
            
            updateValue = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        return updateValue != 0;
    }
    
    public List<Funcionario> readAll() {
        
        String sql = "SELECT * FROM funcionarios ORDER BY id DESC";
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodigo(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {                     
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return funcionarios;
    }
    
    public boolean update(Funcionario employee, int userId) {
        
        String sqlEmployeeUpdate = "UPDATE funcionarios SET nome = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, funcionario_id, action, action_date_time) values (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        int updateEmployee = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlEmployeeUpdate);
            
            statement.setString(1, employee.getNome());
            statement.setInt(2, employee.getCodigo());
            
            updateEmployee = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, employee.getCodigo());
            statement.setString(3, "Funcionário atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        return updateEmployee != 0 && updateAuditHistory != 0;
    }
    
    public boolean delete(Funcionario employee) {
        
        String sqlEmployeeDelete = "DELETE FROM funcionarios WHERE id = ?";
        String sqlAuditHistoryDelete = "DELETE FROM audit_history WHERE funcionario_id=" + employee.getCodigo();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        int deleteEmployee = 0;
        int deleteAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlEmployeeDelete);
            
            statement.setInt(1, employee.getCodigo());
            
            deleteEmployee = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryDelete);
            
            deleteAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return deleteEmployee != 0 && deleteAuditHistory != 0;
    }
    
    public List<Funcionario> search(String nome) {
        
        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            
            nome += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodigo(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return funcionarios;
    }
    
    public List<AuditHistory> getAuditHistory(int employeeId) {
        List<AuditHistory> list = new ArrayList<>();
        
        String sql = "SELECT user_id, funcionario_id, action, action_date_time, login "
                + "FROM audit_history, users "
                + "WHERE audit_history.user_id=users.id AND audit_history.funcionario_id=" + employeeId;
        
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
                
                AuditHistory auditHistory = new AuditHistory(userId, employeeId, action, actionDateTime, userName);
                
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
