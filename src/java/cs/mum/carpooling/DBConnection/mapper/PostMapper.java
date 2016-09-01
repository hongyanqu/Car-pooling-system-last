/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.mapper;

import cs.mum.carpooling.DBConnection.DAOFacade.CommentDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.LikeDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import cs.mum.carpooling.model.Comment;
import cs.mum.carpooling.model.Like;
import cs.mum.carpooling.model.Post;
import cs.mum.carpooling.model.PostType;
import cs.mum.carpooling.model.User;
import cs.mum.carpooling.utils.MyUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class PostMapper implements RowMapper<Post> {

    private UserDAO uDAO;
    private CommentDAO cDAO;
    private LikeDAO lDAO;

    public PostMapper() {
    }

    public PostMapper(UserDAO uDAO, CommentDAO cDAO, LikeDAO lDAO) {
        this.uDAO = uDAO;
        this.cDAO = cDAO;
        this.lDAO = lDAO;
        System.out.println("UDAO " + uDAO);
        System.out.println("cDAO " + cDAO);
        System.out.println("lDAO " + lDAO);
    }

    public void setuDAO(UserDAO uDAO) {
        this.uDAO = uDAO;
    }

    public void setcDAO(CommentDAO cDAO) {
        this.cDAO = cDAO;
    }

    public void setlDAO(LikeDAO lDAO) {
        this.lDAO = lDAO;
    }

    @Override
    public Post mapRow(ResultSet rs, int i) {
        try {
            // User user = rs.getInt("userid");
            User user = null;
            List<Like> likes = null;
            List<Comment> comments = null;
            System.out.println("User ID " + rs.getInt("userid"));
            System.out.println("uDAo   " + uDAO);
            List<Like> likesFound= lDAO.likeForPost(rs.getInt("postid"));

            Post post = new Post(
                    rs.getInt("postid"),
                    rs.getString("post"),
                    PostType.getFromInt(rs.getInt("posttype")),
                    uDAO.getUserById(rs.getInt("userid")),
                    MyUtils.dateConvert(rs.getTimestamp("datecreated")),
                    MyUtils.dateConvert(rs.getTimestamp("datecreated")),
                    cDAO.commentsForPost(rs.getInt("postid")),
                    likesFound,
                    likesFound.size()
            );
            return post;
        } catch (SQLException ex) {
            Logger.getLogger(PostMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return null;
        }
    }

}
