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

public class BolPanel extends MainPanel {
    private JLabel radiusLabel;
    private JTextField radiusField;
    private JButton saveButton;
    private MainFrame frame;
    private PopupFrame popupFrame;
    private MainPanel panel;

    private ConversionService conversionService;
    private ShapeController shapeController;

    public BolPanel(MainFrame mainFrame, PopupFrame popupFrame, MainPanel mainPanel) {
        frame = mainFrame;
        panel = mainPanel;
        this.popupFrame  = popupFrame;
        conversionService = frame.conversionService;
        shapeController = frame.shapeController;
        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(3,1, 20, 20));

        radiusLabel = new JLabel("Straal:", SwingConstants.CENTER);
        radiusField = new JTextField();

        saveButton = new JButton("Opslaan");
        saveButton.addActionListener(new SaveListener());

        add(radiusLabel);
        add(radiusField);

        add(saveButton);
        popupFrame.getRootPane().setDefaultButton(saveButton);
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double radius;
            boolean shapeSaved = false;
            while (!shapeSaved) {
                radius = conversionService.convertStringToDouble(radiusField);
                shapeSaved = shapeController.saveSphere(radius);
            }
            panel.renewList();
            popupFrame.dispose();
        }
    }
}
