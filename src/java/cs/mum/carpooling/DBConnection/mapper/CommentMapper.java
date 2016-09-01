/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.DBConnection.mapper;

import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import cs.mum.carpooling.model.Comment;
import cs.mum.carpooling.utils.MyUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class CommentMapper implements RowMapper<Comment> {

    private UserDAO userDAO;

    public CommentMapper(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    @Override
    public Comment mapRow(ResultSet rs, int i) throws SQLException {
        Comment comment;
        comment = new Comment(
                rs.getInt("commentid"),
                rs.getString("comment"),
                userDAO.getUserById(rs.getInt("userid")),
                null,
                MyUtils.dateConvert(rs.getTimestamp("datecreated")),
                MyUtils.dateConvert(rs.getTimestamp("dateupdated"))
        );
        return comment;
    }

}
