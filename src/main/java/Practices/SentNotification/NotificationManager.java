package Practices.SentNotification;

public class NotificationManager {
    public Notification create(NotificationType type) {
        return switch (type) {
            case EMAIL -> new Email();
            case SMS -> new Sms();
            case PUSH -> new Push();
        };
    }
}
