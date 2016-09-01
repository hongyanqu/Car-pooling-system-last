/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import static cs.mum.carpooling.Controller.ParentServlet.forward;
import cs.mum.carpooling.model.Address;
import cs.mum.carpooling.model.Gender;
import cs.mum.carpooling.model.LoginCredential;
import cs.mum.carpooling.model.User;
import static cs.mum.carpooling.utils.Validator.validateAge;
import java.io.IOException;
import java.time.Year;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class SignUpController extends ParentServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //login credential
            System.out.println("sign up controller");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            LoginCredential login = new LoginCredential(email, password.toCharArray());
            //address
            String state = StringUtils.lowerCase(request.getParameter("state"));
            String city = StringUtils.lowerCase(request.getParameter("city"));
            String zipCode = request.getParameter("zipcode");
            String street = StringUtils.lowerCase(request.getParameter("street"));
            Address address = new Address(state, city, street, zipCode);
            //user data 
            String firstName = StringUtils.lowerCase(request.getParameter("firstname"));
            String lastName = StringUtils.lowerCase(request.getParameter("lastname"));
            Gender gender = Gender.getFromString(request.getParameter("gender"));
            Year birthYear = validateAge(Year.of(Integer.parseInt(request.getParameter("birthYear"))));
            User user = new User(firstName, lastName, birthYear, gender, address, login);
            userDAO.create(user);
            HttpSession session = request.getSession();
            String targetURL = "/home.jsp";
            session.setAttribute("user", user);
            forward(request, response, targetURL);
        } catch (IllegalArgumentException ex) {
            String target = "/signup.jsp";
            addErrorMessages(request, ex.toString());
            forward(request, response, target);
        }
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

}
