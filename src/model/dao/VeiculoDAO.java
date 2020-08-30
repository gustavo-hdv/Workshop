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
import model.bean.Veiculo;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class VeiculoDAO {

    public VeiculoDAO() {

    }
    
    public boolean create(Veiculo veiculo) {
        
        String sql = "INSERT INTO veiculos (placa, descricao, quilometragem, combustivel, marcador, cor) VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getDescricao());
            statement.setString(3, veiculo.getQuilometragem());
            statement.setString(4, veiculo.getCombustivel());
            statement.setString(5, veiculo.getMarcador());
            statement.setString(6, veiculo.getCor());
            
            updateValue = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateValue != 0;
    }
    
    public List<Veiculo> readAll() {
        
        String sql = "SELECT * FROM veiculos";
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        List<Veiculo> veiculos = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Veiculo veiculo = new Veiculo();
                
                veiculo.setCodigo(resultSet.getInt("id"));
                veiculo.setPlaca(resultSet.getString("placa"));
                veiculo.setDescricao(resultSet.getString("descricao"));
                veiculo.setQuilometragem(resultSet.getString("quilometragem"));
                veiculo.setCombustivel(resultSet.getString("combustivel"));
                veiculo.setMarcador(resultSet.getString("marcador"));
                veiculo.setCor(resultSet.getString("cor"));
                
                veiculos.add(veiculo);
            }
        } catch (SQLException ex) {                     
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return veiculos;
    }
    
    public boolean update(Veiculo vehicle, int userId) {
        
        String sqlVehicleUpdate = "UPDATE veiculos SET placa = ?, descricao = ?, quilometragem = ?, combustivel = ?, marcador = ?, cor = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, veiculo_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateVehicle = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlVehicleUpdate);
            
            statement.setString(1, vehicle.getPlaca());
            statement.setString(2, vehicle.getDescricao());
            statement.setString(3, vehicle.getQuilometragem());
            statement.setString(4, vehicle.getCombustivel());
            statement.setString(5, vehicle.getMarcador());
            statement.setString(6, vehicle.getCor());
            statement.setInt(7, vehicle.getCodigo());
            
            updateVehicle = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, vehicle.getCodigo());
            statement.setString(3, "Veículo atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
           
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateVehicle != 0 && updateAuditHistory != 0;
    }
    
    public boolean delete(Veiculo vehicle) {
        String sqlVehicleDelete = "DELETE FROM veiculos WHERE id = ?";
        String sqlAuditHistoryDelete = "DELETE FROM audit_history WHERE veiculo_id=" + vehicle.getCodigo();
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int deleteVehicle = 0;
        int deleteAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlVehicleDelete);
            statement.setInt(1, vehicle.getCodigo());
            
            deleteVehicle = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryDelete);
            
            deleteAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return deleteVehicle != 0 && deleteAuditHistory != 0;
    }
    
    public List<Veiculo> search(String placa) {
        
        String sql = "SELECT * FROM veiculos WHERE placa LIKE ?";
       
        List<Veiculo> veiculos = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            placa += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, placa);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Veiculo veiculo = new Veiculo();
                
                veiculo.setPlaca(resultSet.getString("placa"));
                veiculo.setDescricao(resultSet.getString("descricao"));
                veiculo.setQuilometragem(resultSet.getString("quilometragem"));
                veiculo.setCombustivel(resultSet.getString("combustivel"));
                veiculo.setMarcador(resultSet.getString("marcador"));
                veiculo.setCor(resultSet.getString("cor"));
                
                veiculos.add(veiculo);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return veiculos;
    }
    
    public List<AuditHistory> getAuditHistory(int vehicleId) {
        List<AuditHistory> list = new ArrayList<>();
        
        String sql = "SELECT user_id, veiculo_id, action, action_date_time, login "
                + "FROM audit_history, users "
                + "WHERE audit_history.user_id=users.id AND audit_history.veiculo_id=" + vehicleId;
        
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
                
                AuditHistory auditHistory = new AuditHistory(userId, vehicleId, action, actionDateTime, userName);
                
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
