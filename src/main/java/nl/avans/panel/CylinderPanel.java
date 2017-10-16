package nl.avans.panel;

import nl.avans.businesslogic.ShapeController;
import nl.avans.businesslogic.service.ConversionService;
import nl.avans.frame.MainFrame;
import nl.avans.frame.PopupFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CylinderPanel extends MainPanel {
    private JLabel radiusLabel, heightLabel;
    private JTextField radiusField, heightField;
    private JButton saveButton;
    private MainFrame frame;
    private PopupFrame popupFrame;
    private MainPanel panel;

    private ConversionService conversionService;
    private ShapeController shapeController;

    public CylinderPanel(MainFrame mainFrame, PopupFrame popupFrame, MainPanel mainPanel) {
        frame = mainFrame;
        panel = mainPanel;
        this.popupFrame = popupFrame;
        conversionService = frame.conversionService;
        shapeController = frame.shapeController;

        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(3,2, 20, 20));


        radiusLabel = new JLabel("Straal:");
        radiusField = new JTextField();

        heightLabel = new JLabel("Hoogte:");
        heightField = new JTextField();

        saveButton = new JButton("Opslaan");
        saveButton.addActionListener(new SaveListener());

        add(radiusLabel);
        add(radiusField);
        add(heightLabel);
        add(heightField);

        add(saveButton);
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double height, radius;
            boolean shapeSaved = false;
            while (!shapeSaved) {
                radius = conversionService.convertStringToDouble(radiusField);
                height = conversionService.convertStringToDouble(heightField);
                shapeSaved = shapeController.saveCylinder(radius, height);
            }
            panel.renewList();
            popupFrame.dispose();
        }
    }
}
