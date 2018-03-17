/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.TutorialService;
import domainmodel.Post;
import domainmodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author 729347
 */
public class LoginPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        TutorialService ts = new TutorialService();
        //getServletContext().getRequestDispatcher("/WEB-INF/enterWebsite.jsp").forward(request, response);

        String action = request.getParameter("action");
        String loginUser = (String) session.getAttribute("log");

        if (loginUser == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else if (loginUser.equals("admin")) {
            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            return;
        } else if (loginUser.equals("user")) {
            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("enterUsername");
        String password = request.getParameter("enterPassword");
        TutorialService ts = new TutorialService();

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            session.setAttribute("errorMessage", "Fill in form.");
            response.sendRedirect("main");
            return;
        }

        if ((ts.getUsername(username) == null) || (!(ts.getPassword(username).equals(password)))) {
            session.setAttribute("errorMessage", "Invalid credentials.");
            response.sendRedirect("main");
            return;
        }

        if (action != null && action.equals("userLoginForm")) {
            User user = ts.getUsername(username);
            User theRole = null;
            try {
                theRole = ts.getUsersRole(username);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            List<Post> posts = null;
//            try {
//                posts = ts.getStory();
//            } catch (Exception ex) {
//                Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            session.setAttribute("stories", posts);
            
            if (ts.getPassword(username).equals(password) && ts.getUsername(username) != null && theRole.getRole() == 1 && user.getActive() == true) {
                session.setAttribute("log", "admin");
                session.setAttribute("signIn", username);
                getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
                return;
            } else if (ts.getPassword(username).equals(password) && ts.getUsername(username) != null && theRole.getRole() == 2 && user.getActive() == true) {

                session.setAttribute("log", "user");
                session.setAttribute("signIn", username);
                getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
                return;
            }
        }
    }
}
