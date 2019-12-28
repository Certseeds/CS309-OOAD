package observer_3;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RedBall redBall = new RedBall(Color.RED, 3, 10, 50);
        GreenBall greenBall = new GreenBall(Color.GREEN, 5, 7, 100);
        BlueBall blueBall = new BlueBall(Color.BLUE, 8, 10, 80);
        ArrayList <Ball> balls = new ArrayList<Ball>();
        greenBall.registerObserver(redBall);
        greenBall.registerObserver(blueBall);
        blueBall.registerObserver(redBall);
        balls.add(greenBall);
        balls.add(redBall);
        balls.add(blueBall);
        MainPanel mainPanel = new MainPanel(balls);
        mainPanel.registerObserver(redBall);
        mainPanel.registerObserver(greenBall);
        mainPanel.registerObserver(blueBall);
        
        SwingFacade.launch(SwingFacade.createTitledPanel("Observer Pattern Example", mainPanel), "");
    }
}
