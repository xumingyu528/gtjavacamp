package site.xmy.eda.handler;

import site.xmy.eda.event.UserCreatedEvent;
import site.xmy.eda.event.UserUpdatedEvent;
import site.xmy.eda.framework.Handler;

public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {

    @Override
    public void onEvent(UserUpdatedEvent event) {
        System.out.println(String.format("User has been Updated! '%s'",event.getEvent()));
    }
}
