/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.mapper;


import cs.mum.carpooling.model.Address;
import cs.mum.carpooling.model.Gender;
import cs.mum.carpooling.model.LoginCredential;
import cs.mum.carpooling.model.User;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = null;
        try {
            Address address = new Address(rs.getString("state"),
                    rs.getString("city"), rs.getString("street"),
                    rs.getString("zipcode"));
            LoginCredential login = LoginCredential.getLoginCredentialObject(                    
                    rs.getString("email"),
                    rs.getString("password").toCharArray());
            user = User.getUserForDB(rs.getInt("userid"),
                    rs.getString("fullname"),
                    Year.of(rs.getInt("birthyear")),
                    Gender.values()[rs.getInt("gender")],
                    address,
                    login
            );
        } catch (SQLException ex) {
            throw ex;
        }
        return user;
    }

}
