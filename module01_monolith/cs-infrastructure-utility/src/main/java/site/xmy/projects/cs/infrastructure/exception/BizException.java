package site.xmy.projects.cs.infrastructure.exception;

public class BizException extends RuntimeException implements ExceptionMessage {
    @Override
    public MessageCode getMessageCode() {
        return null;
    }
}
