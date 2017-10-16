package nl.avans.businesslogic;

import nl.avans.domain.*;
import nl.avans.domain.Shape;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShapeControllerTest {
    private static final int NR_OF_SHAPES = 4;
    private static final double VOLUME_OF_SHAPES = 2285.7;

    private ShapeController shapeController;
    private Shape cone, cube, pyramid, sphere;
    private ArrayList<Shape> generatedArrayList, createdArrayList;
    private List generatedShapesList, createdShapesList;

    @Before
    public void setup () {
        cone = new Cone(10, 10);
        cube = new Cube(10, 10, 10);
        pyramid = new Pyramid(10, 15);
        sphere = new Sphere(15);
        shapeController = new ShapeController();
        createArrayListAndList();
        generateArrayListAndList();
    }

    @Test
    public void getShapesArrayListTest() throws Exception {
        assertEquals(generatedArrayList.size(), NR_OF_SHAPES);
        assertEquals(createdArrayList, generatedArrayList);
        assertEquals(createdShapesList.getItems(), (generatedShapesList.getItems()));
    }

    @Test
    public void getTotalVolumeTest() throws Exception {
        assertEquals(shapeController.getTotalVolume(), VOLUME_OF_SHAPES, 0);
    }

    @Test
    public void removeShapeTest() throws Exception {
        int initialSize = generatedArrayList.size();
        assertEquals(initialSize, 4);
        shapeController.removeShape(0);
        shapeController.removeShape(0);
        int finalSize = generatedArrayList.size();
        assertEquals(finalSize, 2);
    }

    @Test
    public void saveEmptyCubeTest () {
        assertFalse(shapeController.saveCube(0,0,0));
    }

    @Test
    public void saveNewSphereTest () {
        assertTrue(shapeController.saveSphere(15));
        assertEquals(generatedArrayList.size(), 5);
        assertTrue(sphere.toString().equals(shapeController.getShape(4).toString()));
    }

    private void createArrayListAndList () {
        createdArrayList = new ArrayList<>();
        createdArrayList.add(cone);
        createdArrayList.add(cube);
        createdArrayList.add(pyramid);
        createdArrayList.add(sphere);

        createdShapesList = new List();
        for (Shape shape : createdArrayList) {
            createdShapesList.add(shape.toString());
        }
    }

    private void generateArrayListAndList () {
        shapeController.addShape(cone);
        shapeController.addShape(cube);
        shapeController.addShape(pyramid);
        shapeController.addShape(sphere);
        generatedArrayList = shapeController.getShapeArrayList();
        generatedShapesList = new List();
        generatedShapesList = shapeController.getShapesList();
    }
}