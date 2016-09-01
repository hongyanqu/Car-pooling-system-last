package cs.mum.carpooling.DBConnection.DAOFacade;

import cs.mum.carpooling.model.Comment;
import java.util.List;
import javax.sql.DataSource;

public interface CommentDAO {

    public void setDataSource(DataSource ds);

    public void create(Comment post);

    public Comment getComment(int id);

    public List<Comment> commentsForPost(int postId);

    public void delete(int id);

    public void update(Comment post);

    public void setUserDAO(UserDAO userDAO);
}
