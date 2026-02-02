package Practices.SentNotification;

public class Sms implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Gửi tin nhắn qua SMS với nội dung: " + message);
    }
}
