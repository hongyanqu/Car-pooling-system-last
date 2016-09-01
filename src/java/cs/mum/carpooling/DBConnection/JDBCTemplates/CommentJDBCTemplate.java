/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.JDBCTemplates;

import cs.mum.carpooling.DBConnection.DAOFacade.CommentDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import cs.mum.carpooling.DBConnection.mapper.CommentMapper;
import cs.mum.carpooling.model.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class CommentJDBCTemplate implements CommentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private UserDAO userDAO;
    
    @Override
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
        System.out.println("comment setUserDAO");
    }
    
    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    @Override
    public void create(Comment cmnt) {
        try {
            String sql = "INSERT INTO sql9133240.comments ("
                    + " userid, postid, comment )"
                    + " VALUES (?, ?, ?)";
            
            int update = this.jdbcTemplateObject.update(
            		sql, cmnt.getGivenBy().getUserId(),
                    cmnt.getPost().getPostId(),                    
                    cmnt);
            
        } catch (DataAccessException ex) {
           Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add comment to database.");                
           System.out.println("Fialed to add comment to database.");
        }
    }

    @Override
    public Comment getComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> commentsForPost(int postId) {
        try {
            String sql = "SELECT *FROM comments WHERE postid = ?";
            List<Comment> comments;
            comments = jdbcTemplateObject.query(
                    sql,
                    new CommentMapper(userDAO),
                    postId);
            return comments;
        } catch (DataAccessException ex) {
           Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add comment to database.");                
           System.out.println("Can't find cmts for posts."+ex);
           return new ArrayList<>();           
        }
    }

    @Override
    public void delete(int id) {
        try {
            String SQL = "DELETE FROM sql9133240.comments WHERE commentid = ?";
            jdbcTemplateObject.update(SQL, id);
        } catch (DataAccessException ex) {
           Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add comment to database.");                
           System.out.println("Fialed to add comment to database.");
        }
    }

    @Override
    public void update(Comment post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
