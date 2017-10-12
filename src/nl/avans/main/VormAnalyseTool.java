package nl.avans.main;

import javax.swing.*;

import nl.avans.frame.*;
import nl.avans.panel.*;

public class VormAnalyseTool extends JFrame {

    public static void main(String[] args) {
        JFrame vormApplicatie = new MainFrame();

        JFrame blokPopup = new PopupFrame();
        blokPopup.setLocation(900, 300);
        blokPopup.setSize(200, 200);
        blokPopup.setTitle("Nieuwe vorm");
        blokPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vormApplicatie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vormApplicatie.setTitle("Vorm Analyse Tool");
        vormApplicatie.setLocation(500, 300);
        vormApplicatie.setSize(400, 400);
        vormApplicatie.setContentPane(new MainPanel());
        vormApplicatie.setVisible(true);
    }
}
