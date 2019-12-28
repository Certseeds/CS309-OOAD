package observer_3;

import java.awt.*;
import java.util.ArrayList;

public abstract class Ball implements Observer {
    private Color color;
    private int x, y;
    private int xSpeed, ySpeed;
    private int ballSize;
    private boolean visible;
    int jump_distance = 100;
    int distance_jump = 50;
    public ArrayList<Observer> observers;
    
    public Ball(Color color, int xSpeed, int ySpeed, int ballSize) {
        this.color = color;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.ballSize = ballSize;
        this.visible = true;
        this.observers = new ArrayList<Observer>();
        this.x = (int) (Math.random() * 600);
        this.y = (int) (Math.random() * 600);
    }
    
    public void setColor(Color newColor) {
        this.color = newColor;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getYSpeed() {
        return ySpeed;
    }
    
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    public int getXSpeed() {
        return xSpeed;
    }
    
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    
    public int getBallSize() {
        return ballSize;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    public double get_distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    public void draw(Graphics g) {
        if (isVisible()) {
            g.setColor(this.getColor());
            g.fillOval(this.getX(), this.getY(), this.getBallSize(), this.getBallSize());
        }
    }
    
    public void move(Boolean start) {
        int newX = this.getX() + this.getXSpeed();
        int newY = this.getY() + this.getYSpeed();
        
        this.setX(newX);
        this.setY(newY);
        
        if (newX <= 0) {
            this.setXSpeed(Math.abs(getXSpeed()));
        } else if (newX >= 600 - this.getBallSize()) {
            this.setXSpeed(-1 * Math.abs(getXSpeed()));
        }
        
        if (newY <= 0) {
            this.setYSpeed(Math.abs(getYSpeed()));
        } else if (newY > 600 - this.getBallSize()) {
            this.setYSpeed(-1 * Math.abs(getYSpeed()));
        }
    }
    
    public boolean isIntersect(Ball b) {
        int diffX = this.getX() - b.getX();
        int diffY = this.getY() - b.getY();
        double dis = (this.getBallSize() + b.getBallSize()) / 2.0;
        
        return (diffX * diffX) + (diffY * diffY) < dis * dis;
    }
    
    public void update_public(int x, int y) {
        if (get_distance(x,y,this.getX(),this.getY()) >= jump_distance) {
            return;
        }
        int high = Math.min(600, this.getY() + distance_jump);
        int low = Math.min(0, this.getY() - distance_jump);
        int left = Math.min(0, this.getX() - distance_jump);
        int right = Math.max(600, this.getX() + distance_jump);
        double leftup = get_distance(x, y, left, high);
        double leftdown = get_distance(x, y, left, low);
        double rightup = get_distance(x, y, right, high);
        double rightdown = get_distance(x, y, right, low);
        int level = 1;
        int vert = 1;
        if (leftup > Math.max(leftdown, Math.max(rightup, rightdown))) {
            level = -1;
            vert = -1;
        } else if (rightup > Math.max(rightup, Math.max(leftup, leftdown))) {
            vert = -1;
        } else if (leftdown > Math.max(leftup, Math.max(rightup, rightdown))) {
            level = -1;
        }
        this.setX(this.getX() + distance_jump * level);
        this.setY(this.getY() + distance_jump * vert);
        int xspeed = Math.abs(this.getXSpeed());
        int yspeed = Math.abs(this.getYSpeed());
        this.setXSpeed(level * xspeed);
        this.setYSpeed(vert * yspeed);
        
        System.out.println("jump!");
    }
}

