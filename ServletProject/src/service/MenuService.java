package service;

import model.Menu;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmal on 6/24/16.
 */
public class MenuService {
    private Connection connection;

    public MenuService() {
        connection = DbConnection.getConnection();
    }

    public List<Menu> getAllMenu() {
        List<Menu> menus = new ArrayList<Menu>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from menu");
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setFoodItem(rs.getString("FoodItem"));
                menu.setCategory(rs.getString("Category"));
                menu.setPrice(rs.getString("Price"));
                menu.setTimeAvailable(rs.getString("TimeAvailable"));

                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    public void deleteMenu(int menuID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from menu where id=?");
            preparedStatement.setInt(1, menuID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Menu getMenuById(int id) {
        Menu menu = new Menu();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from menu where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                menu.setId(rs.getInt("id"));
                menu.setFoodItem(rs.getString("FoodItem"));
                menu.setCategory(rs.getString("Category"));
                menu.setPrice(rs.getString("Price"));
                menu.setTimeAvailable(rs.getString("TimeAvailable"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public void addMenu(Menu menu) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into menu values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, menu.getId());
            preparedStatement.setString(2, menu.getFoodItem());
            preparedStatement.setString(3, menu.getCategory());
            preparedStatement.setString(4, menu.getPrice());
            preparedStatement.setString(5, menu.getTimeAvailable());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Menu updateMenu(Menu menu, int id) {
        try {
            Statement statement = connection.createStatement();

            String updateQuery = "UPDATE menu SET FoodItem='"+menu.getFoodItem()+"', " +
                    "Category='"+menu.getCategory()+"', Price='"+menu.getPrice()+"'," +
                    " TimeAvailable='"+menu.getTimeAvailable()+"' WHERE id='"+id+"'";

            System.out.println(updateQuery);

            statement.execute(updateQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
