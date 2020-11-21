import java.awt.*;

public class GreenBall extends Ball {
    public GreenBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
    }

    @Override
    public void update(char keyChar) {
        System.out.println("Green Update");
        switch (keyChar) {
            case 'a':
                this.setXSpeed(Math.abs(this.getXSpeed()) * -1);
                break;
            case 'd':
                this.setXSpeed(Math.abs(this.getXSpeed()));
                break;
            case 'w':
                this.setYSpeed(Math.abs(this.getYSpeed()) * -1);
                break;
            case 's':
                this.setYSpeed(Math.abs(this.getYSpeed()));
                break;
        }
    }

    @Override
    public void update(int x, int y) {
    }
}
