/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import com.google.gson.Gson;
import static cs.mum.carpooling.Controller.ParentServlet.addErrorMessages;
import cs.mum.carpooling.model.Post;
import cs.mum.carpooling.model.PostType;
import cs.mum.carpooling.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class AddPost extends ParentServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Excuting addPostController servlet.");
            String postText = req.getParameter("post");
            User createdBy = (User) req.getSession().getAttribute("user");
            PostType postType = PostType.getFromString(req.getParameter("postType"));
            Post post = new Post(postText, postType, createdBy);
            postDAO.create(post);            
            String json; 
            json = new Gson().toJson(post);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
            System.out.println("Post: " + post + " added to db.");
        } catch (IllegalArgumentException ex) {
            addErrorMessages(req, ex.toString());
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessages(req, ex.toString());
        }
    }

}
