/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

import java.io.Serializable;
import java.time.Year;

import cs.mum.carpooling.utils.Validator;
import java.time.LocalDateTime;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class User implements Serializable {

    private Integer userId;
    private String fullName;
    private Year birthYear;
    private Gender gender;
    private Address address;
    private LoginCredential loginInfo;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public User() {
    }

    public User(String firstName, String lastName, Year birthYear, Gender gender, Address address,
            LoginCredential login) {
        this(-1, Validator.validateName(firstName) + " " + Validator.validateName(lastName), birthYear, gender, address,
                login);
    }

    public User(Integer userId, String fullName, Year birthYear, Gender gender, Address address,
            LoginCredential login) {
        this.fullName = fullName.toLowerCase();
        this.birthYear = Validator.validateAge(birthYear);
        this.gender = gender;
        this.address = address;
        this.loginInfo = login;
        this.userId = userId;
    }

    public static User getUserForDB(Integer userId, String fullName, Year birthYear, Gender gender, Address address,
            LoginCredential login) {
        User user = new User();
        user.fullName = fullName;
        user.birthYear = birthYear;
        user.gender = gender;
        user.address = address;
        user.loginInfo = login;
        user.userId = userId;
        return user;
    }

    public String getFullName() {
        return fullName;
    }

    public Year getBirthYear() {
        return birthYear;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return this.loginInfo.getEmail();
    }

    public String getState() {
        return address.getState();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getZipcode() {
        return address.getZipcode();
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public char[] getPassword() {
        return loginInfo.getPassword();
    }

    public Integer getUserId() {
        return userId;
    }

    public boolean authenticate(String password) throws Exception {
        return loginInfo.authenticate(password);
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId
                + ", fullName=" + fullName
                + ", birthYear=" + birthYear
                + ", gender=" + gender
                + ", address=" + address
                + '}';
    }
}
