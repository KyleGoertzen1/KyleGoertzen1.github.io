/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.Power;
import businesslogic.TutorialService;
import dataaccess.UserDB;
import domainmodel.Note;
import domainmodel.Post;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Forum extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        TutorialService ts = new TutorialService();
        if (action != null && action.equals("Logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        List<Post> posts = null;
        try {
            posts = ts.getStory();
        } catch (Exception ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("stories", posts);
        getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(request, response);
        String story = request.getParameter("story");
        TutorialService ts = new TutorialService();
        UserDB userDB = new UserDB();
    }
}
