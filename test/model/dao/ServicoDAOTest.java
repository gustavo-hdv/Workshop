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
import model.bean.Servico;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ServicoDAOTest {
    
    public ServicoDAOTest() {
    }
    
    @Test
    @Ignore
    public void create() {
        
        Servico servico = new Servico("NomeServico", 1, new BigDecimal(193.23));
        ServicoDAO dao = new ServicoDAO();
        
        if (dao.create(servico)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void readAll() {
        
        ServicoDAO dao = new ServicoDAO();
        
        for(Servico servico: dao.readAll()) {
            System.out.println("_____________________________________________");
            System.out.println("Codigo: " + servico.getCodigo());
            System.out.println("Descrição: " + servico.getDescricao());
            System.out.println("Quantidade: " + servico.getQuantidade());
            System.out.println("Valor Unitario: R$" + servico.getValorUnitario());
            System.out.println("Valor Total: R$" + servico.getValorTotal());
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Servico servico = new Servico("Trocar Painel ABS Traseiro", 2, new BigDecimal(175.64));
        servico.setCodigo(1);
        ServicoDAO dao = new ServicoDAO();
        
        if (dao.update(servico, 0)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            fail("Erro ao atualizar");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Servico servico = new Servico();
        servico.setCodigo(1);
        ServicoDAO dao = new ServicoDAO();
        
        if (dao.delete(servico)) {
            System.out.println("Deletado com sucesso!");
        } else {
            fail("Erro ao deletar");
        }
    }
}
