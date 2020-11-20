package it.unimol.project.app.recipe;


/**
 * Eccezione da lanciare nel caso viene inserito un tempo non valido.
 * <p>
 * Esempio di utilizzo: {@code if (seconds <= 0)
 * throw new TimeNotValidException();}
 */

public class TimeNotValidException extends Exception {

    public TimeNotValidException(String message) {
        super(message);
    }

}
