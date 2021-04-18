package patterns;

import javax.swing.*;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class StateChangeOnSingleThread extends JFrame {

    public void execute() {
        SwingUtilities.invokeLater(() -> System.out.println("Called later"));
    }

}
