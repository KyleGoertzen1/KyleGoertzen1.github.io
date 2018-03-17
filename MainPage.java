/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 729347
 */
public class MainPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String loginUser = (String) session.getAttribute("log");
        if (action != null && action.equals("Logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        if (action != null && action.equals("Calc")) {
            getServletContext().getRequestDispatcher("/WEB-INF/graph.jsp").forward(request, response);
            return;
        }
        
        if (action != null && action.equals("MainForum")) {
            getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(request, response);
            return;
        }
        
        if (loginUser == null) {
            //.sendRedirect("login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else if (loginUser.equals("user")) {
            //response.sendRedirect("main");
            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            return;
        } else if (loginUser.equals("admin")) {
            //response.sendRedirect("main");
            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
