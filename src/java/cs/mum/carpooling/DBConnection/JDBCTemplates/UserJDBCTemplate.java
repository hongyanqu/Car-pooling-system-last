package cs.mum.carpooling.DBConnection.JDBCTemplates;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import cs.mum.carpooling.DBConnection.mapper.UserMapper;
import cs.mum.carpooling.model.Address;
import cs.mum.carpooling.model.Gender;
import cs.mum.carpooling.model.LoginCredential;
import cs.mum.carpooling.model.User;
import cs.mum.carpooling.utils.MyUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.DataAccessException;

public class UserJDBCTemplate implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    @Override
    public void create(User user) {
        System.out.println("creating user data to database");
        try {
            // TODO Auto-generated method stub
            String sql = "INSERT INTO `users`("
                    + "`email`, `password`, `fullname`,`gender`,"
                    + "`birthyear` ,"
                    + "`state`, `city`,`street`,`zipcode`,"
                    + "`datecreated`,`dateupdated`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            int result = this.jdbcTemplateObject.update(
                    sql,
                    user.getEmail(),
                    String.valueOf(user.getPassword()),
                    user.getFullName(), user.getGender().ordinal(),
                    Integer.parseInt(user.getBirthYear().toString()),
                    user.getState(), user.getCity(), user.getStreet(), user.getZipcode(),
                    MyUtils.localTimeToTimeStamp(LocalDateTime.now()),
                    MyUtils.localTimeToTimeStamp(LocalDateTime.now())
            );
            System.out.println("Query: ");
            System.out.println("Updated rows: " + result);
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database." + ex);
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            String sql = "SELECT * FROM users WHERE userid = ?";
            User user = jdbcTemplateObject.queryForObject(
                    sql, new Object[]{id}, new UserMapper());
            return user;
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            String sql = "SELECT * FROM users where email = ?";
            User user = jdbcTemplateObject.queryForObject(
                    sql, new Object[]{email}, new UserMapper());
            return user;
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null,
                    "User with this email is not found.");
            System.out.println("User with this email is not found." + ex);
            return null;
        }
    }

    @Override
    public List<User> listUsers() {
        try {
            String SQL = "SELECT * FROM users";
            List<User> users = jdbcTemplateObject.query(SQL,
                    new UserMapper());
            return users;
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
            return new ArrayList<User>();
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
    }

    public static void main(String[] str) {
        org.springframework.context.support.ClassPathXmlApplicationContext ctx = new org.springframework.context.support.ClassPathXmlApplicationContext("Beans.xml");
        //Get the EmployeeDAO Bean
        LoginCredential login = new LoginCredential("pauslosgetu1@gmail.com", "Pn21743821".toCharArray());

        Address address = new Address("iowa", "fairfield", "4th n street", "9852");

        User userc = new User("paulos", "getachew", Year.of(1991), Gender.MALE, address, login);

        String email = "pappu.epoch@gmail.com";
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        User user = userDAO.getUserByEmail(email);
      //  userDAO.create(userc);
        System.out.println("Year " + Year.of(1991).toString());
        System.err.println("User by email: " + user);
        for (User u : userDAO.listUsers()) {
            System.out.println(u);
        }
    }

}
