/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.utils;

import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulos Haylu
 */
public class Validator {

    private static final String PASSWORD_PATTERN
            = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})";

    public static char[] validatePassword(char[] pw) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(String.valueOf(pw));
        if (matcher.matches()) {
            return pw;
        }
        throw new IllegalArgumentException(
                "Invalid password, password should "
                + "contain atleast one uppercase letter,and length 6.");
    }

    public static String validateEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (email != null && emailValidator.isValid(email = email.trim())) {
            return email;
        }
        throw new IllegalArgumentException("Invalid email");
    }

    public static Year validateAge(Year year) {
        if (ChronoUnit.YEARS.between(year, Year.now()) > 18) {
            return year;
        }
        throw new IllegalArgumentException("Age below 18 is not valid.");
    }

    public static String validateName(String name) {
        if (StringUtils.isAlpha(name)) {
            return name;
        }
        throw new IllegalArgumentException("Invalid name");
    }

    public static void main(String[] str) {
        char pw[] = {'a', 'v', '1', 'w', 'e', '5'};
        System.out.println(validatePassword(pw));
        System.out.println(validateName("abcdafds"));
    }

}
