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
package model.bean;

import java.math.BigDecimal;
import model.util.Util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class Orcamento {
    private int codigo;
    private String dataHora;
    private String formaPagamento;
    private String defeitosApontados;
    private String observacoes;

    private Cliente cliente;
    private Veiculo veiculo;
    private Funcionario funcionario;
    private List<Servico> servicos;
    private List<Produto> produtos;
    
    public Orcamento() {
        this.dataHora = defineDataHora();
        
        this.servicos = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }
    
    public Orcamento(String formaPagamento, String defeitosApontados, String observacoes, Cliente cliente, Funcionario funcionario, Veiculo veiculo, ArrayList<Servico> servicos, ArrayList<Produto> produtos) {
        Util.validaCliente(cliente);
        Util.validaArrayServicos(servicos);
        Util.validaArrayProdutos(produtos);
        Util.validaVeiculo(veiculo);
        Util.validaFuncionario(funcionario);
        Util.validaDefeitosAndObservacoes(defeitosApontados);
        Util.validaDefeitosAndObservacoes(observacoes);
        Util.validaFormaPagamento(formaPagamento);
        
        this.cliente = cliente;
        this.servicos = servicos;
        this.produtos = produtos;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.defeitosApontados = defeitosApontados;
        this.observacoes = observacoes;
        this.formaPagamento = formaPagamento;
        this.dataHora = defineDataHora();
    }
    
    private String defineDataHora() {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yy - HH:mm:ss");
        Date data = new Date();
        return formatoData.format(data);
    }
    
    public void setDataHora(String dataHora) {
        Util.validaString(dataHora, "Data/Hora não pode ser nulo ou vazio");
        
        this.dataHora = dataHora;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        Util.validaFuncionario(funcionario);
        
        this.funcionario = funcionario;
    }
    
    public String getDataHora() {
        return this.dataHora;
    }
    
    public void setServicos(List<Servico> servicos) {
        Util.validaArrayServicos(servicos);
        
        this.servicos = servicos;
    }
    
    public List<Servico> getServicos() {
        return this.servicos;
    }
    
    public void adicionaServico(Servico servico) {
        Util.validaServico(servico);
        
        this.servicos.add(servico);
    }
    
    public void setProdutos(List<Produto> produtos) {
        Util.validaArrayProdutos(produtos);
        
        this.produtos = produtos;
    }
    
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void adicionaProduto(Produto produto) {
        Util.validaProduto(produto);
        
        this.produtos.add(produto);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        Util.validaCodigo(codigo);
        
        this.codigo = codigo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Util.validaCliente(cliente);
        
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    public void setVeiculo(Veiculo veiculo) {
        Util.validaVeiculo(veiculo);
        
        this.veiculo = veiculo;
    }

    public String getDefeitosApontados() {
        return defeitosApontados;
    }

    public void setDefeitosApontados(String defeitosApontados) {
        //Util.validaString(defeitosApontados, "Defeitos apontados não pode ser nulo ou vazio");
        Util.validaDefeitosAndObservacoes(defeitosApontados);
        
        this.defeitosApontados = defeitosApontados;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        //Util.validaString(observacoes, "Observações não pode ser nulo ou vazio");
        Util.validaDefeitosAndObservacoes(observacoes);
        
        this.observacoes = observacoes;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        //Util.validaString(formaPagamento, "Forma de pagamento não pode ser nulo ou vazio");
        Util.validaFormaPagamento(formaPagamento);
        
        this.formaPagamento = formaPagamento;
    }
    
    public BigDecimal getValorTotalProdutos() {
        List<BigDecimal> productsValues = new ArrayList<>();
        this.produtos.forEach((produto) -> {
            productsValues.add(produto.getValorTotal());
        });
        BigDecimal total = productsValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }
    
    public BigDecimal getValorTotalServicos() {
        List<BigDecimal> servicesValues = new ArrayList<>();
        this.servicos.forEach((servico) -> {
            servicesValues.add(servico.getValorTotal());
        });
        BigDecimal total = servicesValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    public String listaServicos() {
        String listaServicos = "";
        for(int i=0; i < servicos.size(); i++) {
            if (i==0) {
                listaServicos += servicos.get(i).exibirServico() + System.lineSeparator();
            }
            else if (i != servicos.size()-1) {
                listaServicos += " " + servicos.get(i).exibirServico() + System.lineSeparator();
            } else {
                listaServicos += " " + servicos.get(i).exibirServico();
            }
        }
        return listaServicos;
    }
    
    public String listaProdutos() {
        String listaProdutos = "";
        for(int i=0; i < produtos.size(); i++) {
            if (i==0) {
                listaProdutos += produtos.get(i).exibirProduto() + System.lineSeparator();
            }
            else if (i != produtos.size()-1) {
                listaProdutos += " " + produtos.get(i).exibirProduto() + System.lineSeparator();
            } else {
                listaProdutos += " " + produtos.get(i).exibirProduto();
            }
        }
        return listaProdutos;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orcamento other = (Orcamento) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }      
}
