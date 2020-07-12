package ru.geekbrains.lesson02;

public class IncorrectMethodArgumentException extends RuntimeException {

    public IncorrectMethodArgumentException() {
        super();
    }

    public IncorrectMethodArgumentException(String message) {
        super(message);
    }

    public IncorrectMethodArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectMethodArgumentException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = -4567546332423068232L;
}
