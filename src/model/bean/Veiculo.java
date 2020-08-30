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

import model.util.Util;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class Veiculo {
    private int id;
    private String placa;
    private String descricao;
    private String quilometragem;
    private String combustivel;
    private String marcador;
    private String cor;
    
    public Veiculo() {

    }
    
    public Veiculo(String placa, String descricao, String quilometragem, String combustivel, String marcador, String cor) {
        //Util.validaString(placa, "Placa não pode ser nulo ou vazio");
        Util.validaString(descricao, "Descrição não pode ser nulo ou vazio");
        Util.validaPlacaVeiculo(placa);
        Util.validaDescricaoVeiculo(descricao);
        Util.validaQuilometragemVeiculo(quilometragem);
        Util.validaCombustivelVeiculo(combustivel);
        Util.validaMarcadorVeiculo(marcador);
        Util.validaCorVeiculo(cor);
        
        this.placa = placa;
        this.descricao = descricao;
        
        if (isNullOrEmpty(quilometragem)) {
            this.quilometragem = "N/A";
        } else {
            this.quilometragem = quilometragem;
        }
        if (isNullOrEmpty(combustivel)) {
            this.combustivel = "N/A";
        } else {
            this.combustivel = combustivel;
        }
        if (isNullOrEmpty(marcador)) {
            this.marcador = "N/A";
        } else {
            this.marcador = marcador;
        }
        if (isNullOrEmpty(cor)) {
            this.cor = "N/A";
        } else {
            this.cor = cor;
        }
    }
    
    private boolean isNullOrEmpty(String atributo) {
        return atributo == null || atributo.trim().equals("");
    }

    public String getPlaca() {
        return placa;
    }
    
    public int getCodigo() {
        return this.id;
    }
    
    public void setCodigo(int id) {
        Util.validaCodigo(id);
        
        this.id = id;
    }

    public void setPlaca(String placa) {
        //Util.validaString(placa, "Número da placa inválido");
        Util.validaPlacaVeiculo(placa);
        
        this.placa = placa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        Util.validaString(descricao, "Descrição inválida");
        Util.validaDescricaoVeiculo(descricao);
        
        this.descricao = descricao;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        //Util.validaString(quilometragem, "Quilometragem inválida");
        Util.validaQuilometragemVeiculo(quilometragem);
        
        this.quilometragem = quilometragem;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        //Util.validaString(combustivel, "Combustível inválido");
        Util.validaCombustivelVeiculo(combustivel);
        
        this.combustivel = combustivel;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        //Util.validaString(marcador, "Marcador inválido");
        Util.validaMarcadorVeiculo(marcador);
        
        this.marcador = marcador;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        //Util.validaString(cor, "Cor inválida");
        Util.validaCorVeiculo(cor);
        
        this.cor = cor;
    }
    
    @Override
    public String toString() {
        return placa + " | " + descricao + " | " + quilometragem + " | " + combustivel + " | " + marcador + " | " + cor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id;
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
        final Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
