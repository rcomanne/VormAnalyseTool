package nl.avans.panel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BlokPanel extends JPanel {
    JLabel lengteLabel, breedteLabel, hoogteLabel;
    JTextField lengteField, breedteField, hoogteField;
    JButton saveButton, cancelButton;

    public BlokPanel () {
        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(8,2, 20, 20));


        saveButton = new JButton("Opslaan");

        cancelButton = new JButton("Annuleer");
    }
}
