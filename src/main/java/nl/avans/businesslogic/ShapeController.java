package nl.avans.businesslogic;

import nl.avans.businesslogic.database.LoadFromDatabaseService;
import nl.avans.businesslogic.database.SaveToDatabaseService;
import nl.avans.businesslogic.service.DataFileOutService;
import nl.avans.businesslogic.service.TextOutService;
import nl.avans.domain.*;
import nl.avans.domain.Shape;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ShapeController {
    private ArrayList<Shape> shapeArrayList;
    private List shapesList;
    private LoadFromDatabaseService loadFromDatabaseService;
    private SaveToDatabaseService saveToDatabaseService;

    public ShapeController () {
        shapeArrayList = new ArrayList<>();
        shapesList = new List();
        loadFromDatabaseService = null;
        saveToDatabaseService = null;
    }

    public ArrayList<Shape> getShapeArrayList() {
        return shapeArrayList;
    }

    public List getShapesList () {
        if (shapesList != null) {
            shapesList.removeAll();
        }
        for (Shape shape : shapeArrayList) {
            shapesList.add(shape.toString());
        }
        return shapesList;
    }

    public void getShapesFromData () throws IOException {
        ArrayList<Shape> shapes = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("data/shapes.data");
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                shapes.add((Shape) ois.readObject());
            }
        } catch (EOFException eof) {
            // End of file reached
            System.out.println("End of file.");
        } catch (FileNotFoundException fne) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassCastException cce) {
            System.out.println("Something went wrong");
            cce.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        finally {
            if (fis != null) {
                fis.close();
            }
            if (ois != null) {
                ois.close();
            }
            setShapeArrayList(shapes);
        }
    }

    public ArrayList<Shape> getShapesFromDatabase () {
        loadFromDatabaseService = new LoadFromDatabaseService("root");
        return loadFromDatabaseService.getAllFromDatabase();
    }

    public boolean exportShapesToDatabase (ArrayList<Shape> shapes) {
        saveToDatabaseService = new SaveToDatabaseService("root");
        return saveToDatabaseService.saveAllToDatabase(shapes);
    }

    private void setShapeArrayList(ArrayList<Shape> shapeArrayList) {
        this.shapeArrayList = shapeArrayList;
    }

    public double getTotalVolume() {
        double total = 0;
        for (Shape shape : shapeArrayList) {
            total += shape.getVolume();
        }
        return total;
    }

    boolean addShape (Shape shape) {
        return shapeArrayList.add(shape);
    }

    public void removeShape (int index) {
        if (!shapeArrayList.isEmpty()) {
            shapeArrayList.remove(index);
        }
    }

    public Shape getShape (int index) {
        return shapeArrayList.get(index);
    }

    private boolean writeShape (Shape shape) {
        try {
            new DataFileOutService(shape);
            new TextOutService(shape);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean saveCube(double length, double height, double width) {
        if (length != 0 && height != 0 && width != 0) {
            Shape cube = new Cube(length, width, height);
            return addShape(cube) && writeShape(cube);
        }
        return false;
    }

    public boolean saveCylinder(double height, double radius) {
        if (radius != 0 && height != 0) {
            Shape cylinder = new Cylinder(radius, height);
            return addShape(cylinder) && writeShape(cylinder);
        }
        return false;
    }

    public boolean saveSphere (double radius) {
        if (radius != 0) {
            Shape sphere = new Sphere(radius);
            return addShape(sphere) && writeShape(sphere);
        }
        return false;
    }

    public boolean savePyramid (double base, double height) {
        if (base != 0 && height != 0) {
            Shape pyramid = new Pyramid(base, height);
            return addShape(pyramid) && writeShape(pyramid);
        }
        return false;
    }

    public boolean saveCone (double radius, double height) {
        if (radius != 0 && height != 0) {
            Shape cone = new Cone(radius, height);
            return addShape(cone) && writeShape(cone);
        }
        return false;
    }
}
