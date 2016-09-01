/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.mapper;

import cs.mum.carpooling.DBConnection.DAOFacade.PostDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import cs.mum.carpooling.model.Like;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class LikeMapper implements RowMapper {
    
//    private UserDAO userDAO;
 //   private PostDAO postDAO;

    public LikeMapper() {
    }

    private LikeMapper(UserDAO udo,PostDAO pdo){
   //     this.userDAO = udo;
  //   this.postDAO = pdo;
    }
    
    public void setPostDAO(PostDAO postDAO) {
//        this.postDAO = postDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
  //      this.userDAO = userDAO;
    }

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Like like;
        like = new Like(
//                userDAO.getUserById(rs.getInt("userid")),
//                postDAO.getPost(rs.getInt("postid"))
                );
        return like;
    }

}
