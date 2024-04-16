package fr.eni.encheres2.exception;

public class CategorieNotFoundException extends RuntimeException {

    public CategorieNotFoundException() {
    }

    public CategorieNotFoundException(String message) {
        super(message);
    }

}
