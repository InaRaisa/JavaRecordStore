package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * This Servlet only demonstrates how to render the hello.jsp file
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Display contents of /WEB-INF/views/hello.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");

        dispatcher.include(req, resp);
    }
}