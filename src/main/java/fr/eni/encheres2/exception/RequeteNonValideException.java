package fr.eni.encheres2.exception;

public class RequeteNonValideException extends RuntimeException {

    public RequeteNonValideException() {

    }

    public RequeteNonValideException(String message) {
        super(message);
    }

}
