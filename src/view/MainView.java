package view;

import model.Figuras;
import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class MainView extends JFrame {
    private JPanel drawingPanel;
    private Figuras figuraActual = Figuras.NONE;

    public MainView() {
        setTitle("Figuras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                switch (figuraActual) {
                    case TRIANGULO -> dibujarTriangulo(g);
                    case CUADRADO -> dibujarCuadrado(g);
                    case CIRCULO -> dibujarCirculo(g);
                }
            }
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue());

        Consumer<Figuras> buttonAction = figura -> {
            figuraActual = figura;
            drawingPanel.repaint();
        };

        addButton("Dibujar triangulo", buttonPanel, buttonAction, Figuras.TRIANGULO);
        addButton("Dibujar cuadrado", buttonPanel, buttonAction, Figuras.CUADRADO);
        addButton("Dibujar circulo", buttonPanel, buttonAction, Figuras.CIRCULO);

        buttonPanel.add(Box.createVerticalGlue());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.WEST);
    }

    private void addButton(String title, JPanel panel, Consumer<Figuras> action, Figuras figura) {
        JButton button = new JButton(title);
        button.addActionListener(e -> action.accept(figura));
        panel.add(button);
        panel.add(Box.createVerticalStrut(10));
    }

    private void dibujarTriangulo(Graphics g) {
        int[] xPoints = {200, 300, 250};
        int[] yPoints = {220, 220, 120};
        int nPoints = 3;
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

    private void dibujarCuadrado(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(200, 120, 100, 100);
    }

    private void dibujarCirculo(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(200, 120, 100, 100);
    }
}
