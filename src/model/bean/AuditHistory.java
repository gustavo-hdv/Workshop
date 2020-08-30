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
package model.bean;

import java.util.Date;
import model.util.Util;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class AuditHistory {
    private int userId;
    private int id;
    private String action;
    private Date actionDateTime;
    
    private String userName;
    
    public AuditHistory() {
        
    }
    
    public AuditHistory(int userId, int id, String action, java.util.Date actionDateTime, String userName) {
        Util.validaString(action, "Ação não pode ser nula ou vazia");
        Util.validaCodigo(userId);
        Util.validaCodigo(id);
        
        this.userId = userId;
        this.id = id;
        this.action = action;
        this.actionDateTime = actionDateTime;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        Util.validaCodigo(userId);
        
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        Util.validaCodigo(Id);
        
        this.id = Id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        Util.validaString(action, "Ação não pode ser nula ou vazia");
        
        this.action = action;
    }

    public Date getActionDateTime() {
        return actionDateTime;
    }

    public void setActionDateTime(Date  actionDateTime) {     
        this.actionDateTime = actionDateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
