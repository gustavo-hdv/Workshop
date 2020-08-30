/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Cliente;

/**
 *
 * @author gusta
 */
public class ClienteTableModel extends AbstractTableModel {

    public static final int OBJECT_COL = -1;
    public static final int NOME_COL = 0;
    public static final int TELEFONE_COL = 1;
    public static final int EMAIL_COL = 2;
    public static final int ENDERECO_COL = 3;
    
    private String[] columnNames = { "Nome", "Telefone", "Email", "Endereço" };
    private List<Cliente> clientes;
    
    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Cliente tempCliente = this.clientes.get(row);
        
        switch (col) {
            case NOME_COL:
                return tempCliente.getNome();
            case TELEFONE_COL:
                return tempCliente.getTelefone();
            case EMAIL_COL:
                return tempCliente.getEmail();
            case ENDERECO_COL:
                return tempCliente.getEndereco();
            case OBJECT_COL:
                return tempCliente;
            default:
                return tempCliente.getCodigo();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
}
