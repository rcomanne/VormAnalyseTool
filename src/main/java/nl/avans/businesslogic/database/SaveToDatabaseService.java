package nl.avans.businesslogic.database;

import nl.avans.domain.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaveToDatabaseService extends DatabaseService {

    public SaveToDatabaseService(String username) {
        connection = null;
        statement = null;
        this.username = username;
    }


    public boolean saveAllToDatabase (ArrayList<Shape> shapes) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("MySQL Driver not found");
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shapes",username, password);
        } catch (SQLException sqle) {
            System.out.println("SQL Connection Exception");
            sqle.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            statement.execute("truncate `shapes`");
            for (Shape shape : shapes) {
                String sql = createSqlQuery(shape);
                if (sql.contains("not recognized")) {
                    return false;
                }
                statement.executeUpdate(sql);
            }
            return true;
        } catch (SQLException sqle) {
            System.out.println("SQL Statement Exception");
            sqle.printStackTrace();
            return false;
        }
        // Close resources
        finally {
            this.closeResources();
        }
    }

    private String createSqlQuery (Shape shape) {
        StringBuilder query = new StringBuilder("INSERT INTO shapes VALUES(");

        if (shape instanceof Cone) {
            Cone cone = (Cone)shape;
            query.
                append("'Cone', ").
                append(shape.getVolume()+", ").
                append(cone.getRadius()+", ").
                append(cone.getHeight()+", ").
                append("0.0)");
            return query.toString();
        } else if (shape instanceof Cube) {
            Cube cube = (Cube) shape;
            query.
                append("'Cube', ").
                append(cube.getVolume()+", ").
                append(cube.getLength()+", ").
                append(cube.getHeight()+", ").
                append(cube.getWidth()+")");
            return query.toString();
        } else if (shape instanceof Cylinder) {
            Cylinder cylinder = (Cylinder) shape;
            query.
                append("'Cylinder', ").
                append(cylinder.getVolume()+", ").
                append(cylinder.getRadius()+", ").
                append(cylinder.getHeight()+", ").
                append("0.0)");
            return query.toString();
        } else if (shape instanceof Pyramid) {
            Pyramid pyramid = (Pyramid) shape;
            query.
                append("'Pyramid', ").
                append(pyramid.getVolume()+", ").
                append(pyramid.getBaseArea()+", ").
                append(pyramid.getHeight()+", ").
                append("0.0)");
            return query.toString();
        } else if (shape instanceof Sphere) {
            Sphere sphere = (Sphere) shape;
            query.
                    append("'Sphere', ").
                    append(sphere.getVolume()+", ").
                    append(sphere.getRadius()+",").
                    append("0.0, 0.0)");
            return query.toString();
        }
        return "ShapeNotRecognizedString";
    }
}
