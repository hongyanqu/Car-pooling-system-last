/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public enum Gender{
    MALE, FEMALE, OTHER;

    static public Gender getFromString(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            return MALE;
        } else if (gender.equalsIgnoreCase("female")) {
            return FEMALE;
        } else {
            return OTHER;
        }
    }
}
