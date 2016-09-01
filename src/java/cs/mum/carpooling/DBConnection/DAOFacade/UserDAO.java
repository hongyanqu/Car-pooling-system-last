package cs.mum.carpooling.DBConnection.DAOFacade;

import java.util.List;

import javax.sql.DataSource;

import cs.mum.carpooling.model.User;

public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(User user);

	public User getUserByEmail(String email);

	public User getUserById(long id);        
        
	public List<User> listUsers();
	
	public void delete(int id);

	public void update(User user);
        
}
