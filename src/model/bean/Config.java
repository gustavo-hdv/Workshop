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

import model.util.Util;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class Config {

    private String email;
    private String address;
    private String cellphone;
    private String companyName;
    
    public Config() {
    }
    
    public Config(String companyName, String cellphone, String email, String address) {
        //Util.validaString(email, "Email vazio ou nulo");
        Util.validaEmail(email);
        //Util.validaString(address, "Endereço vazio ou nulo");
        Util.validaEmail(address);
        //Util.validaString(cellphone, "Telefone vazio ou nulo");
        Util.validaTelefone(cellphone);

        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //Util.validaString(email, "Email vazio ou nulo");
        Util.validaEmail(email);
        
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        //Util.validaString(address, "Endereço vazio ou nulo");
        Util.validaEmail(address);
        
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        //Util.validaString(cellphone, "Telefone vazio ou nulo");
        Util.validaTelefone(cellphone);
        
        this.cellphone = cellphone;
    }
}
