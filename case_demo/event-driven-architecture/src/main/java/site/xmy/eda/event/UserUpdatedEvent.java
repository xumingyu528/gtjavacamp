package site.xmy.eda.event;

import site.xmy.eda.model.User;

public class UserUpdatedEvent extends AbstractEvent {
    User oldUser;
    User newUser;

    public UserUpdatedEvent(User olduser,User newUser){
        this.oldUser = olduser;
        this.newUser = newUser;
    }

    public String getEvent() {
        return oldUser.getName() + " has been altered, new name is : " + newUser.getName();
    }
}
