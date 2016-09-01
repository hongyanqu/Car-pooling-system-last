/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

import cs.mum.carpooling.utils.EncryptPassword;
import static cs.mum.carpooling.utils.EncryptPassword.encrypt;
import cs.mum.carpooling.utils.Validator;
import java.io.Serializable;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class LoginCredential implements Serializable {

    private String email;
    private char[] password;

    public static LoginCredential getLoginCredentialObject(String email, char[] pw) {
        LoginCredential login = new LoginCredential();
        login.email = email;
        login.password = pw;
        return login;
    }

    public LoginCredential() {
    }

    public LoginCredential(String email, char[] password)
            throws IllegalArgumentException {
        try {
            this.email = Validator.validateEmail(email);
            this.password = encrypt(
                    Validator.validatePassword(password)
            );
        } catch (Exception ex) {
            throw new RuntimeException("Faild to encrypt.");
        }
    }

    public String getEmail() {
        return email;
    }

    public char[] getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginCredential{" + "email=" + email + '}';
    }

    public boolean authenticate(String password) throws Exception {
        return EncryptPassword.authenticate(password.toCharArray(), this.password);
    }
}
