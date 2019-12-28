package observer_2;

import java.awt.*;

public class RedBall extends Ball {
    public RedBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
        this.jump_distance = 100;
        this.distance_jump = 50;
    }
    
    public void update(char keyChar) {
        if (keyChar == 'a' || keyChar == 'd') {
            int temp = this.getXSpeed();
            this.setXSpeed(this.getYSpeed());
            this.setYSpeed(temp);
        }
    }
    public void update(int x, int y) {
        super.update_public(x,y);
        System.out.println("Red");
    }
    
}
