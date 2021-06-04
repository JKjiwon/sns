package hello.sns.web.exception.business;

import hello.sns.web.exception.business.BusinessException;

public class FileDeleteException extends BusinessException {
    public FileDeleteException() {
    }

    public FileDeleteException(String message) {
        super(message);
    }

    public FileDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDeleteException(Throwable cause) {
        super(cause);
    }
}