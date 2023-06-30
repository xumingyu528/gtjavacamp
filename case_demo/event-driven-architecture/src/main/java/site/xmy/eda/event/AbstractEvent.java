package site.xmy.eda.event;

import site.xmy.eda.framework.Event;

public class AbstractEvent implements Event {
    @Override
    public Class<? extends Event> getType() {
        return getClass();
    }
}
