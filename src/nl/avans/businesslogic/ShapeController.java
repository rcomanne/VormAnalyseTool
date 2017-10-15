package nl.avans.businesslogic;

import nl.avans.domain.*;

import java.util.ArrayList;

public class ShapeController {
    private ArrayList<Shape> shapeCollection;

    public ShapeController () {
        shapeCollection = new ArrayList<>();
    }

    public double getTotalVolume() {
        double total = 0;
        for (Shape shape : shapeCollection) {
            total += shape.getVolume();
        }
        return total;
    }

    private boolean addShape (Shape shape) {
        return shapeCollection.add(shape);
    }

    public void removeShape (int index) {
        if (!shapeCollection.isEmpty()) {
            shapeCollection.remove(index);
        }
    }

    public Shape getShape (int index) {
        return shapeCollection.get(index);
    }

    public boolean saveShape (double length, double height, double width) {
        if (length != 0 && height != 0 && width != 0) {
            Shape blok = new Blok(length, width, height);
            return addShape(blok);
        }
        return false;
    }

    public boolean saveShape (double height, double radius) {
        if (radius != 0 && height != 0) {
            Shape cilinder = new Cilinder(height, radius);
            return addShape(cilinder);
        }
        return false;
    }

    public boolean saveShape (double radius) {
        if (radius != 0) {
            Shape bol = new Bol(radius);
            return addShape(bol);
        }
        return false;
    }
}
