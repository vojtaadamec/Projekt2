package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CoinTossingFrame extends JFrame {
    private final JTextField inputField = new JTextField();
    private final ChartPanel chartPanel = new ChartPanel();

    public CoinTossingFrame() {
        setTitle("Simulace hodu mincí");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setPreferredSize(new Dimension(120, getHeight()));
        JButton startButton = new JButton("Start");
        controlPanel.add(new JLabel("Počet hodů: "));
        controlPanel.add(Box.createVerticalStrut(15));
        inputField.setMaximumSize(new Dimension(100, 25));
        controlPanel.add(inputField);
        controlPanel.add(Box.createVerticalStrut(15));
        startButton.setMaximumSize(new Dimension(100, 25));

        controlPanel.add(startButton);
        add(controlPanel, BorderLayout.WEST);
        add(chartPanel, BorderLayout.CENTER);


        startButton.addActionListener(e -> simulateTosses());
    }

    private void simulateTosses() {
        String text = inputField.getText().trim();

        if (!text.matches("[1-9][0-9]*")) {
            JOptionPane.showMessageDialog(this, "Toto není přirozené číslo, zadejte přirozené číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int n = Integer.parseInt(text);
        int panna = 0;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            if (random.nextBoolean()) panna++;
        }

        double pannaProcenta = 100 * panna / n;
        double orelProcenta = 100 - pannaProcenta;

        chartPanel.setData(pannaProcenta, orelProcenta);
    }
    private static class ChartPanel extends JPanel {
        private double panna = 0;
        private double orel = 0;

        public void setData(double panna, double orel) {
            this.panna = panna;
            this.orel = orel;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight() - 50;
            int barWidth = 100;
            int hHeight = (int) (height * (panna / 100));
            int tHeight = (int) (height * (orel / 100));

            g.setColor(Color.RED);
            g.fillRect(80, getHeight() - hHeight, barWidth, hHeight);
            g.setColor(Color.BLACK);
            g.drawString(String.format("Panna: %.1f%%", panna), 85, getHeight() - hHeight - 10);
            g.setColor(Color.BLUE);
            g.fillRect(240, getHeight() - tHeight, barWidth, tHeight);
            g.setColor(Color.BLACK);
            g.drawString(String.format("Orel: %.1f%%", orel), 245, getHeight() - tHeight - 10);
        }
    }
}
