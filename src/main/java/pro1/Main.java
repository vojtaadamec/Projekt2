package pro1;

import pro1.drawingModel.*;
import pro1.swingComponents.CoinTossingFrame;
import pro1.swingComponents.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CoinTossingFrame frame = new CoinTossingFrame();
            frame.setVisible(true);
        });
    }
}