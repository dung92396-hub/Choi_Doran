package Java8_pack.AnimalManger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    // tinh theo thang
    private int old;
    // loai thu nuoi
    private Type type;
    // tinh trang suc khoe tong quat
    private Health health;
    // tien su kiem tra suc khoe
    private List<LocalDate> history;

    public Pet(String name, int old, Type type, Health health) {
        this.name = name;
        this.old = old;
        this.type = type;
        this.health = health;
        this.history = new ArrayList<>();
    }

    public boolean isBeforeDate(LocalDate date) {
        return history
                .stream()
                .anyMatch(d -> d.isBefore(date));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public List<LocalDate> getHistory() {
        return history;
    }

    public void setHistory(List<LocalDate> history) {
        this.history = history;
    }
}
