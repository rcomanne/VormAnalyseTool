package nl.avans.panel;

import nl.avans.shape.Vorm;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainPanel  extends JPanel{
    JLabel shapeLabel, inhoudLabel ,totalLabel;
    JButton saveButton, removeButton, loadButton, totalButton;
    JComboBox<String> shapeCombo;
    JTextField inhoudField, totalField;
    JList<Vorm> shapeList;
    JScrollPane shapeScrollPane;

    public MainPanel() {
        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(8,2, 20, 20));


        shapeLabel = new JLabel("Vorm:", SwingConstants.RIGHT);
        String[] choices = {"Bol", "Blok", "Cilinder"};
        shapeCombo = new JComboBox<String>(choices);

        inhoudLabel = new JLabel("Inhoud:", SwingConstants.RIGHT);
        inhoudField = new JTextField("0.0");
        inhoudField.setEditable(false);

        totalLabel = new JLabel("Totale inhoud:", SwingConstants.RIGHT);
        totalField = new JTextField("0.0");
        totalField.setEditable(false);

        saveButton = new JButton("Opslaan");
        saveButton.setSize(30, 30);
        loadButton = new JButton("Laad");
        loadButton.setSize(30, 30);

        shapeList = new JList<Vorm>();
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        shapeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        shapeList.setVisibleRowCount(-1);
        shapeScrollPane = new JScrollPane(shapeList);
        shapeScrollPane.setPreferredSize(new Dimension(40, 80));

        totalButton = new JButton("Total inhoud");
        removeButton = new JButton("Verwijder");

        add(shapeLabel);
        add(shapeCombo);
        add(inhoudLabel);
        add(inhoudField);
        add(totalLabel);
        add(totalField);
        add(saveButton);
        add(loadButton);
        add(shapeScrollPane);
        add(removeButton);
        add(new JLabel());
        add(totalButton);

    }
}
