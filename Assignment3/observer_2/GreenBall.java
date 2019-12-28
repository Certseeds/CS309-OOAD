package observer_2;

import java.awt.*;
import java.util.ArrayList;

public class GreenBall extends Ball implements Subject{
    public GreenBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
    }
    
    public void update(int x, int y) {}
    public void update(char keyChar) {
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
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }
    
    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }
    @Override
    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++) {
            Observer temp = this.observers.get(i);
            temp.update(this.getX(), this.getY());
        }
    }
    @Override
    public void notifyObservers(char keyChar) {}
    @Override
    
    public void move(){
        super.move();
        this.notifyObservers();
    }
}
