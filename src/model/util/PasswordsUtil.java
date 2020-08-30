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
package model.util;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class PasswordsUtil {
    
    private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
    
    /**
     * Encrypts a password.
     * 
     * @param data - the password to be encrypted
     * @return 
     */
    public static String encryptPassword(String data) {
        
        String result = passwordEncryptor.encryptPassword(data);
        
        return result;
    }
    
    /**
     * Checks an unencrypted (plain) password against an encrypted one to see if they match.
     * 
     * @param plainText
     * @param encryptedPassword
     * @return true if passwords match, false it not.
     */
    public static boolean checkPassword(String plainText, String encryptedPassword) {
        
        return passwordEncryptor.checkPassword(plainText, encryptedPassword);
    }
    
    public static void validaLogin(String login) {
        if (login == null || login.trim().equals("")) {
            throw new IllegalArgumentException("Login is null or empty");
        }
        
        for (int i=0; i < login.length(); i++) {
            char c = login.charAt(i);
            if (!Character.isAlphabetic(c)) {
                throw new IllegalArgumentException("Login is not alphabetical only");
            }
        }
    }
    public static void validaSenha(String senha) {
        if (senha == null || senha.trim().equals("")) {
            throw new IllegalArgumentException("Password is null or empty");
        }
        for (int i=0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Password is not alphabetical or numeric");
            }
        }
    }
    public static void validaEquals(String senha, String rsenha) {
        if (!senha.equals(rsenha)) {
            throw new IllegalArgumentException("Passwords are not equal"); 
        }
    }
}
