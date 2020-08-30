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
import java.text.NumberFormat;
import java.util.Locale;
import model.util.Util;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class Produto {
    private String descricao;
    //private double valorUnitario;
    private BigDecimal valorUnitario;
    private int quantidade;
    private int codigo;
    
    public Produto() {
        
    }
    
//    public Produto(String descricao, int quantidade, double valorUnitario) {
//        //Util.validaString(descricao, "Descrição inválida");
//        Util.validaDescricaoPS(descricao);
//        Util.validaQuantidade(quantidade);
//        Util.validaValorUnitarioPS(valorUnitario);
//        Util.validaValorTotalPS(valorUnitario * quantidade);
//        
//        this.descricao = descricao;
//        this.quantidade = quantidade;
//        this.valorUnitario = valorUnitario;
//    }
    
    public Produto(String descricao, int quantidade, BigDecimal valorUnitario) {
        //Util.validaString(descricao, "Descrição inválida");
        Util.validaDescricaoPS(descricao);
        Util.validaQuantidade(quantidade);
        Util.validaValorUnitarioPS(valorUnitario);
        //Util.validaValorTotalPS(valorUnitario.multiply(new BigDecimal(quantidade)));
        
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        Util.validaDescricaoPS(descricao);
        Util.validaString(descricao, "Descrição inválida");
        
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        Util.validaCodigo(codigo);
        
        this.codigo = codigo;
    }

    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }
    
    public String getValorUnitarioFormated() {
        return String.format("%.2f", this.valorUnitario);
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        Util.validaValorUnitarioPS(valorUnitario);
        
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        //Util.validaValorTotalPS(valorUnitario.multiply(new BigDecimal(quantidade)));
        
        return this.valorUnitario.multiply(new BigDecimal(this.quantidade));
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public String getQuantidadeFormated() {
        return String.format("%d", this.quantidade);
    }
    
    public void setQuantidade(int quantidade) {
        Util.validaQuantidade(quantidade);
        
        this.quantidade = quantidade;
    }
    
    public String exibirProduto() {
        NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.getDefault());
        
        String unit = moeda.format(this.valorUnitario);
        String total = moeda.format(getValorTotal());
        String produto = String.format("%-8s%-67s%-5s%12s%16s", this.codigo, this.descricao, this.quantidade, unit, total);
        
        return produto;
    }
    
    @Override
    public String toString() {
        String unit = String.format("%,.2f", this.valorUnitario);
        String total = String.format("%,.2f", getValorTotal());
        return this.descricao + " " + this.quantidade + " " + unit + " " + total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    
}
