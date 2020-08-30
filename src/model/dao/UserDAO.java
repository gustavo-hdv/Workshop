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
import java.util.Collections;
import java.util.List;
import model.bean.AuditHistory;
import model.bean.User;
import model.util.PasswordsUtil;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class UserDAO {
    
    public UserDAO() {
        
    }
    
    public boolean create(User user) {
        String sql = "INSERT INTO users (login, password, is_admin) VALUES (?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, user.getLogin());
            
            String encryptedPassword = PasswordsUtil.encryptPassword(user.getPassword());
            statement.setString(2, encryptedPassword);
            
            statement.setBoolean(3, user.isAdmin());

            updateValue = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateValue != 0;
    }
    
    public boolean updatePassword(User user, int userId) {
        
        String sqlPasswordUpdate = "UPDATE users SET password = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, usuario_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateUserPassword = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlPasswordUpdate);

            String encryptedPassword = PasswordsUtil.encryptPassword(user.getPassword());
            statement.setString(1, encryptedPassword);
            statement.setInt(2, user.getId());

            updateUserPassword = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, user.getId());
            statement.setString(3, "Senha de usuário atualizada");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateUserPassword != 0;
    }
    
    public boolean updateLogin(User user, int userId) {

        String sqlLoginUpdate = "UPDATE users SET login = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, usuario_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateUserLogin = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlLoginUpdate);
            
            statement.setString(1, user.getLogin());    
            statement.setInt(2, user.getId());
            
            updateUserLogin = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, user.getId());
            statement.setString(3, "Login de usuário atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateUserLogin != 0 && updateAuditHistory != 0;
    }
    
    private String getEncryptedPassword(User user) {
        
        String sql = "SELECT password FROM users WHERE id = ?";
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        String encryptedPassword = "";
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, user.getId());
            
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                encryptedPassword = resultSet.getString("password");
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return encryptedPassword;
    }
    
    public List<User> read(boolean admin, int userId) {
        
        List<User> users = new ArrayList<>();
        
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.createStatement();
            String sql = null;
            
            if (admin) {
                sql = "SELECT * FROM users WHERE login !=\"admin\" ORDER BY login";
            } else {
                sql = "SELECT * FROM users WHERE id =" + userId;
            }
            
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                User tempUser = new User();
                
                tempUser.setId(resultSet.getInt("id"));
                tempUser.setAdmin(resultSet.getBoolean("is_admin"));
                tempUser.setLogin(resultSet.getString("login"));
                tempUser.setPassword(resultSet.getString("password"));
                
                users.add(tempUser);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return users;
    }
    
    public List<User> readComboBox() {
        
        List<User> users = new ArrayList<>();
        
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.createStatement();
            String sql = null;
            
            sql = "SELECT * FROM users";
            
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {              
                User user = new User();
                
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
                user.setPassword(resultSet.getString("password"));
                
                users.add(user);
            }
            Collections.reverse(users);
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return users;
    }
    
    public boolean updateAdmin(User user, int userId) {
        
        String sqlAdminUpdate = "UPDATE users SET is_admin = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, usuario_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateUserAdmin = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlAdminUpdate);
            
            statement.setBoolean(1, user.isAdmin());
            statement.setInt(2, user.getId());
            
            updateUserAdmin = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, user.getId());
            statement.setString(3, "Admin de usuário atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateUserAdmin != 0 && updateAuditHistory != 0;
    }
    
    public List<User> search(String login) {
        String sql = "SELECT * FROM users WHERE login LIKE ? AND login != 'admin'";
        
        List<User> users = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            login += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                User user = new User();
                
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
                user.setPassword(resultSet.getString("password"));
                
                users.add(user);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return users;
    }
    
    public boolean delete(User user) {
        
        String sqlUserDelete = "DELETE FROM users WHERE id = ?";
        String sqlAuditHistoryDelete = "DELETE FROM audit_history WHERE usuario_id=" + user.getId();
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int deleteUser = 0;
        int deleteAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlUserDelete);
            statement.setInt(1, user.getId());

            deleteUser = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryDelete);
            
            deleteAuditHistory = statement.executeUpdate(); 
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return deleteUser != 0 && deleteAuditHistory != 0;
    }
    
    public List<AuditHistory> getAuditHistory(int userId) {
        List<AuditHistory> list = new ArrayList<>();
        
        String sql = "SELECT user_id, usuario_id, action, action_date_time, login "
                + "FROM audit_history, users "
                + "WHERE audit_history.user_id=users.id AND audit_history.usuario_id=" + userId;
        
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()) {
                
                int currentUserId = resultSet.getInt("user_id");
                String action = resultSet.getString("action");
                
                Timestamp timestamp = resultSet.getTimestamp("action_date_time");
                java.util.Date actionDateTime = new java.util.Date(timestamp.getTime());
                
                String userName = resultSet.getString("login");
                
                AuditHistory auditHistory = new AuditHistory(currentUserId, userId, action, actionDateTime, userName);
                
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
