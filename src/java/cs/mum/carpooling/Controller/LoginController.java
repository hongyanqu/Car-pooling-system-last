/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import static cs.mum.carpooling.Controller.ParentServlet.addErrorMessages;
import static cs.mum.carpooling.Controller.ParentServlet.forward;
import cs.mum.carpooling.model.Post;
import cs.mum.carpooling.model.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class LoginController extends ParentServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Excuting controller servlet.");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Email : " + email);
        System.out.println("Password: " + !password.isEmpty());
        String target = "/login.jsp";
        try {
            User user = userDAO.getUserByEmail(email);
            if (user != null && user.authenticate(password)) {
                System.out.println("user found and matchs");
                HttpSession session = request.getSession();
                target = "/home.jsp";
                session.setAttribute("user", user);
                List<Post> posts = postDAO.listPosts();
                System.out.println("Comments to home page: " + posts.get(1).getComments());
                request.setAttribute("posts", posts);
                for (Post p : posts) {
                    System.out.println("\n\n\n\n\n\nn\n\n\n\n\n\nnn\n\n\n\nn\n\n\n\n\nn\n");
                    System.out.println("Likes Count: " + p.getLikesCount());
                }
            } else {
                System.out.println("user found but doesn't matchs");
                addErrorMessages(request, "Incorrect password.");
            }
        } catch (IllegalArgumentException ex) {
            addErrorMessages(request, ex.toString());
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            addErrorMessages(request, ex.toString());
        }
        forward(request, response, target);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
}
