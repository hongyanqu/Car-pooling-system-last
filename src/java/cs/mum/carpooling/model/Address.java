/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

import java.io.Serializable;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class Address implements Serializable {

    private String state;
    private String city;
    private String street;
    private String zipcode;

    Address() {
    }

    public Address(String state, String city, String street, String zipcode) {
        try {
            this.state = state.toLowerCase();
            this.city = city.toLowerCase();
            this.street = street.toLowerCase();
            this.zipcode = zipcode.toLowerCase();
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("All Address attribute mus have value.");
        }
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public String toString() {
        return "Address{" + "state=" + state + ", city=" + city + ", street=" + street + ", zipcode=" + zipcode + '}';
    }

}
