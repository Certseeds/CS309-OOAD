import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GreenBall extends Ball implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public GreenBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
    }

    @Override
    public boolean isCollision() {
        return false;
    }

    @Override
    public void move() {
        super.move();
        this.notifyObservers();
    }

    @Override
    public void update(char keyChar) {
        System.out.println("Green Update");
        switch (keyChar) {
            case 'a': {
                this.setXSpeed(Math.abs(this.getXSpeed()) * -1);
                break;
            }

            case 'd': {
                this.setXSpeed(Math.abs(this.getXSpeed()));
                break;
            }
            case 'w': {
                this.setYSpeed(Math.abs(this.getYSpeed()) * -1);
                break;
            }
            case 's': {
                this.setYSpeed(Math.abs(this.getYSpeed()));
                break;
            }
        }
    }

    @Override
    public void update(int x, int y) {
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(char keyChar) {
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.getX(), this.getY());
        }
        observers.removeIf(Observer::isCollision);
    }
}
