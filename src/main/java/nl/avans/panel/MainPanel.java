package nl.avans.panel;

import nl.avans.businesslogic.ShapeController;
import nl.avans.businesslogic.service.ConversionService;
import nl.avans.domain.Shape;
import nl.avans.frame.MainFrame;
import nl.avans.frame.PopupFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class MainPanel  extends JPanel{
    private JLabel saveLabel, volumeLabel,totalLabel;
    private JButton removeButton, loadButton, totalButton;
    private JTextField volumeField, totalField;
    private List shapeList;
    private Choice choices;
    private MainFrame frame;

    private ConversionService conversionService;
    private ShapeController shapeController;

    MainPanel() {
        // Empty default constructor
    }

    public MainPanel(MainFrame mainFrame) {
        frame = mainFrame;
        conversionService = frame.conversionService;
        shapeController = frame.shapeController;
        Border border = BorderFactory.createEmptyBorder(10,10,10,10);
        setBorder(border);
        Color lightBlue = new Color(109, 201, 255);
        setBackground(lightBlue);
        setLayout(new GridLayout(8,2, 20, 20));

        saveLabel = new JLabel("Kies een vorm om een vorm te maken");
        choices = new Choice();
        choices.add("Blok");
        choices.add("Bol");
        choices.add("Cilinder");
        choices.add("Piramide");
        choices.add("Kegel");

        choices.addItemListener(new ChoiceListener());

        volumeLabel = new JLabel("Inhoud:", SwingConstants.RIGHT);
        volumeField = new JTextField("0.0");
        volumeField.setEditable(false);

        totalLabel = new JLabel("Totale inhoud:", SwingConstants.RIGHT);
        totalField = new JTextField("0.0");
        totalField.setEditable(false);

        loadButton = new JButton("Toon Lijst");
        loadButton.addActionListener(new ShowListListener());

        try {
            shapeController.getShapesFromData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        shapeList = shapeController.getShapesList();
        shapeList.addItemListener(new SelectedShapeListener());

        totalButton = new JButton("Total inhoud");
        totalButton.addActionListener(new TotalVolumeListener());
        removeButton = new JButton("Verwijder");
        removeButton.addActionListener(new RemoveShapeListener());

        add(saveLabel);
        add(choices);
        add(volumeLabel);
        add(volumeField);
        add(totalLabel);
        add(totalField);
        add(new JLabel());
        add(totalButton);
        add(loadButton);
        add(shapeList);
        add(removeButton);
    }

    class SelectedShapeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            Shape selectedShape = shapeController.getShapeArrayList().get(shapeList.getSelectedIndex());
            volumeField.setText(conversionService.round(selectedShape.getVolume())+"");
        }
    }

    class ChoiceListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String choice = choices.getSelectedItem();
            createPopup(choice);
        }
    }

    class TotalVolumeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double volume = conversionService.round(shapeController.getTotalVolume());
            totalField.setText("" + volume);
        }
    }

    class ShowListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shapeList = shapeController.getShapesList();
        }
    }

    class RemoveShapeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shapeController.removeShape(shapeList.getSelectedIndex());
            renewList();
        }
    }

    private void createPopup(String shapeName) {
        PopupFrame popupFrame = new PopupFrame();
        popupFrame.setLocation(1000, 300);
        popupFrame.setSize(400, 200);
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        switch (shapeName) {
            case "Bol":
                createBolPanel(popupFrame);
                break;
            case "Blok":
                createBlokPanel(popupFrame);
                break;
            case "Cilinder":
                createCylinderPanel(popupFrame);
                break;
            case "Piramide":
                createPyramidePanel(popupFrame);
                break;
            case "Kegel":
                createKegelPanel(popupFrame);
                break;
        }
        popupFrame.setVisible(true);
    }

    private void createBolPanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Bol");
        popupFrame.setContentPane(new BolPanel(frame, popupFrame, this));
    }

    private void createBlokPanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Blok");
        popupFrame.setContentPane(new BlokPanel(frame, popupFrame, this));
    }
    private void createCylinderPanel(PopupFrame popupFrame) {
        popupFrame.setTitle("Cylinder");
        popupFrame.setContentPane(new CylinderPanel(frame, popupFrame, this));
    }

    private void createPyramidePanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Piramide");
        popupFrame.setContentPane(new PyramidPanel(frame, popupFrame, this));
    }

    private void createKegelPanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Kegel");
        popupFrame.setContentPane(new ConePanel(frame, popupFrame, this));
    }

    void renewList () {
        loadButton.doClick();
    }
}
