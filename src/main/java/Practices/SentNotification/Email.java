package Practices.SentNotification;

public class Email implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Gửi tin nhắn qua Email với nội dung: " + message);
    }
}
