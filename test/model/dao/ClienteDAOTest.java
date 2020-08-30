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

import model.bean.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    @Test
    @Ignore
    public void create() {
        
        Cliente cliente = new Cliente("Gustavo Henrique", "(83) 98888-7777", "gustavohenrique88888@hotmail.com", "Cliente address");
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.create(cliente)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void readAll() {
        
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente cliente: dao.readAll()) {
            System.out.println("_____________________________________________");
            System.out.println("Codigo: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Endereco: " + cliente.getEndereco());
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Cliente cliente = new Cliente("Gustavo Henrique D. Ventura", "(83) 98888-7777", "gustavohenrique88888@hotmail.com", "Cliente address");
        cliente.setCodigo(1);
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.update(cliente, 1)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            fail("Erro ao atualizar");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Cliente cliente = new Cliente();
        cliente.setCodigo(3);
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.delete(cliente)) {
            System.out.println("Deletado com sucesso!");
        } else {
            fail("Erro ao deletar");
        }
    }
}
