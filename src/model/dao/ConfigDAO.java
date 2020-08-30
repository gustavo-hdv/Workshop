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
import model.bean.Config;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ConfigDAO {
    
    public ConfigDAO() {
    }
    
    public Config read() {

        String sqlRead = "SELECT * FROM config";
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        Config config = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlRead);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                config = new Config();
                config.setCellphone(resultSet.getString("telefone"));
                config.setEmail(resultSet.getString("email"));
                config.setAddress(resultSet.getString("endereco"));
                config.setCompanyName(resultSet.getString("company_name"));
                
                return config;
            }
        } catch (SQLException ex) {                     
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return config;
    }
    
    public boolean update(Config config) {
        
        String sql = "UPDATE config SET telefone = ?, email = ?, endereco = ?, company_name = ? WHERE id = 1";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateConfig = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, config.getCellphone());
            statement.setString(2, config.getEmail());
            statement.setString(3, config.getAddress());
            statement.setString(4, config.getCompanyName());
            
            updateConfig = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateConfig != 0;
    }
}
