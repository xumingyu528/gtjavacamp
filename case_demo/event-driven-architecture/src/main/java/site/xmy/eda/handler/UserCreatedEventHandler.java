package site.xmy.eda.handler;

import site.xmy.eda.event.UserCreatedEvent;
import site.xmy.eda.framework.Event;
import site.xmy.eda.framework.Handler;

public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

    @Override
    public void onEvent(UserCreatedEvent event) {
        System.out.println(String.format("User '%s' has been Created!",event.getUser().getName()));
    }
}
