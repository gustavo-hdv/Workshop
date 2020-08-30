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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Orcamento;
import model.bean.Produto;
import model.bean.Servico;
import model.bean.Veiculo;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class OrcamentoDAO {
    
    public OrcamentoDAO() {
    }
    
    private String getOrcamentoServicosIDS(Orcamento orcamento) {
        String servicos_ids = "";
        int qtdServicos = orcamento.getServicos().size();
        for(int i=0; i < qtdServicos; i++) {
            if (i != qtdServicos-1) {
                servicos_ids += orcamento.getServicos().get(i).getCodigo() + " ";
            } else {
                servicos_ids += orcamento.getServicos().get(i).getCodigo();
            }
        }
        return servicos_ids;
    }
    
    private String getOrcamentoProdutosIDS(Orcamento orcamento) {
        String produtos_ids = "";
        int qtdProdutos = orcamento.getProdutos().size();
        for(int i=0; i < qtdProdutos; i++) {
            if (i != qtdProdutos-1) {
                produtos_ids += orcamento.getProdutos().get(i).getCodigo() + " ";
            } else {
                produtos_ids += orcamento.getProdutos().get(i).getCodigo();
            }
        }
        return produtos_ids;
    }
    
    public boolean create(Orcamento orcamento) {
        
        String sql = "INSERT INTO orcamentos (data_hora, forma_pagamento, defeitos_apontados, observacoes, cliente_id, funcionario_id, veiculo_id, servicos_ids, produtos_ids) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        String servicos_ids = getOrcamentoServicosIDS(orcamento);    
        String produtos_ids = getOrcamentoProdutosIDS(orcamento);
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, orcamento.getDataHora());
            statement.setString(2, orcamento.getFormaPagamento());
            statement.setString(3, orcamento.getDefeitosApontados());
            statement.setString(4, orcamento.getObservacoes());
            statement.setInt(5, orcamento.getCliente().getCodigo());
            statement.setInt(6, orcamento.getFuncionario().getCodigo());
            statement.setInt(7, orcamento.getVeiculo().getCodigo());
            statement.setString(8, servicos_ids);
            statement.setString(9, produtos_ids);
            
            updateValue = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        return updateValue != 0;
    }
    
    public List<Orcamento> readAll() {
        
        String sql = "SELECT * FROM view_orcamentoinner ORDER BY id_orcamento DESC";
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        
        List<Orcamento> orcamentos = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Orcamento orcamento = new Orcamento();
                
                orcamento.setCodigo(resultSet.getInt("id_orcamento"));
                orcamento.setDataHora(resultSet.getString("data_hora"));
                orcamento.setFormaPagamento(resultSet.getString("forma_pagamento"));
                orcamento.setDefeitosApontados(resultSet.getString("defeitos_apontados"));
                orcamento.setObservacoes(resultSet.getString("observacoes"));
                
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultSet.getInt("cliente_id"));
                cliente.setNome(resultSet.getString("cliente_nome"));
                cliente.setTelefone(resultSet.getString("cliente_telefone"));
                cliente.setEmail(resultSet.getString("cliente_email"));
                cliente.setEndereco(resultSet.getString("cliente_endereco"));
                orcamento.setCliente(cliente);
                
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultSet.getInt("funcionario_id"));
                funcionario.setNome(resultSet.getString("funcionario_nome"));
                orcamento.setFuncionario(funcionario);
                
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(resultSet.getInt("veiculo_id"));
                veiculo.setPlaca(resultSet.getString("veiculo_placa"));
                veiculo.setDescricao(resultSet.getString("veiculo_descricao"));
                veiculo.setQuilometragem(resultSet.getString("veiculo_quilometragem"));
                veiculo.setCombustivel(resultSet.getString("veiculo_combustivel"));
                veiculo.setMarcador(resultSet.getString("veiculo_marcador"));
                veiculo.setCor(resultSet.getString("veiculo_cor"));
                orcamento.setVeiculo(veiculo);
                

                String servicos_ids = resultSet.getString("servicos_ids");
                String produtos_ids = resultSet.getString("produtos_ids");
                orcamento.setServicos(getServicos(servicos_ids));
                orcamento.setProdutos(getProdutos(produtos_ids));
                
                orcamentos.add(orcamento);
            }
        } catch (SQLException ex) {                     
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return orcamentos;
    }

    private List<Servico> getServicos(String servicos_ids) {
        List<String> idsList = Arrays.asList(servicos_ids.split(" "));
        List<Servico> servicos = new ArrayList<>();
        
        if (!idsList.isEmpty()) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            Connection connection = null;
            for (int i=0; i < idsList.size(); i++) {
                String sqlProduto = "SELECT * FROM servicos WHERE id = " + idsList.get(i);
                try {
                    connection = ConnectionFactory.getConnection();
                    statement = connection.prepareStatement(sqlProduto);
                    resultSet = statement.executeQuery();
                
                    while (resultSet.next()) {
                        Servico servico = new Servico();

                        servico.setCodigo(resultSet.getInt("id"));
                        servico.setDescricao(resultSet.getString("descricao"));
                        servico.setQuantidade(resultSet.getInt("quantidade"));
                        servico.setValorUnitario(new BigDecimal(resultSet.getString("valor_unitario")));

                        servicos.add(servico);
                    }
                } catch (SQLException ex) {
                    System.err.println("Erro: " + ex);
                } finally {
                    ConnectionFactory.closeConnection(connection, statement, resultSet);
                }
            }
        }
        return servicos;
    }
    
    private List<Produto> getProdutos(String produtos_ids) { 
        List<String> idsList = Arrays.asList(produtos_ids.split(" "));
        List<Produto> produtos = new ArrayList<>();
        
        if (!idsList.isEmpty()) {
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            Connection connection = null;
            for (int i=0; i < idsList.size(); i++) {
                String sqlProduto = "SELECT * FROM produtos WHERE id = " + idsList.get(i);
                try {
                    connection = ConnectionFactory.getConnection();
                    statement = connection.prepareStatement(sqlProduto);
                    resultSet = statement.executeQuery();
                    
                    while (resultSet.next()) {
                        Produto produto = new Produto();

                        produto.setCodigo(resultSet.getInt("id"));
                        produto.setDescricao(resultSet.getString("descricao"));
                        produto.setQuantidade(resultSet.getInt("quantidade"));
                        produto.setValorUnitario(new BigDecimal(resultSet.getString("valor_unitario")));

                        produtos.add(produto);
                    }
                } catch (SQLException ex) {
                    System.err.println("Erro: " + ex);
                } finally {
                    ConnectionFactory.closeConnection(connection, statement, resultSet);
                }
            }
        }
        return produtos;
    }
    

    public boolean update(Orcamento orcamento) {
        
        String sql = "UPDATE orcamentos SET data_hora = ?, forma_pagamento = ?, defeitos_apontados = ?, observacoes = ?, cliente_id = ?, funcionario_id = ?, veiculo_id = ?, servicos_ids = ?, produtos_ids = ? WHERE id_orcamento = ?";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        String servicos_ids = getOrcamentoServicosIDS(orcamento);    
        String produtos_ids = getOrcamentoProdutosIDS(orcamento);
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, orcamento.getDataHora());
            statement.setString(2, orcamento.getFormaPagamento());
            statement.setString(3, orcamento.getDefeitosApontados());
            statement.setString(4, orcamento.getObservacoes());
            statement.setInt(5, orcamento.getCliente().getCodigo());
            statement.setInt(6, orcamento.getFuncionario().getCodigo());
            statement.setInt(7, orcamento.getVeiculo().getCodigo());
            statement.setString(8, servicos_ids);
            statement.setString(9, produtos_ids);
            statement.setInt(10, orcamento.getCodigo());
            
            updateValue = statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);        
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateValue != 0;
    }
    
    public boolean delete(Orcamento orcamento) {
        String sql = "DELETE FROM orcamentos WHERE id_orcamento = ?";
        
        PreparedStatement statement = null;
        Connection connection = null;
        
        int updateValue = 0;
        
        try {
            connection = ConnectionFactory.getConnection();
            
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, orcamento.getCodigo());
            
            updateValue = statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return updateValue != 0;
    }
    
    public List<Orcamento> search(String defeitosApontados) {
        String sql = "SELECT * FROM view_orcamentoinner WHERE defeitos_apontados LIKE ?";
        
        List<Orcamento> orcamentos = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
            
        try {
            connection = ConnectionFactory.getConnection();
            
            defeitosApontados += "%";
            statement = connection.prepareStatement(sql);
            statement.setString(1, defeitosApontados);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Orcamento orcamento = new Orcamento();
                
                orcamento.setCodigo(resultSet.getInt("id_orcamento"));
                orcamento.setDataHora(resultSet.getString("data_hora"));
                orcamento.setFormaPagamento(resultSet.getString("forma_pagamento"));
                orcamento.setDefeitosApontados(resultSet.getString("defeitos_apontados"));
                orcamento.setObservacoes(resultSet.getString("observacoes"));
                
                Cliente cliente = new Cliente();
                cliente.setCodigo(resultSet.getInt("cliente_id"));
                cliente.setNome(resultSet.getString("cliente_nome"));
                cliente.setTelefone(resultSet.getString("cliente_telefone"));
                cliente.setEmail(resultSet.getString("cliente_email"));
                cliente.setEndereco(resultSet.getString("cliente_endereco"));
                orcamento.setCliente(cliente);
                
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultSet.getInt("funcionario_id"));
                funcionario.setNome(resultSet.getString("funcionario_nome"));
                orcamento.setFuncionario(funcionario);
                
                Veiculo veiculo = new Veiculo();
                veiculo.setCodigo(resultSet.getInt("veiculo_id"));
                veiculo.setPlaca(resultSet.getString("veiculo_placa"));
                veiculo.setDescricao(resultSet.getString("veiculo_descricao"));
                veiculo.setQuilometragem(resultSet.getString("veiculo_quilometragem"));
                veiculo.setCombustivel(resultSet.getString("veiculo_combustivel"));
                veiculo.setMarcador(resultSet.getString("veiculo_marcador"));
                veiculo.setCor(resultSet.getString("veiculo_cor"));
                orcamento.setVeiculo(veiculo);

                String servicos_ids = resultSet.getString("servicos_ids");
                String produtos_ids = resultSet.getString("produtos_ids");
                
                orcamento.setServicos(getServicos(servicos_ids));
                orcamento.setProdutos(getProdutos(produtos_ids));
                
                orcamentos.add(orcamento);
            }
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return orcamentos;
    }
}
