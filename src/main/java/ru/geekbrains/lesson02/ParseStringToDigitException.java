package ru.geekbrains.lesson02;

public class ParseStringToDigitException extends RuntimeException {

    public ParseStringToDigitException() {
        super();
    }

    public ParseStringToDigitException(String message) {
        super(message);
    }

    public ParseStringToDigitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseStringToDigitException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = -4758487328597979854L;
}
