package nl.avans.main;

import javax.swing.*;

import nl.avans.frame.*;
import nl.avans.panel.*;

public class VormAnalyseTool extends JFrame {

    public static void main(String[] args) {
        MainFrame vormApplicatie = new MainFrame();

        vormApplicatie.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        vormApplicatie.setTitle("Shape Analyse Tool");
        vormApplicatie.setLocation(500, 300);
        vormApplicatie.setSize(500, 500);
        vormApplicatie.setContentPane(new MainPanel(vormApplicatie));
        vormApplicatie.setVisible(true);
    }
}
