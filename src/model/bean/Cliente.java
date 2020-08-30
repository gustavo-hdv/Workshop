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
public class Cliente {
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private int codigo;
    
    public Cliente() {
        
    }
    
    public Cliente(String nome, String telefone, String email, String endereco) {
        Util.validaString(nome, "Nome não pode ser nulo ou vazio");
        Util.validaNome(nome);
        //Util.validaString(telefone, "Telefone não pode ser nulo ou vazio");
        Util.validaTelefone(telefone);
        //Util.validaString(email, "Email não pode ser nulo ou vazio");
        Util.validaEmail(email);
        //Util.validaString(endereco, "Endereço não pode ser nulo ou vazio");
        Util.validaEndereco(endereco);
        
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Util.validaString(nome, "Nome não pode ser nulo ou vazio");
        Util.validaNome(nome);
        
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //Util.validaString(email, "Email não pode ser nulo ou vazio");
        Util.validaEmail(email);
        
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        //Util.validaString(endereco, "Endereço não pode ser nulo ou vazio");
        Util.validaEndereco(endereco);
        
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        //Util.validaString(telefone, "Telefone não pode ser nulo ou vazio");
        Util.validaTelefone(telefone);
        
        this.telefone = telefone;
    }

    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        Util.validaCodigo(codigo);
        
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return getNome() + " | " + getTelefone();
    }
    
    public String allToString() {
        return getCodigo() + " | " + getNome() + " | " + getTelefone() + " | "
        + getEmail() + " | " + getEndereco(); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo;
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
        final Cliente other = (Cliente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
}