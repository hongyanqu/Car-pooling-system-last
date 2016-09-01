package cs.mum.carpooling.DBConnection.DAOFacade;

import java.util.List;

import javax.sql.DataSource;

import cs.mum.carpooling.model.Like;

public interface LikeDAO {

    public void setDataSource(DataSource ds);

    public void create(Like like);

    public Like getLike(int id);

    public List<Like> listLikes();

    public void delete(int id);

    public void update(Like like);

    public int likesCountForPost(int postId);

    public boolean isLikeMade(int userId, int postId);
    
    public List<Like> likeForPost(int postId);
}
