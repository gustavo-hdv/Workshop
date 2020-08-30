/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.User;

/**
 *
 * @author gusta
 */
public class UserTableModel extends AbstractTableModel {
    public static final int OBJECT_COL = -1;
    public static final int LOGIN_COL = 0;
    public static final int PASSWORD_COL = 1;
    public static final int IS_ADMIN_COL = 2;
    
    private String[] columnNames = { "Nome de usuário", "Senha (Criptografada)", "Administrador" };
    private List<User> users;
    
    public UserTableModel(List<User> users) {
        this.users = users;
    }
    
    @Override
    public int getRowCount() {
        return this.users.size();
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
        User tempUser = this.users.get(row);
        
        switch (col) {
            case LOGIN_COL:
                return tempUser.getLogin();
            case PASSWORD_COL:
                return tempUser.getPassword();
            case IS_ADMIN_COL:
                return tempUser.isAdmin();
            case OBJECT_COL:
                return tempUser;
            default:
                return tempUser.getId();
        }
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
