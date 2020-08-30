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

import java.util.Objects;
import model.util.Util;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class User {
    private int id;
    private String login;
    private String password;
    private boolean isAdmin;
   
    public User() {
        
    }
    
    public User(String login, String password, boolean isAdmin) {
        Util.validaString(login, "Login não pode ser nulo ou vazio");
        Util.validaString(password, "Senha não pode ser nulo ou vazio");
        
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        Util.validaString(login, "Login não pode ser nulo ou vazio");
        
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Util.validaString(password, "Senha não pode ser nulo ou vazio");
        
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Util.validaCodigo(id);
        
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Override
    public String toString() {
        return this.login;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

    
}
