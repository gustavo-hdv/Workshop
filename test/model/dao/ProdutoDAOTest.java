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
import model.bean.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }
    
    @Test
    @Ignore
    public void create() {
        
        Produto produto = new Produto("NomeProduto", 1, new BigDecimal(193.23));
        ProdutoDAO dao = new ProdutoDAO();
        
        if (dao.create(produto)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void readAll() {
        
        ProdutoDAO dao = new ProdutoDAO();
        
        for(Produto produto: dao.readAll()) {
            System.out.println("_____________________________________________");
            System.out.println("Codigo: " + produto.getCodigo());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Valor Unitario: R$" + produto.getValorUnitario());
            System.out.println("Valor Total: R$" + produto.getValorTotal());
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Produto produto = new Produto("Trocar Painel ABS Traseiro", 2,new BigDecimal( 175.64));
        produto.setCodigo(1);
        ProdutoDAO dao = new ProdutoDAO();
        
        if (dao.update(produto, 0)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            fail("Erro ao atualizar");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Produto produto = new Produto();
        produto.setCodigo(1);
        ProdutoDAO dao = new ProdutoDAO();
        
        if (dao.delete(produto)) {
            System.out.println("Deletado com sucesso!");
        } else {
            fail("Erro ao deletar");
        }
    }
}
