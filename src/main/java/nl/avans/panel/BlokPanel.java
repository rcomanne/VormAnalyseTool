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

public class BlokPanel extends MainPanel {
    private JLabel lengthLabel, widthLabel, heightLabel;
    private JTextField lengthField, widthField, heightField;
    private JButton saveButton;
    private MainFrame frame;
    private PopupFrame popupFrame;
    private MainPanel panel;

    private ConversionService conversionService;
    private ShapeController shapeController;

    public BlokPanel (MainFrame mainFrame, PopupFrame popupFrame, MainPanel mainPanel) {
        frame = mainFrame;
        panel = mainPanel;
        this.popupFrame = popupFrame;
        conversionService = frame.conversionService;
        shapeController = frame.shapeController;

        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(3,3, 20, 20));

        lengthLabel = new JLabel("Lengte");
        lengthField = new JTextField();

        widthLabel = new JLabel("Breedte");
        widthField = new JTextField();

        heightLabel = new JLabel("Hoogte");
        heightField = new JTextField();

        saveButton = new JButton("Opslaan");
        saveButton.addActionListener(new SaveListener());


        add(lengthLabel);
        add(widthLabel);
        add(heightLabel);
        add(lengthField);
        add(widthField);
        add(heightField);

        add(saveButton);
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double length, width, height;
            boolean shapeSaved = false;
            while (!shapeSaved) {
                length = conversionService.convertStringToDouble(lengthField);
                height = conversionService.convertStringToDouble(heightField);
                width = conversionService.convertStringToDouble(widthField);
                shapeSaved = shapeController.saveCube(length,height, width);
            }
            panel.renewList();
            popupFrame.dispose();
        }
    }
}
