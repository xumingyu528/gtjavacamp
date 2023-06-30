package site.xmy.eda.framework;

public interface Handler<E extends Event> {
    void onEvent(E event);
}
