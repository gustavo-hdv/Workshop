/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Orcamento;

/**
 *
 * @author gusta
 */
public class OrcamentoTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int DATA_HORA_COL = 0;
    public static final int DEFEITOS_APONTADOS_COL = 1;
    public static final int FUNCIONARIO_COL = 2;
    public static final int NOME_CLIENTE = 3;
    public static final int TELEFONE_CLIENTE = 4;
    public static final int PLACA_VEICULO_COL = 5;
    public static final int DESCRICAO_VEICULO_COL = 6;

    private String[] columnNames = { "Data/hora", "Defeitos Apontados", "Funcionário(s)", "Nome do Cliente", "Telefone do Cliente", "Placa do Veículo", "Descrição do Veículo" };
    private List<Orcamento> orcamentos;
    
    public OrcamentoTableModel(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
    
    @Override
    public int getRowCount() {
        return this.orcamentos.size();
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
        Orcamento tempOrcamento = this.orcamentos.get(row);
        
        switch (col) {
            case DATA_HORA_COL:
                return tempOrcamento.getDataHora();
            case DEFEITOS_APONTADOS_COL:
                return tempOrcamento.getDefeitosApontados();
            case FUNCIONARIO_COL:
                return tempOrcamento.getFuncionario().getNome();
            case NOME_CLIENTE:
                return tempOrcamento.getCliente().getNome();
            case TELEFONE_CLIENTE:
                return tempOrcamento.getCliente().getTelefone();
            case PLACA_VEICULO_COL:
                return tempOrcamento.getVeiculo().getPlaca();
            case DESCRICAO_VEICULO_COL:
                return tempOrcamento.getVeiculo().getDescricao();
            case OBJECT_COL:
                return tempOrcamento;
            default:
                return tempOrcamento.getCodigo();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
