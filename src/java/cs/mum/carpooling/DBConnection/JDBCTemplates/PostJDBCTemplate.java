/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.JDBCTemplates;

import com.google.gson.Gson;
import cs.mum.carpooling.DBConnection.DAOFacade.CommentDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.LikeDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.PostDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import cs.mum.carpooling.DBConnection.mapper.PostMapper;
import cs.mum.carpooling.model.Post;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class PostJDBCTemplate implements PostDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private CommentDAO commentDAO;
    private LikeDAO likeDAO;
    private UserDAO userDAO;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(ds);
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
        System.out.println("Post setUserDAO");

    }

    public void setLikeDAO(LikeDAO likeDAO) {
        this.likeDAO = likeDAO;
        System.out.println("Post setLikeDAO");

    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;

        System.out.println("Post setUserDAO " + userDAO);
    }

    @Override
    public void create(Post post) {
        try {
            String sql = "INSERT INTO sql9133240.posts "
                    + " (userid, post, posttype,"
                    + "VALUES (?, ?, ?)";
            this.jdbcTemplateObject.update(
                    sql,
                    post.getCreatedBy().getUserId(),
                    post.getPost(),
                    post.getPostType().ordinal()
            );
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
        }
    }

    @Override
    public Post getPost(int id) {
        try {
            String sql = "SELECT * FROM posts WHERE postid = ?";
            Post post = jdbcTemplateObject.queryForObject(
                    sql, new Object[]{id}, new PostMapper(userDAO, commentDAO, likeDAO));
            return post;
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
            return null;
        }

    }

    @Override
    public List<Post> newPosts(java.sql.Timestamp time) {
        try {
            System.out.println("Postfound");

            String SQL = "SELECT * FROM posts where dateupdated > "
                    + " ? "
                    + "OR  datecreated > ?";
            List<Post> posts = jdbcTemplateObject.query(SQL,
                    new PostMapper(userDAO, commentDAO, likeDAO), time, time);
            Collections.reverse(posts);
            return posts != null ? posts : new ArrayList<>();
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
            System.out.println("Postfound");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Post> listPosts() {
        try {
            System.out.println("Postfound");

            String SQL = "SELECT * FROM posts";
            List<Post> posts = jdbcTemplateObject.query(SQL,
                    new PostMapper(userDAO, commentDAO, likeDAO));
            return posts != null ? posts : new ArrayList<>();
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
            System.out.println("Postfound");
            return new ArrayList<>();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String SQL = "DELETE FROM sql9133240.posts WHERE postid = ?";
            jdbcTemplateObject.update(SQL, id);
        } catch (DataAccessException ex) {
            Logger.getLogger(CommentJDBCTemplate.class.getName()).log(Level.SEVERE, null, "faild to add User to database.");
            System.out.println("Fialed to add User to database.");
        }
    }

    @Override
    public void update(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] str) {
        org.springframework.context.support.ClassPathXmlApplicationContext ctx = new org.springframework.context.support.ClassPathXmlApplicationContext("Beans.xml");
        //Get the EmployeeDAO Bean
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        PostDAO postDAO = ctx.getBean("postDAO", PostDAO.class);
        CommentDAO commentDAO = ctx.getBean("commentDAO", CommentDAO.class);
        LikeDAO likeDAO = ctx.getBean("likeDAO", LikeDAO.class);
        String gson = new Gson().toJson(postDAO.listPosts());
        System.out.println("\n\n\n\ngston");
        System.out.println(gson);/*
        for (Post p : postDAO.listPosts()) {
            System.out.println(p);
        }*/

    }

}
