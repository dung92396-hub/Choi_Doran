package Practices.SentNotification;

public interface UserInterface {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}
