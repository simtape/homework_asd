package it.unimol.project.app.recipe;


/**
 * Eccezione da lanciare quando è necessario che una lista non sia vuota.
 * <p>
 * Esempio di utilizzo: {@code if(this.recipesList.size() == 0)
 * throw new EmptyListException();}
 */

public class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}
