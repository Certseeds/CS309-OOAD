import java.awt.*;

public class RedBall extends Ball {
    boolean collision = false;

    public RedBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
    }

    @Override
    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    @Override
    public void update(char keyChar) {
        System.out.println("Red Exchange");
        if (keyChar == 'a' || keyChar == 'd') {
            int temp = this.getXSpeed();
            this.setXSpeed(this.getYSpeed());
            this.setYSpeed(temp);
        }
    }

    @Override
    public void update(int x, int y) {
        collision = update_public(x, y, 70, 40, new Color(255, 0, 102));
    }

}
