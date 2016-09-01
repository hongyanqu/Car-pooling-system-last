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
public enum PostType {
    OFFERING, ASKING;

    static public PostType getFromString(String postTyep) {
        if (postTyep.equalsIgnoreCase("asking")) {
            return PostType.ASKING;

        }
        return PostType.OFFERING;

    }

    static public PostType getFromInt(int val) {
        if (val == 1) {
            return PostType.OFFERING;
        } else {
            return PostType.ASKING;
        }
    }
}
