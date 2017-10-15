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

public class PyramidPanel extends MainPanel {
    private JLabel baseLabel, heightLabel;
    private JTextField baseField, heightField;
    private JButton saveButton;
    private MainFrame frame;
    private PopupFrame popupFrame;
    private MainPanel panel;

    private ConversionService conversionService;
    private ShapeController shapeController;

    public PyramidPanel(MainFrame mainFrame, PopupFrame popupFrame, MainPanel mainPanel) {
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


        baseLabel = new JLabel("Basisareaal:");
        baseField = new JTextField();

        heightLabel = new JLabel("Hoogte:");
        heightField = new JTextField();

        saveButton = new JButton("Opslaan");
        saveButton.addActionListener(new SaveListener());

        add(baseLabel);
        add(baseField);
        add(heightLabel);
        add(heightField);

        add(saveButton);
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double height, base;
            boolean shapeSaved = false;
            while (!shapeSaved) {
                base = conversionService.convertStringToDouble(baseField);
                height = conversionService.convertStringToDouble(heightField);
                shapeSaved = shapeController.savePyramid(base, height);
            }
            panel.renewList();
            popupFrame.dispose();
        }
    }
}
