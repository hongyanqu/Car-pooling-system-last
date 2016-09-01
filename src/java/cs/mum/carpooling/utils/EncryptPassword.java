/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.utils;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
import cs.mum.carpooling.utils.auth.PasswordAuthentication;
import java.security.MessageDigest;
import java.util.Arrays;

public class EncryptPassword {

    public static boolean authenticate(
            char[] enteredPW,
            char[] PW) throws Exception {
        String s1 = String.valueOf(PW);
        String s2 = String.valueOf(encrypt(enteredPW));
        return s1.equals(s2);
    }

    public static char[] encrypt(char[] password) throws Exception {
        return generateMD5(password);
    }

    public static char[] generateMD5(char[] password) throws Exception {
        return hashChars(password, "MD5");
    }

    public static char[] generateSHA1(char[] password) throws Exception {
        return hashChars(password, "SHA-1");
    }

    public static char[] generateSHA256(char[] password) throws Exception {
        return hashChars(password, "SHA-256");
    }

    private static char[] hashChars(char[] password, String algorithmType)
            throws Exception {
        byte[] defaultBytes = String.valueOf(password).getBytes();
        MessageDigest algorithm = MessageDigest.getInstance(algorithmType);
        algorithm.reset();
        algorithm.update(defaultBytes);
        byte messageDigest[] = algorithm.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        }
        return String.valueOf(hexString).toCharArray();
    }

    public static void main(String[] args) throws Exception {
        char[] pw1 = {'a', 'b', 'c'};
        char[] pw2 = {'a', 'b', 'c'};
        char[] epw = encrypt(pw1);
        char[] epw2 = encrypt(pw2);
        System.out.println(authenticate(pw1,epw));
    }
}
