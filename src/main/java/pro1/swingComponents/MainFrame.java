package pro1.swingComponents;

import pro1.drawingModel.Drawable;
import pro1.drawingModel.Ellipse;
import pro1.drawingModel.Rectangle;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Random;

public class MainFrame extends JFrame {
    private DrawingPanel drawingPanel;
    private int lastX;
    private int lastY;

    public MainFrame(Drawable example) {
        setTitle("PRO1 Graphics");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanel(example);
        add(drawingPanel, BorderLayout.CENTER);
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(100,0));
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setLayout(new FlowLayout());

        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1); // Minimální hodnota = 1 (přirozená čísla)
        formatter.setAllowsInvalid(false); // Nepovoluje neplatné vstupy
        formatter.setCommitsOnValidEdit(true); // Automaticky aktualizuje hodnotu

        JFormattedTextField textField = new JFormattedTextField(formatter);

        textField.setColumns(10);
        JButton button = new JButton("START");


        leftPanel.add(button);
        leftPanel.add(new JLabel("Zadejte přirozené číslo:"));
        leftPanel.add(textField);

        Random random = new Random();

        button.addActionListener((e)->{
            {
                String r =String.format("%02X", random.nextInt(256));
            }
            drawingPanel.setImage( new Rectangle(lastX,lastY,100,300,"#734234"));
        });

    }
}