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

public class MainPanel  extends JPanel{
    private JLabel saveLabel, volumeLabel,totalLabel;
    private JButton removeButton, loadButton, totalButton;
    private JTextField volumeField, totalField;
    private JList<Shape> shapeList;
    private JScrollPane shapeScrollPane;
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

        choices.addItemListener(new ChoiceListener());

        volumeLabel = new JLabel("Inhoud:", SwingConstants.RIGHT);
        volumeField = new JTextField("0.0");
        volumeField.setEditable(false);

        totalLabel = new JLabel("Totale inhoud:", SwingConstants.RIGHT);
        totalField = new JTextField("0.0");
        totalField.setEditable(false);

        loadButton = new JButton("Laad");
        loadButton.setSize(30, 30);

        shapeList = new JList<>();
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        shapeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        shapeList.setVisibleRowCount(-1);
        shapeScrollPane = new JScrollPane(shapeList);
        shapeScrollPane.setPreferredSize(new Dimension(40, 80));

        totalButton = new JButton("Total inhoud");
        totalButton.addActionListener(new TotalVolumeListener());
        removeButton = new JButton("Verwijder");

        add(saveLabel);
        add(choices);
        add(volumeLabel);
        add(volumeField);
        add(totalLabel);
        add(totalField);
        add(new JLabel());
        add(totalButton);
        add(loadButton);
        add(shapeScrollPane);
        add(removeButton);
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
            double volume = conversionService.round(shapeController.getTotalVolume(), 2);
            totalField.setText("" + volume);
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
                createCilinderPanel(popupFrame);
                break;
        }
        popupFrame.setVisible(true);
    }

    private void createBolPanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Bol");
        popupFrame.setContentPane(new BolPanel(frame, popupFrame));
    }

    private void createBlokPanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Blok");
        popupFrame.setContentPane(new BlokPanel(frame, popupFrame));
    }
    private void createCilinderPanel (PopupFrame popupFrame) {
        popupFrame.setTitle("Cilinder");
        popupFrame.setContentPane(new CilinderPanel(frame, popupFrame));
    }
}
