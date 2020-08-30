/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Funcionario;

/**
 *
 * @author gusta
 */
public class FuncionarioTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int NOME_COL = 0;
//    public static final int TELEFONE_COL = 1;
//    public static final int EMAIL_COL = 2;
//    public static final int ENDERECO_COL = 3;
    
    private String[] columnNames = { "Nome" };
    private List<Funcionario> funcionarios;
    
    public FuncionarioTableModel(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    @Override
    public int getRowCount() {
        return this.funcionarios.size();
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
        Funcionario tempFuncionario = this.funcionarios.get(row);
        
        switch (col) {
            case NOME_COL:
                return tempFuncionario.getNome();
//            case TELEFONE_COL:
//                return tempFuncionario.getTelefone();
//            case EMAIL_COL:
//                return tempFuncionario.getEmail();
//            case ENDERECO_COL:
//                return tempFuncionario.getEndereco();
            case OBJECT_COL:
                return tempFuncionario;
            default:
                return tempFuncionario.getCodigo();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
