import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Observer Pattern 2020");
        setSize(720, 630);
        setBackground(Color.gray);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        mainPanel.setLocation(5, 5);
        this.add(mainPanel);

        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setLocation(600, 5);
        this.add(buttonPanel);


        JButton red = buttonPanel.getAddRed();
        JButton blue = buttonPanel.getAddBlue();
        JButton start = buttonPanel.getStart();

        mainPanel.setGreenBall(new GreenBall(Color.GREEN, 7, 7, 40));

        mainPanel.addBallToPanel(new RedBall(Color.RED, 4, 5, 60));

        red.addActionListener(l -> {
            if (Ball.getCount() < Ball.TOTAL_NUM) {
                mainPanel.addBallToPanel(new RedBall(Color.RED, 4, 5, 60));
            }
        });

        blue.addActionListener(l -> {
            if (Ball.getCount() < Ball.TOTAL_NUM) {
                mainPanel.addBallToPanel(new BlueBall(Color.BLUE, 6, 4, 60));
            }
        });

        start.addActionListener(l -> {
            mainPanel.startGame();
            red.setEnabled(false);
            blue.setEnabled(false);
            start.setEnabled(false);
        });

    }
}
