package Practices.SentNotification;

public class Main {
    public static void main(String[] args) {
        User u1 = User.builder(1L, "Hoang Phuc").undergraduate(false).build();
        User u2 = User.builder(2L, "Quang Sang").build();
        User u3 = User.builder(3L, "Khoa Dang").build();
        User u4 = User.builder(4L, "Bao Trung").build();
        User u5 = User.builder(5L, "Duy Quang").build();

        UserManager userManager = new UserManager();
        userManager.registerObserver(u1);
        userManager.registerObserver(u2);
        userManager.registerObserver(u3);
        userManager.registerObserver(u4);
        userManager.registerObserver(u5);

        u2.setNotification(NotificationType.SMS);
        u4.setNotification(NotificationType.PUSH);

        userManager.notifyObservers("Hello world");

        userManager.removeObserver(u2);

    }
}
