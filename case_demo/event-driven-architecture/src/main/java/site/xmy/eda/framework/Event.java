package site.xmy.eda.framework;

public interface Event {
    Class<? extends Event> getType();
}
