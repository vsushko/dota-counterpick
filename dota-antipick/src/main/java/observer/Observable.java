package observer;

/**
 * @author vsa
 * @date 08.08.2015.
 */
public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
