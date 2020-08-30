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

import model.bean.Cliente;
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
public class ClienteTeste {
    
    public ClienteTeste() {
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
    public void constructCliente() {
        try {
            Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void constructClienteNomeNuloVazio() {
        try {
            Cliente cliente = new Cliente("", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
 
        }
        
        try {
            Cliente cliente = new Cliente(null, "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
        }
    }
    
    @Test
    public void constructClienteTelefoneNuloVazio() {
        try {
            Cliente cliente = new Cliente("José Ronaldo", "", "josernldddo@gmail.com", "Rua José da Silva");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
 
        }
        
        try {
            Cliente cliente = new Cliente("José Ronaldo", null, "josernldddo@gmail.com", "Rua José da Silva");
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
        }
    }
    
    @Test
    public void constructClienteEmailNuloVazio() {
        try {
            Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "", "Rua José da Silva");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
 
        }
        
        try {
            Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", null, "Rua José da Silva");
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
        }
    }
    
    @Test
    public void constructClienteEnderecoNuloVazio() {
        try {
            Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
 
        }
        
        try {
            Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
        }
    }
    
    @Test
    public void getNome() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            assertEquals(cliente.getNome(), "José Ronaldo");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setNome() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            cliente.setNome("");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            cliente.setNome(null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
        try {
            cliente.setNome("Gustavo Henrique");
            assertEquals(cliente.getNome(), "Gustavo Henrique");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }     
    }
    
    @Test
    public void getTelefone() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            assertEquals(cliente.getTelefone(), "(83) 96666-4777");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setTelefone() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            cliente.setTelefone("");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            cliente.setTelefone(null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
        try {
            cliente.setTelefone("(81) 98765-4321");
            assertEquals(cliente.getTelefone(), "(81) 98765-4321");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void getEmail() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            assertEquals(cliente.getEmail(), "josernldddo@gmail.com");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setEmail() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            cliente.setEmail("");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            cliente.setEmail(null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
        try {
            cliente.setEmail("gstvhdv@hotmail.com");
            assertEquals(cliente.getEmail(), "gstvhdv@hotmail.com");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void getEndereco() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            assertEquals(cliente.getEndereco(), "Rua José da Silva");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setEndereco() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            cliente.setEndereco("");
            fail("Era esperado falhar");
        } catch (IllegalArgumentException iae) {
            
        }
        try {
            cliente.setEndereco(null);
            fail("Era esperado falhar");
        } catch (NullPointerException npe) {
            
        }
        try {
            cliente.setEndereco("Avenida Canal");
            assertEquals(cliente.getEndereco(), "Avenida Canal");
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setCodigo() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            cliente.setCodigo(1);
            assertEquals(cliente.getCodigo(), 1);
        } catch (Exception e) {
            fail("Não era esperado falhar");
        }
    }
    
    @Test
    public void setCodigoInvalido() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        try {
            cliente.setCodigo(-1);
            fail("Era esperado falhar");
        } catch (Exception e) {
        }
        try {
            cliente.setCodigo(0);
            fail("Era esperado falhar");
        } catch (Exception e) {
        }
    }
    
    @Test
    public void getCodigo() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        assertEquals(cliente.getCodigo(), -1);
        
        cliente.setCodigo(3);
        assertEquals(cliente.getCodigo(), 3);
    }
    
    @Test
    public void clienteToString() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        assertEquals(cliente.toString(), "José Ronaldo | (83) 96666-4777");
    }
    
    @Test
    public void clienteAllToString() {
        Cliente cliente = new Cliente("José Ronaldo", "(83) 96666-4777", "josernldddo@gmail.com", "Rua José da Silva");
        assertEquals(cliente.allToString(), "-1 | José Ronaldo | (83) 96666-4777 | josernldddo@gmail.com | Rua José da Silva");
    }
}
