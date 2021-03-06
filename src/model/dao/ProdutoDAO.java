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
import model.bean.Produto;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ProdutoDAO {

    public ProdutoDAO() {
    }
    
    public boolean create(Produto produto) {
        
        String sql = "INSERT INTO produtos (descricao, valor_unitario, quantidade) VALUES (?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, produto.getDescricao());
            statement.setString(2, produto.getValorUnitario().toString());
            statement.setInt(3, produto.getQuantidade());
            
            updateValue = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateValue != 0;
    }
    
    public List<Produto> readAll() {
        
        String sql = "SELECT * FROM produtos ORDER BY id DESC";
        
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Produto produto = new Produto();
                
                produto.setCodigo(resultSet.getInt("id"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setValorUnitario(new BigDecimal(resultSet.getString("valor_unitario").replace(",", ".")));
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {                     
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return produtos;
    }
    
    public boolean update(Produto produto, int userId) {
        
        String sqlProdutoUpdate = "UPDATE produtos SET descricao = ?, quantidade = ?, valor_unitario = ? WHERE id = ?";
        String sqlAuditHistoryUpdate = "INSERT INTO audit_history (user_id, produto_id, action, action_date_time) values (?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateProduct = 0;
        int updateAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlProdutoUpdate);
            
            statement.setString(1, produto.getDescricao());
            statement.setInt(2, produto.getQuantidade());
            statement.setString(3, produto.getValorUnitario().toString());
            statement.setInt(4, produto.getCodigo());
            
            updateProduct = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryUpdate);
            
            statement.setInt(1, userId);
            statement.setInt(2, produto.getCodigo());
            statement.setString(3, "Produto atualizado");
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            
            updateAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateProduct != 0 && updateAuditHistory != 0;
    }
    
    public boolean delete(Produto product) {
        String sqlProductDelete = "DELETE FROM produtos WHERE id = ?";
        String sqlAuditHistoryDelete = "DELETE FROM audit_history WHERE produto_id=" + product.getCodigo();
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int deleteProduct = 0;
        int deleteAuditHistory = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sqlProductDelete);
            
            statement.setInt(1, product.getCodigo());
            
            deleteProduct = statement.executeUpdate();
            
            statement = connection.prepareStatement(sqlAuditHistoryDelete);
            
            deleteAuditHistory = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return deleteProduct != 0 && deleteAuditHistory != 0;
    }
    
    public List<Produto> search(String descricao) {
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM produtos WHERE descricao LIKE ?";

        PreparedStatement statement = null;
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            descricao += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, descricao);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Produto produto = new Produto();
                
                produto.setCodigo(resultSet.getInt("id"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setValorUnitario(new BigDecimal(resultSet.getString("valor_unitario").replace(",", ".")));
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return produtos;
    }
    
    public List<AuditHistory> getAuditHistory(int productId) {
        List<AuditHistory> list = new ArrayList<>();
        
        String sql = "SELECT user_id, produto_id, action, action_date_time, login "
                + "FROM audit_history, users "
                + "WHERE audit_history.user_id=users.id AND audit_history.produto_id=" + productId;
        
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
                
                AuditHistory auditHistory = new AuditHistory(userId, productId, action, actionDateTime, userName);
                
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
