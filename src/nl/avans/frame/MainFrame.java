package nl.avans.frame;

import javax.swing.*;

import nl.avans.businesslogic.ShapeController;
import nl.avans.businesslogic.service.*;

import java.awt.*;

public class MainFrame extends JFrame {
    public ConversionService conversionService;
    public ShapeController shapeController;

    public MainFrame() throws HeadlessException {
        conversionService = new ConversionService();
        shapeController = new ShapeController();
    }
}
