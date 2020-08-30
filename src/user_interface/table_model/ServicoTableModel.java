/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Servico;

/**
 *
 * @author gusta
 */
public class ServicoTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int DESCRICAO_COL = 0;
    public static final int QUANTIDADE_COL = 1;
    public static final int VALOR_UNITARIO_COL = 2;
    
    private String[] columnNames = { "Descrição", "Quantidade", "Valor Unitário (R$)" };
    private List<Servico> servicos;
    
    public ServicoTableModel(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
    @Override
    public int getRowCount() {
        return this.servicos.size();
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
        Servico tempServico = this.servicos.get(row);
        
        switch (col) {
            case DESCRICAO_COL:
                return tempServico.getDescricao();
            case QUANTIDADE_COL:
                return tempServico.getQuantidade();
            case VALOR_UNITARIO_COL:
                return tempServico.getValorUnitario();
            case OBJECT_COL:
                return tempServico;
            default:
                return tempServico.getCodigo();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
