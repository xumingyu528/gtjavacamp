package site.xmy.eda.event;

import site.xmy.eda.model.User;

public class UserCreatedEvent extends AbstractEvent {
    User user;

    public UserCreatedEvent(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
