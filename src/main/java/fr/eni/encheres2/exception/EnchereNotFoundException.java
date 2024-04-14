package fr.eni.encheres2.exception;

public class EnchereNotFoundException extends RuntimeException {

    public EnchereNotFoundException() {
    }

    public EnchereNotFoundException(String message) {
        super(message);
    }

}