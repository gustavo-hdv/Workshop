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

package mode.bean;

import java.math.BigDecimal;
import model.bean.Servico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class ServicoTeste {
    
    public ServicoTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructServico() {
        try {
            Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void constructServicoDescricaoNuloVazio() {
        try {
            Servico servico = new Servico("", 1, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException npe) {
            
        }
        
                try {
            Servico servico = new Servico(null, 1, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
    }
    
    @Test
    public void constructServicoQtdInvalida() {
        try {
            Servico servico = new Servico("Trocar Painel", 0, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
        try {
            Servico servico = new Servico("Trocar Painel", -1, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
    }
    
    @Test
    public void constructServicoValorInvalido() {
        try {
            Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(0));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
        try {
            Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(-180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
    }
    
    @Test
    public void getDescricao() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            assertEquals(servico.getDescricao(), "Trocar Painel");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setDescricao() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        assertEquals(servico.getDescricao(), "Trocar Painel");
        try {
            servico.setDescricao("Trocar Sensor LE");
            assertEquals(servico.getDescricao(), "Trocar Sensor LE");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setDescricaoNuloVazio() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        assertEquals(servico.getDescricao(), "Trocar Painel");
        try {
            servico.setDescricao("");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            servico.setDescricao(null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
    }
    
    @Test
    public void getQuantidade() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            assertEquals(servico.getQuantidade(), 1);
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setQuantidade() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        assertEquals(servico.getQuantidade(), 1);
        try {
            servico.setQuantidade(2);
            assertEquals(servico.getQuantidade(), 2);          
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setQuantidadeNuloVazio() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            servico.setQuantidade(0);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            servico.setQuantidade(-1);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
    }
    
    @Test
    public void getValorUnitario() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            if (servico.getValorUnitario() != new BigDecimal(180.57)) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setValorUnitario() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            servico.setValorUnitario(new BigDecimal(217.9));
            if (servico.getValorUnitario().compareTo(new BigDecimal(217.9)) != 217.9) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setValorUnitarioInvalido() {
        Servico servico = new Servico("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            servico.setValorUnitario(new BigDecimal(-217.8));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            servico.setValorUnitario(new BigDecimal(0.0));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
    }
    
    @Test
    public void getValorTotal() {
        Servico servico = new Servico("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            if (servico.getValorTotal().compareTo(new BigDecimal(361.14)) != 361.14) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void exibirServico() {
        Servico servico = new Servico("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            assertEquals(servico.toString(), "Trocar Painel 2 180,57 361,14");
            servico.setValorUnitario(new BigDecimal(1800.57));
            assertEquals(servico.toString(), "Trocar Painel 2 1.800,57 3.601,14");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setANDgetCodigo() {
        Servico servico = new Servico("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            servico.setCodigo(1);
            assertEquals(servico.getCodigo(), 1);
            servico.setCodigo(3);
            assertEquals(servico.getCodigo(), 3);
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setCodigoInvalido() {
        Servico servico = new Servico("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            servico.setCodigo(-1);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            servico.setCodigo(0);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
    }
}
