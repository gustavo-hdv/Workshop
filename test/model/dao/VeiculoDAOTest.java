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

import model.bean.Veiculo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class VeiculoDAOTest {
    
    public VeiculoDAOTest() {
    }
    
    @Test
    @Ignore
    public void create() {
        
        Veiculo veiculo = new Veiculo("KFJ-5484", "Fiat Uno", "104.304", "Gasolina", "Metade", "Prata");
        VeiculoDAO dao = new VeiculoDAO();
        
        if (dao.create(veiculo)) {
            System.out.println("Salvo com sucesso!");
        } else {
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void readAll() {
        
        VeiculoDAO dao = new VeiculoDAO();
        
        for(Veiculo veiculo: dao.readAll()) {
            System.out.println("_____________________________________________");
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Descrição: " + veiculo.getDescricao());
            System.out.println("Quilometragem: " + veiculo.getQuilometragem() + "KM");
            System.out.println("Combustível: " + veiculo.getCombustivel());
            System.out.println("Marcador: " + veiculo.getMarcador());
            System.out.println("Cor: " + veiculo.getCor());
        }
    }
    
    @Test
    @Ignore
    public void update() {
        
        Veiculo veiculo = new Veiculo("KFJ-5484", "Fiat Uno", "134.304", "Gasolina", "Início", "Preto");
        VeiculoDAO dao = new VeiculoDAO();
        
        if (dao.update(veiculo, 0)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            fail("Erro ao atualizar");
        }
    }
    
    @Test
    @Ignore
    public void delete() {
        
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("KFJ-5484");
        VeiculoDAO dao = new VeiculoDAO();
        
        if (dao.delete(veiculo)) {
            System.out.println("Deletado com sucesso!");
        } else {
            fail("Erro ao deletar");
        }
    }
}
