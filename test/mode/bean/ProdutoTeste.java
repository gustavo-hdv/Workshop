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
import model.bean.Produto;
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
public class ProdutoTeste {
    
    public ProdutoTeste() {
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
    public void constructProduto() {
        try {
            Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void constructProdutoDescricaoNuloVazio() {
        try {
            Produto produto = new Produto("", 1, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException npe) {
            
        }
        
                try {
            Produto produto = new Produto(null, 1, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
    }
    
    @Test
    public void constructProdutoQtdInvalida() {
        try {
            Produto produto = new Produto("Trocar Painel", 0, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
        try {
            Produto produto = new Produto("Trocar Painel", -1, new BigDecimal(180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
    }
    
    @Test
    public void constructProdutoValorInvalido() {
        try {
            Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(0));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
        try {
            Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(-180.57));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
           
        }
    }
    
    @Test
    public void getDescricao() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            assertEquals(produto.getDescricao(), "Trocar Painel");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setDescricao() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        assertEquals(produto.getDescricao(), "Trocar Painel");
        try {
            produto.setDescricao("Trocar Sensor LE");
            assertEquals(produto.getDescricao(), "Trocar Sensor LE");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setDescricaoNuloVazio() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        assertEquals(produto.getDescricao(), "Trocar Painel");
        try {
            produto.setDescricao("");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            produto.setDescricao(null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
    }
    
    @Test
    public void getQuantidade() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            assertEquals(produto.getQuantidade(), 1);
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setQuantidade() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        assertEquals(produto.getQuantidade(), 1);
        try {
            produto.setQuantidade(2);
            assertEquals(produto.getQuantidade(), 2);          
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setQuantidadeNuloVazio() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            produto.setQuantidade(0);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            produto.setQuantidade(-1);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
    }
    
    @Test
    public void getValorUnitario() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            if (produto.getValorUnitario() != new BigDecimal(180.57)) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setValorUnitario() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            produto.setValorUnitario(new BigDecimal(217.9));
            if (produto.getValorUnitario().compareTo(new BigDecimal(217.9)) != 217.9) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setValorUnitarioInvalido() {
        Produto produto = new Produto("Trocar Painel", 1, new BigDecimal(180.57));
        try {
            produto.setValorUnitario(new BigDecimal(-217.8));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            produto.setValorUnitario(new BigDecimal(0.0));
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
    }
    
    @Test
    public void getValorTotal() {
        Produto produto = new Produto("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            if (produto.getValorTotal().compareTo(new BigDecimal(361.14)) != 361.14) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void exibirProduto() {
        Produto produto = new Produto("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            assertEquals(produto.toString(), "Trocar Painel 2 180,57 361,14");
            produto.setValorUnitario(new BigDecimal(1800.57));
            assertEquals(produto.toString(), "Trocar Painel 2 1.800,57 3.601,14");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setANDgetCodigo() {
        Produto produto = new Produto("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            produto.setCodigo(1);
            assertEquals(produto.getCodigo(), 1);
            produto.setCodigo(3);
            assertEquals(produto.getCodigo(), 3);
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setCodigoInvalido() {
        Produto produto = new Produto("Trocar Painel", 2, new BigDecimal(180.57));
        try {
            produto.setCodigo(-1);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            produto.setCodigo(0);
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
    }
}
