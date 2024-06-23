package Main;

import view.MainView;
import controller.MainController;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView view = new MainView();
            MainController controller = new MainController(view);
            controller.iniciar();
        });
    }
}

