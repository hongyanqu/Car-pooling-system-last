/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import com.google.gson.Gson;
import static cs.mum.carpooling.Controller.ParentServlet.addErrorMessages;
import cs.mum.carpooling.model.Like;
import cs.mum.carpooling.model.Post;
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
public class AddLike extends ParentServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Excuting addLikeController servlet.");
            Post post = (Post) req.getAttribute("selectedPost");
            User user = (User) req.getSession().getAttribute("user");
            Like like = new Like(user, post);            
            likeDAO.create(like);
            post = postDAO.getPost(post.getPostId());
            String json;
            json = new Gson().toJson(post);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
            System.out.println("Like: " + like + " added to db.");
        } catch (IllegalArgumentException ex) {
            addErrorMessages(req, ex.toString());
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessages(req, ex.toString());
        }

    }

}
