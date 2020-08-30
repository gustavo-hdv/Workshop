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

import model.bean.Config;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ConfigDAOTest {
    
    public ConfigDAOTest() {
    }
    
    @Test
    @Ignore
    public void read() {
        
        ConfigDAO dao = new ConfigDAO();
        
        Config config = dao.read();
        
        System.out.println("Telefone: " + config.getCellphone());
        System.out.println("Email: " + config.getEmail());
        System.out.println("Endereco: " + config.getAddress());
        System.out.println("Company name: " + config.getCompanyName());
    }
    
    @Test
    @Ignore
    public void update() {
        
        Config config = new Config("Company Name", "(99) 99999-9999", "zzzzzz@outlook.com", "(address)");
        ConfigDAO dao = new ConfigDAO();
        
        if (dao.update(config)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            fail("Erro ao atualizar");
        }
    }
    
}
