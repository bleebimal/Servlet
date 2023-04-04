package controller;

import model.Menu;
import service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bmal on 6/24/16.
 */
@WebServlet(name = "MenuServlet")
public class MenuServlet extends HttpServlet {

    private MenuService ms = new MenuService();

    private static String LIST_MENU = "/listMenu.jsp";
    private static String INSERT = "/addMenu.jsp";
    private static String UPDATE = "/updateNote.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("menus", ms.getAllMenu());
        request.getRequestDispatcher("/viewMenu.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int menuID = Integer.parseInt(request.getParameter("id"));
            ms.deleteMenu(menuID);
            forward = LIST_MENU;
            request.setAttribute("menus", ms.getAllMenu());
        }
        else if (action.equalsIgnoreCase("edit")){
            int menuID = Integer.parseInt(request.getParameter("id"));
            Menu menu = ms.getMenuById(menuID);
            forward = UPDATE;
            request.setAttribute("menu", menu);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST_MENU;
            request.setAttribute("notes", ms.getAllMenu());
        }
        else {
            forward = INSERT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
