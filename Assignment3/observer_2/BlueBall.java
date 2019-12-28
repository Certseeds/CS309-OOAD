package observer_2;

import java.awt.*;

public class BlueBall extends Ball {
    public BlueBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
        this.jump_distance = 120;
        this.distance_jump = 30;
    }
    
    public void update(char keyChar) {
        this.setXSpeed(-1 * this.getXSpeed());
        this.setYSpeed(-1 * this.getYSpeed());
    }
    
    @Override
    public void update(int x, int y) {
        super.update_public(x, y);
        System.out.println("Blue");
    }
    
}
