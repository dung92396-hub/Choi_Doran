package Java_set;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<User> set = new HashSet<>();
        User u1 = new User("Phuc", 1);
        User u2 = new User("Sang", 2);
        User u3 = new User("Phuc", 1);
        set.add(u1);
        set.add(u2);
        set.add(u3);



        System.out.println(set);
    }
}
