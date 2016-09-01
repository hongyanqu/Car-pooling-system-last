/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.JDBCTemplates;

import cs.mum.carpooling.DBConnection.DAOFacade.LikeDAO;
import cs.mum.carpooling.DBConnection.mapper.LikeMapper;
import cs.mum.carpooling.model.Like;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class LikeJDBCTemplate implements LikeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    @Override
    public void create(Like like) {
        try {
            String deleteQuery = "DELETE fromlikes WHERE postid = ? and userid = ?";
            String insertQuery = "INSERT INTO sql9133240.likes ("
                    + "userid, postid) "
                    + "VALUES (?, ?)";
            int result = this.jdbcTemplateObject.update(
                    deleteQuery,
                    like.getUser().getUserId(),
                    like.getPost().getPostId());
            if (result == 0) {
                this.jdbcTemplateObject.update(
                        insertQuery,
                        like.getUser().getUserId(),
                        like.getPost().getPostId());
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add Like to database.");
            System.out.println("Fialed to add User to database.");
        }
    }

    @Override
    public Like getLike(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Like> listLikes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Like like) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int likesCountForPost(int postId) {
        try {
            String sql = "SELECT COUNT(*) FROM likes where postid = ?";
            SqlRowSet rs = this.jdbcTemplateObject.queryForRowSet(sql, postId);
            return rs != null ? rs.getInt(0) : 0;
        } catch (InvalidResultSetAccessException ex) {
            System.out.println(ex.getSql());
            throw new RuntimeException("Fatal Error: Likes table");
        }
    }

    @Override
    public boolean isLikeMade(int userId, int postId) {
        String sql = "SELECT * FROM likes WHERE postid = 1 and userid = 1";
        return true;
    }

    @Override
    public List<Like> likeForPost(int postId) {
        try {
            String sql = "SELECT *FROM "
                    + "likes"
                    + " WHERE postid = ?";
            List<Like> likes;
            likes = jdbcTemplateObject.query(
                    sql,
                    new LikeMapper(),
                    postId);
            return likes;
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add comment to database.");
            System.out.println("Fialed to read likes for post." + ex);
            return new ArrayList<>();
        }
    }

}
