package Views;

import java.awt.event.*;
import javax.swing.*;

public class GameMainView {
    JPanel titlePageView = new JPanel();
    JButton startButton = new JButton();
    JLabel  gameTitle = new JLabel();
    JTextArea subTitle = new JTextArea();

    public GameMainView() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /** Something **/
            }
        });
    }
}
