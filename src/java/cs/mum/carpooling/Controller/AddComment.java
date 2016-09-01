/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import com.google.gson.Gson;
import static cs.mum.carpooling.Controller.ParentServlet.addErrorMessages;
import cs.mum.carpooling.model.Comment;
import cs.mum.carpooling.model.Post;
import cs.mum.carpooling.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class AddComment extends ParentServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Excuting addCommentController servlet.");
            String commentText = req.getParameter("post");
            User createdBy = (User) req.getSession().getAttribute("user");
            Post post = (Post) req.getAttribute("selectedPost");
            Comment cmnt = new Comment(commentText, createdBy, post);
            commentDAO.create(cmnt);
            String json;
            post = postDAO.getPost(post.getPostId());
            json = new Gson().toJson(post);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
            System.out.println("Comment: " + cmnt + " added to db.");
        } catch (IllegalArgumentException ex) {
            addErrorMessages(req, ex.toString());
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessages(req, ex.toString());
        }

    }

}
