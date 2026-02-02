package Practices.SentNotification;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "internalBuilder")
public class User implements Observer {
    private Long id;
    private String name;
    private LocalDate birthday;
    private boolean undergraduate;
    private Notification notification;


    public static UserBuilder builder(Long id, String name) {
        return internalBuilder().id(id).name(name).notification(new Email());
    }

    public void setNotification(NotificationType type) {
        NotificationManager n = new NotificationManager();
        this.notification = n.create(type);
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + ":");
        this.notification.send(message);
    }
}
