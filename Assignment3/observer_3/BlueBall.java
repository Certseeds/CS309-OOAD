package observer_3;

import javax.xml.stream.events.StartDocument;
import java.awt.*;

public class BlueBall extends Ball implements Subject {
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
    }
    
    @Override
    public void update(Ball ball) {
        if (this.isVisible() && ball.isVisible() && this.isIntersect(ball)) {
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
        for (Observer o : this.observers) {
            o.update(this.getX(), this.getY());
        }
    }
    
    @Override
    public void notifyObservers() {
        for (Observer o : this.observers) {
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
