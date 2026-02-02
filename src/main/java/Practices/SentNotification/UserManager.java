package Practices.SentNotification;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserManager implements UserInterface {
    private List<Observer> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.users.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.users.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        this.users.forEach(u -> u.update(message));
    }
}
