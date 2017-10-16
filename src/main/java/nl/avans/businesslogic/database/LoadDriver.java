package nl.avans.businesslogic.database;

import com.sun.istack.internal.Nullable;
import nl.avans.domain.*;

import java.sql.*;
import java.util.ArrayList;

public class LoadDriver {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private final String password = "";
    private String username;

    public LoadDriver(String username) {
        connection = null;
        statement = null;
        resultSet = null;
        this.username = username;
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<Shape> getAllFromDatabase () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("MySQL Driver not found");
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shapes",username, password);
        } catch (SQLException sqle) {
            System.out.println("SQLException");
            sqle.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SHAPES");

            ArrayList<Shape> shapes = new ArrayList<>();
            while (resultSet.next()) {
                String shape = resultSet.getString(1);
                double radius = resultSet.getDouble(3);
                double height = resultSet.getDouble(4);
                double width = resultSet.getDouble(5);
                shapes.add(createShape(shape, radius, height, width));
            }
            return shapes;
        } catch (SQLException sqle) {
            System.out.println("SQL Statement Exception");
            sqle.printStackTrace();
        }
        // Close resources
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    System.out.println("Closing resultset exception");
                }
                resultSet = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    System.out.println("Closing statement exception");
                }
                statement = null;
            }
        }
        // Something went wrong
        return new ArrayList<>();
    }

    @Nullable
    private Shape createShape (String shape, double radius, double height, double width) {
        switch (shape) {
            case "Cone":
                return new Cone(radius, height);
            case "Cube":
                return new Cube(radius, width, height);
            case "Cylinder":
                return new Cylinder(height, radius);
            case "Pyramid":
                return new Pyramid(radius, height);
            case "Sphere":
                return new Sphere(radius);
            default:
                return null;
        }
    }
}
