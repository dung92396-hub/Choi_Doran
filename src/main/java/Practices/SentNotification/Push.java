package Practices.SentNotification;

public class Push implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Gửi tin nhắn qua thông báo đẩy (Push) với nội dung: " + message);
    }
}
