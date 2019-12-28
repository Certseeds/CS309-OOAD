package observer_3;

public interface Observer{
    public void update(char keyChar);
    public void update(int x, int y);
    public void update(Ball ball);
}
