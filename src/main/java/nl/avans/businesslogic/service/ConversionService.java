package nl.avans.businesslogic.service;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Service for converting Strings to Doubles and handling the exceptions
 */
public class ConversionService {

    public double convertStringToDouble(JTextField textField) {
        try {
            textField.setBackground(Color.WHITE);
            if (textField.getText().equals("")) {
                return 0;
            }
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException nfe) {
            textField.setBackground(Color.RED);
        }
        return 0;
    }

    /**
     * Rounds the value to a value with 2 decimals
     * @param value
     * @return
     */
    public double round (double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Rounds the value to a value with 2 decimals in a static context
     * @param value
     * @return
     */
    public static double staticRound(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
