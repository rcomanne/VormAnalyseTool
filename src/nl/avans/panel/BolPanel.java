package nl.avans.panel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BolPanel extends JPanel {
    JLabel straalLabel;
    JTextField straalField;
    JButton saveButton, cancelButton;

    public BolPanel() {
        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(2,2, 20, 20));

        straalLabel = new JLabel("Straal:");
        straalField = new JTextField();

        saveButton = new JButton("Opslaan");

        cancelButton = new JButton("Annuleer");
    }
}
