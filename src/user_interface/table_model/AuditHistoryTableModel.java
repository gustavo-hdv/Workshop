/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.AuditHistory;

/**
 *
 * @author gusta
 */
public class AuditHistoryTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int DATE_TIME_COL = 0;
    private static final int ACTION_COL = 1;
    private static final int USER_NAME_COL = 2;

    private String[] columnNames = { "Data/Hora", "Modificação", "Nome do usuário" };
	
    private List<AuditHistory> auditHistoryList;

    public AuditHistoryTableModel(List<AuditHistory> theAuditHistoryList) {
	auditHistoryList = theAuditHistoryList;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
	return auditHistoryList.size();
    }

    @Override
    public String getColumnName(int col) {
	return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        AuditHistory tempAuditHistory = auditHistoryList.get(row);

	switch (col) {
	case DATE_TIME_COL:
            return tempAuditHistory.getActionDateTime();
	case ACTION_COL:
            return tempAuditHistory.getAction();
	case USER_NAME_COL:
            return tempAuditHistory.getUserName();
	case OBJECT_COL:
            return tempAuditHistory;
	default:
            return tempAuditHistory.getUserName();
	}
    }

    @Override
    public Class getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }
}
