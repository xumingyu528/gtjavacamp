package site.xmy.eda.framework;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher {

    private Map<Class<? extends Event>,Handler<? extends Event>> handlers;

    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    public void registerHandler(Class<? extends Event> event,Handler<? extends Event> handler){
        handlers.put(event,handler);
    }

    public <E extends Event> void dispatch(E event){
        Handler handler = handlers.get(event.getClass());
        if (handler != null)
            handler.onEvent(event);
    }


}
