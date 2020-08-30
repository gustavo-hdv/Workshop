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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;
import model.bean.Config;
import model.bean.Funcionario;
import model.bean.Orcamento;
import model.bean.Produto;
import model.bean.Servico;
import model.bean.Veiculo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class OrcamentoDAOTest {
    
    public OrcamentoDAOTest() {
    }
    
    @Test
    @Ignore
    public void create() {
        
        Cliente cliente = new Cliente("Gustavo H.zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz".toUpperCase(), "(83) 98888-888800000", "gustavohenrique0008@hotmail.comzzzzzzzzzzzzzzzzz".toUpperCase(), "Avenida Testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee".toUpperCase());
        cliente.setCodigo(1);
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente);
        
        Funcionario funcionario = new Funcionario("Novo Funcionario");
        funcionario.setCodigo(1);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.create(funcionario);
           
        Servico servico = new Servico("Trocar painel Trocar painel Trocar painel Trocar painel ssssssssss", 500, new BigDecimal(1733887.39));
        servico.setCodigo(1);
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.create(servico);
        Servico servico2 = new Servico("Trocar painel Trocar painel Trocar painel Trocar painel ssssssssss", 500, new BigDecimal(1733887.39));
        servico2.setCodigo(2);
        ServicoDAO servicoDAO2 = new ServicoDAO();
        servicoDAO2.create(servico2);
        Servico servico3 = new Servico("Trocar painel Trocar painel Trocar painel Trocar painel ssssssssss", 500, new BigDecimal(1733887.39));
        servico3.setCodigo(3);
        ServicoDAO servicoDAO3 = new ServicoDAO();
        servicoDAO3.create(servico3);
        Produto produto = new Produto("Painel Painel Painel Painel Painel Painel Painel Painel Painel sss", 102, new BigDecimal(9733333.39));
        produto.setCodigo(1);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.create(produto);
        Produto produto2 = new Produto("Painel Painel Painel Painel Painel Painel Painel Painel Painel sss", 102, new BigDecimal(9733333.39));
        produto2.setCodigo(2);
        ProdutoDAO produtoDAO2 = new ProdutoDAO();
        produtoDAO2.create(produto2);
        Produto produto3 = new Produto("Painel Painel Painel Painel Painel Painel Painel Painel Painel sss", 102, new BigDecimal(9733333.39));
        produto3.setCodigo(3);
        ProdutoDAO produtoDAO3 = new ProdutoDAO();
        produtoDAO3.create(produto3);
        
        Veiculo veiculo = new Veiculo("KJF9E43ZZZZZZZ", "Fiat Unozzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz".toUpperCase(), "944311111", "Aditivadozzzzzzzz".toUpperCase(), "N/Azzzzzz".toUpperCase(), "Cinzazzzzzzzz".toUpperCase());
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.create(veiculo);
 
        ServicoDAO servicoDAOF = new ServicoDAO();
        List<Servico> servicosBD = servicoDAOF.readAll();

        ProdutoDAO produtoDAOF = new ProdutoDAO();
        List<Produto> produtosBD = produtoDAOF.readAll();
        
        ClienteDAO clienteDAOF = new ClienteDAO();
        Cliente clienteBD = clienteDAOF.readAll().get(0);
        
        ConfigDAO empresaDAOF = new ConfigDAO();
        Config empresaBD = empresaDAOF.read();
        
        FuncionarioDAO funcionarioDAOF = new FuncionarioDAO();
        Funcionario funcionarioDB = funcionarioDAOF.readAll().get(0);
        
        VeiculoDAO veiculoDAOF = new VeiculoDAO();
        Veiculo veiculoBD = veiculoDAOF.readAll().get(0);
        
        String defeitosApontados = "Painel quebrado Painel quebrado Painel quebrado Painel quebrado Painel quebrado Painel quebrado Painel quebrado sssssssss".toUpperCase();
        String observacoes = "Trocar o painel do lado esquerdo Trocar o painel do lado esquerdo Trocar o painel do lado esquerdo ssssssssssssssssssssss".toUpperCase();
        String formaPagamento = "ESPECIEzzzzzzzzzzzz";
        
        Orcamento orcamento = new Orcamento();
        orcamento.setCliente(clienteBD);
        orcamento.setDefeitosApontados(defeitosApontados);
        orcamento.setObservacoes(observacoes);
        orcamento.setFormaPagamento(formaPagamento);
        orcamento.setServicos(servicosBD);
        orcamento.setProdutos(produtosBD);
        orcamento.setVeiculo(veiculoBD);
        orcamento.setFuncionario(funcionario);
        
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
        
        if (orcamentoDAO.create(orcamento)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void readAll() {
        
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
        
        for(Orcamento orcamento : orcamentoDAO.readAll()) {
            System.out.println("Número do orçamento: " + orcamento.getCodigo());
            System.out.println("Data e hora da última modificação: " + orcamento.getDataHora());
            System.out.println("");
            System.out.println("Código do cliente: " + orcamento.getCliente().getCodigo());
            System.out.println("Nome do cliente: " + orcamento.getCliente().getNome());
            System.out.println("Telefone do cliente: " + orcamento.getCliente().getTelefone());
            System.out.println("Email do cliente: " + orcamento.getCliente().getEmail());
            System.out.println("Endereco do cliente: " + orcamento.getCliente().getEndereco());
            System.out.println("");
            System.out.println("Código do funcionário: " + orcamento.getFuncionario().getCodigo());
            System.out.println("Nome do funcionário: " + orcamento.getFuncionario().getNome());
            System.out.println("");
            System.out.println("Placa do veículo: " + orcamento.getVeiculo().getPlaca());
            System.out.println("Descrição do veículo: " + orcamento.getVeiculo().getDescricao());
            System.out.println("Quilometragem do veículo: " + orcamento.getVeiculo().getQuilometragem());
            System.out.println("Combustível do veículo: " + orcamento.getVeiculo().getCombustivel());
            System.out.println("Marcador do veículo: " + orcamento.getVeiculo().getMarcador());
            System.out.println("Cor do veículo: " + orcamento.getVeiculo().getCor());
            System.out.println("");
            System.out.println("Defeitos apontados: " + orcamento.getDefeitosApontados());
            System.out.println("Observacoes: " + orcamento.getObservacoes());
            System.out.println("");
            for(Servico servico : orcamento.getServicos()) {
                System.out.println("Código do serviço: " + servico.getCodigo());
                System.out.println(" Descrição: " + servico.getDescricao());
                System.out.println(" Quantidade: " + servico.getQuantidade());
                System.out.println(" Valor unitário: R$" + String.format("%,.2f", servico.getValorUnitario()));
                System.out.println(" Valor total: R$" + String.format("%,.2f", servico.getValorTotal()));
            }
            System.out.println("");
            for(Produto produto : orcamento.getProdutos()) {
                System.out.println("Código do produto: " + produto.getCodigo());
                System.out.println(" Descrição: " + produto.getDescricao());
                System.out.println(" Quantidade: " + produto.getQuantidade());
                System.out.println(" Valor unitário: R$" + String.format("%,.2f", produto.getValorUnitario()));
                System.out.println(" Valor total: R$" + String.format("%,.2f", produto.getValorTotal()));
            }
            System.out.println("");
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Cliente cliente = new Cliente("Gustavo H.".toUpperCase(), "(83) 98888-8888", "gustavohenrique0008@hotmail.com".toUpperCase(), "Avenida Teste".toUpperCase());
        cliente.setCodigo(1);
     
        Funcionario funcionario = new Funcionario("Novo Funcionario");
        funcionario.setCodigo(1);
           
        Servico servico = new Servico("Trocar painel", 1, new BigDecimal(1787.39));
        servico.setCodigo(1);

        Servico servico2 = new Servico("Trocar painel dois", 1, new BigDecimal(173387.39));
        servico2.setCodigo(2);

        Servico servico3 = new Servico("Trocar painel três", 1, new BigDecimal(17387.39));
        servico3.setCodigo(3);

        List<Servico> servicos = new ArrayList<>();
        servicos.add(servico);
        servicos.add(servico2);
        servicos.add(servico3);
             
        Produto produto = new Produto("Painel", 1, new BigDecimal(933.39));
        produto.setCodigo(1);

        Produto produto2 = new Produto("Painel dois", 1, new BigDecimal(9733.39));
        produto2.setCodigo(2);

        Produto produto3 = new Produto("Painel três", 2, new BigDecimal(97333.39));
        produto3.setCodigo(3);
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        produtos.add(produto2);
        produtos.add(produto3);
        
        Veiculo veiculo = new Veiculo("KJF-9E43", "Fiat Uno".toUpperCase(), "941111", "Aditivado".toUpperCase(), "Metade".toUpperCase(), "Cinza".toUpperCase());
        
        String defeitosApontados = "Painel quebrado ".toUpperCase();
        String observacoes = "Trocar o painel do lado esquerdo ".toUpperCase();
        String formaPagamento = "ESPECIE";
        
        Orcamento orcamento = new Orcamento();
        orcamento.setCodigo(1);
        
        orcamento.setCliente(cliente);
        orcamento.setDefeitosApontados(defeitosApontados);
        orcamento.setObservacoes(observacoes);
        orcamento.setFormaPagamento(formaPagamento);
        orcamento.setServicos(servicos);
        orcamento.setProdutos(produtos);
        orcamento.setVeiculo(veiculo);
        orcamento.setFuncionario(funcionario);
        
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
        
        if (orcamentoDAO.update(orcamento)) {
            System.out.println("Atualizado com sucesso");
        } else {
            fail("Erro ao atualizar!");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Orcamento orcamento = new Orcamento();
        orcamento.setCodigo(1);
        OrcamentoDAO dao = new OrcamentoDAO();
        
        if (dao.delete(orcamento)) {
            System.out.println("Deletado com sucesso!");
        } else {
            fail("Erro ao deletar");
        }
    }
}
