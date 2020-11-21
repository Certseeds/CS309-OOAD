import java.awt.*;

public class BlueBall extends Ball {
    boolean collision = false;

    public BlueBall(Color color, int xSpeed, int ySpeed, int ballSize) {
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
        System.out.println("Blue Update");
        this.setXSpeed(-1 * this.getXSpeed());
        this.setYSpeed(-1 * this.getYSpeed());
    }

    @Override
    public void update(int x, int y) {
        collision = update_public(x, y, 70, 40, new Color(51, 153, 255));
    }

}
