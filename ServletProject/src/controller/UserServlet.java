package controller;

import model.User;
import service.MenuService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by bmal on 5/27/16.
 *
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String operation = request.getParameter("operation");
        String name = request.getParameter("name");
        Boolean success = false;
        if (operation.equals("register")){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setName(name);
            try {
                if(UserService.registerUser(user)){
                    request.setAttribute("message", "Successfully Registered");
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if (operation.equals("login")){
            MenuService ms = new MenuService();
            try {
                success = UserService.loginUser(username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (success){
                request.setAttribute("menus", ms.getAllMenu());
                request.getRequestDispatcher("/listMenu.jsp").forward(request, response);
            }else {
                out.println("Username or Password is Incorrect \n");
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
