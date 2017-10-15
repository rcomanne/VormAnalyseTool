package nl.avans.businesslogic.service;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversionService {

    public double convertStringToDouble(JTextField textField) {
        try {
            textField.setBackground(Color.WHITE);
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException nfe) {
            textField.setBackground(Color.RED);
        }
        return 0;
    }

    public double round (double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double staticRound (double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
