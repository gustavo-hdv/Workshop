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
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:db/sqlitejava.db";
        
        try {  
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro na conexão" + e);
        }
    }
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }       
        closeConnection(connection);
    }
    
    public static void closeConnection(Connection connection, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }       
        closeConnection(connection);
    }
    
    public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(connection, stmt);
    }
    
    public static void closeConnection(Connection connection, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(connection, stmt);
    }
}
