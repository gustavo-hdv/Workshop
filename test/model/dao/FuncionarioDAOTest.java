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

import model.bean.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class FuncionarioDAOTest {
    
    public FuncionarioDAOTest() {
    }
    
    @Test
    @Ignore
    public void create() {
        
        Funcionario funcionario = new Funcionario("Gustavo H.");
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if (dao.create(funcionario)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void readAll() {
        
        FuncionarioDAO dao = new FuncionarioDAO();
        
        for(Funcionario funcionario: dao.readAll()) {
            System.out.println("_____________________________________________");
            System.out.println("Codigo: " + funcionario.getCodigo());
            System.out.println("Nome: " + funcionario.getNome());
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Funcionario funcionario = new Funcionario("Gustavo Henrique D. Ventura");
        funcionario.setCodigo(1);
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if (dao.update(funcionario, 0)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            fail("Erro ao atualizar");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(1);
        FuncionarioDAO dao = new FuncionarioDAO();
        
        if (dao.delete(funcionario)) {
            System.out.println("Deletado com sucesso!");
        } else {
            fail("Erro ao deletar");
        }
    }
}
