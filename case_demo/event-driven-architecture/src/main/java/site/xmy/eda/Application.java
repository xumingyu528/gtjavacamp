package site.xmy.eda;

import site.xmy.eda.event.UserCreatedEvent;
import site.xmy.eda.event.UserUpdatedEvent;
import site.xmy.eda.framework.EventDispatcher;
import site.xmy.eda.handler.UserCreatedEventHandler;
import site.xmy.eda.handler.UserUpdatedEventHandler;
import site.xmy.eda.model.User;

public class Application {
    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(UserCreatedEvent.class,new UserCreatedEventHandler());
        dispatcher.registerHandler(UserUpdatedEvent.class,new UserUpdatedEventHandler());

        User zhangsan = new User("ZhangSan");
        dispatcher.dispatch(new UserCreatedEvent(zhangsan));
        User oldUser = zhangsan;
        zhangsan = new User("LiSi");
        dispatcher.dispatch(new UserUpdatedEvent(oldUser,zhangsan));
    }
}
