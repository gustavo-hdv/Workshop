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

package user_interface.table_manager;

import java.awt.Window;
import user_interface.table_model.UserTableModel;
import user_interface.table_model.VeiculoTableModel;
import user_interface.table_model.ServicoTableModel;
import user_interface.table_model.FuncionarioTableModel;
import user_interface.table_model.ProdutoTableModel;
import user_interface.table_model.ClienteTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Orcamento;
import model.bean.Produto;
import model.bean.Servico;
import model.bean.User;
import model.bean.Veiculo;
import model.dao.ClienteDAO;
import model.dao.FuncionarioDAO;
import model.dao.OrcamentoDAO;
import model.dao.ProdutoDAO;
import model.dao.ServicoDAO;
import model.dao.UserDAO;
import model.dao.VeiculoDAO;
import user_interface.table_model.OrcamentoTableModel;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class TableView {
    
    public TableView() {
        
    }

    public void refreshViewClients(Window mainFrame, JTable table) { 
        try {
            List<Cliente> clientes = new ClienteDAO().readAll();
            
            ClienteTableModel model = new ClienteTableModel(clientes);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void refreshViewEmployees(Window mainFrame, JTable table) { 
        try {
            List<Funcionario> funcionarios = new FuncionarioDAO().readAll();
            
            FuncionarioTableModel model = new FuncionarioTableModel(funcionarios);
            
            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refreshViewServices(Window mainFrame, JTable table) { 
        try {
            List<Servico> servicos = new ServicoDAO().readAll();
            
            ServicoTableModel model = new ServicoTableModel(servicos);
            
            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refreshViewUsers(Window mainFrame, JTable table, boolean isAdmin, int userId) { 
        try {
            List<User> usuarios = new UserDAO().read(isAdmin, userId);
            
            UserTableModel model = new UserTableModel(usuarios);
            
            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refreshViewProducts(Window mainFrame, JTable table) { 
        try {
            List<Produto> produtos = new ProdutoDAO().readAll();
            
            ProdutoTableModel model = new ProdutoTableModel(produtos);
            
            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refreshViewVehicles(Window mainFrame, JTable table) { 
        try {
            List<Veiculo> veiculos = new VeiculoDAO().readAll();
            
            VeiculoTableModel model = new VeiculoTableModel(veiculos);
            
            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void refreshViewOrcamentos(Window mainFrame, JTable table) { 
        try {
            List<Orcamento> orcamentos = new OrcamentoDAO().readAll();
            
            OrcamentoTableModel model = new OrcamentoTableModel(orcamentos);
            
            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewClients(Window mainFrame, JTable table, String searchTextField) {
        try {
            List<Cliente> clientes = null;

            if (searchTextField != null && searchTextField.trim().length() > 0) {
                clientes = new ClienteDAO().search(searchTextField);
            } else {
                clientes = new ClienteDAO().readAll();
            }

            ClienteTableModel model = new ClienteTableModel(clientes);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewUsers(Window mainFrame, JTable table, String searchTextField, int userId, boolean userAdmin) {
        try {
            List<User> usuarios = null;

            if (searchTextField != null && searchTextField.trim().length() > 0 && userAdmin) {
                usuarios = new UserDAO().search(searchTextField);
            } else {
                usuarios = new UserDAO().read(userAdmin, userId);
            }

            UserTableModel model = new UserTableModel(usuarios);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewProducts(Window mainFrame, JTable table, String searchTextField) {
        try {
            List<Produto> produtos = null;

            if (searchTextField != null && searchTextField.trim().length() > 0) {
                produtos = new ProdutoDAO().search(searchTextField);
            } else {
                produtos = new ProdutoDAO().readAll();
            }

            ProdutoTableModel model = new ProdutoTableModel(produtos);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewServices(Window mainFrame, JTable table, String searchTextField) {
        try {
            List<Servico> servicos = null;

            if (searchTextField != null && searchTextField.trim().length() > 0) {
                servicos = new ServicoDAO().search(searchTextField);
            } else {
                servicos = new ServicoDAO().readAll();
            }

            ServicoTableModel model = new ServicoTableModel(servicos);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewVehicles(Window mainFrame, JTable table, String searchTextField) {
        try {
            List<Veiculo> veiculos = null;

            if (searchTextField != null && searchTextField.trim().length() > 0) {
                veiculos = new VeiculoDAO().search(searchTextField);
            } else {
                veiculos = new VeiculoDAO().readAll();
            }

            VeiculoTableModel model = new VeiculoTableModel(veiculos);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewEmployees(Window mainFrame, JTable table, String searchTextField) {
        try {
            List<Funcionario> funcionarios = null;

            if (searchTextField != null && searchTextField.trim().length() > 0) {
                funcionarios = new FuncionarioDAO().search(searchTextField);
            } else {
                funcionarios = new FuncionarioDAO().readAll();
            }

            FuncionarioTableModel model = new FuncionarioTableModel(funcionarios);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchViewOrcamentos(Window mainFrame, JTable table, String searchTextField) {
        try {
            List<Orcamento> orcamentos = null;

            if (searchTextField != null && searchTextField.trim().length() > 0) {
                orcamentos = new OrcamentoDAO().search(searchTextField);
            } else {
                orcamentos = new OrcamentoDAO().readAll();
            }

            OrcamentoTableModel model = new OrcamentoTableModel(orcamentos);

            table.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFrame, "Error: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
