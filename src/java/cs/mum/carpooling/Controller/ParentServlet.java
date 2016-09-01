/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import cs.mum.carpooling.DBConnection.DAOFacade.CommentDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.LikeDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.PostDAO;
import cs.mum.carpooling.DBConnection.DAOFacade.UserDAO;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class ParentServlet extends HttpServlet {

    UserDAO userDAO;
    PostDAO postDAO;
    CommentDAO commentDAO;
    LikeDAO likeDAO;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        org.springframework.context.support.ClassPathXmlApplicationContext ctx = new org.springframework.context.support.ClassPathXmlApplicationContext("Beans.xml");
        //Get the EmployeeDAO Bean
        userDAO = ctx.getBean("userDAO", UserDAO.class);
        postDAO = ctx.getBean("postDAO", PostDAO.class);
        commentDAO = ctx.getBean("commentDAO", CommentDAO.class);
        likeDAO = ctx.getBean("likeDAO", LikeDAO.class);
    }

    static void addErrorMessages(HttpServletRequest request, String... messages) {
        request.setAttribute("errorMessages", Arrays.asList(messages));
    }

    static void forward(HttpServletRequest req, HttpServletResponse res, String target) throws ServletException, IOException {
        req.getRequestDispatcher(target).forward(req, res);
    }

}
