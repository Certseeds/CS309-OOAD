package observer_3;

import java.awt.*;

public class RedBall extends Ball implements Subject{
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
    }
    
    @Override
    public void update(Ball ball) {
        if (this.isVisible()&& ball.isVisible()&&this.isIntersect(ball)){
            this.setVisible(false);
            ball.setVisible(false);
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
    public void notifyObservers(char keyChar) {
        for (Observer o: this.observers){
            o.update(this.getX(),this.getY());
        }
    }
    
    @Override
    public void notifyObservers() {
        for (Observer o:this.observers){
            o.update(this);
        }
    }
    public void move(Boolean start) {
        if (start) {
            notifyObservers();
        }
        super.move(start);
    }
}
