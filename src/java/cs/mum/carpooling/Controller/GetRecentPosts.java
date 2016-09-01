/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.Controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class GetRecentPosts extends ParentServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Timestamp tm = (Timestamp) req.getSession().getAttribute("lastPostRequestedTime");
        String gson = new Gson().toJson(postDAO.newPosts(tm));
        req.getSession().setAttribute("lastPostRequestedTime", Timestamp.from(Instant.now()));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(gson);
    }

}
