package cs.mum.carpooling.DBConnection.DAOFacade;

import java.util.List;

import javax.sql.DataSource;

import cs.mum.carpooling.model.Post;

public interface PostDAO {

    public void setDataSource(DataSource ds);

    public void create(Post post);

    public Post getPost(int id);

    public List<Post> listPosts();

    public void delete(int id);

    public void update(Post post);

    public List<Post> newPosts(java.sql.Timestamp time);
}
