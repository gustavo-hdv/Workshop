/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Veiculo;

/**
 *
 * @author gusta
 */
public class VeiculoTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int PLACA_COL = 0;
    public static final int DESCRICAO_COL = 1;
    public static final int QUILOMETRAGEM_COL = 2;
    public static final int COMBUSTIVEL_COL = 3;
    public static final int MARCADOR_COL = 4;
    public static final int COR_COL = 5;
    
    private String[] columnNames = { "Placa", "Descrição", "Quilometragem", "Combustível", "Marcador", "Cor" };
    private List<Veiculo> veiculos;
    
    public VeiculoTableModel(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    @Override
    public int getRowCount() {
        return this.veiculos.size();
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
        Veiculo tempVeiculo = this.veiculos.get(row);
        
        switch (col) {
            case PLACA_COL:
                return tempVeiculo.getPlaca();
            case DESCRICAO_COL:
                return tempVeiculo.getDescricao();
            case QUILOMETRAGEM_COL:
                return tempVeiculo.getQuilometragem();
            case COMBUSTIVEL_COL:
                return tempVeiculo.getCombustivel();
            case MARCADOR_COL:
                return tempVeiculo.getMarcador();
            case COR_COL:
                return tempVeiculo.getCor();
            case OBJECT_COL:
                return tempVeiculo;
            default:
                return tempVeiculo.getCodigo();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
