/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.Power;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 729347
 */
public class GraphServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action != null && action.equals("Logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String function = request.getParameter("function");
        HttpSession session = request.getSession();
        
        Power p = new Power();
        if (action != null && action.equals("getGraph")) {
            List<Integer> count = new ArrayList<Integer>();
            count.add(0);
            count.add(1);
            count.add(2);
            count.add(3);
            count.add(4);
            count.add(5);
            count.add(6);
            List<String> newTable = new ArrayList<String>();
            newTable.add("-3");
            newTable.add("-2");
            newTable.add("-1");
            newTable.add("0");
            newTable.add("1");
            newTable.add("2");
            newTable.add("3");
            char first = function.charAt(0);
            char second = function.charAt(1);
            char third = function.charAt(2);
            String power = String.valueOf(third);
            int newNum = Integer.parseInt(power);
            System.out.println(third);
            List<Double> graph = new ArrayList<Double>();
            if (first == 'x') {
                if (second == '^') {
                    for (int j = -3; j < 4; j++) {
                        graph.add(p.calculatePower(j, newNum));
                    }
                }
            }

            session.setAttribute("table", newTable);
            session.setAttribute("values", graph);
            session.setAttribute("count", count);
            getServletContext().getRequestDispatcher("/WEB-INF/graph.jsp").forward(request, response);
        }
    }
}
