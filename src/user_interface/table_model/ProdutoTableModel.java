/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Produto;

/**
 *
 * @author gusta
 */
public class ProdutoTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int DESCRICAO_COL = 0;
    public static final int QUANTIDADE_COL = 1;
    public static final int VALOR_UNITARIO_COL = 2;
    
    private String[] columnNames = { "Descrição", "Quantidade", "Valor Unitário (R$)" };
    private List<Produto> produtos;
    
    public ProdutoTableModel(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public int getRowCount() {
        return this.produtos.size();
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
        Produto tempProduto = this.produtos.get(row);
        
        switch (col) {
            case DESCRICAO_COL:
                return tempProduto.getDescricao();
            case QUANTIDADE_COL:
                return tempProduto.getQuantidade();
            case VALOR_UNITARIO_COL:
                return tempProduto.getValorUnitario();
            case OBJECT_COL:
                return tempProduto;
            default:
                return tempProduto.getCodigo();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
