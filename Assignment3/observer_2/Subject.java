package observer_2;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(char keyChar);
    public void notifyObservers();
}

