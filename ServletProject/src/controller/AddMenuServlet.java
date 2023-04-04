package controller;

import model.Menu;
import service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bmal on 6/27/16.
 */
@WebServlet(name = "AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MenuService ms = new MenuService();
        Menu menu = new Menu();


        menu.setId(Integer.parseInt(request.getParameter("id")));
        menu.setFoodItem(request.getParameter("foodItem"));
        menu.setCategory(request.getParameter("category"));
        menu.setPrice(request.getParameter("price"));
        menu.setTimeAvailable(request.getParameter("timeAvailable"));
        ms.addMenu(menu);

        request.setAttribute("menus", ms.getAllMenu());
        request.getRequestDispatcher("/listMenu.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
