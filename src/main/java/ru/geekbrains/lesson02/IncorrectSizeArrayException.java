package ru.geekbrains.lesson02;

public class IncorrectSizeArrayException extends RuntimeException {

    public IncorrectSizeArrayException() {
        super();
    }

    public IncorrectSizeArrayException(String message) {
        super(message);
    }

    public IncorrectSizeArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectSizeArrayException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = -6778967945346277532L;
}
