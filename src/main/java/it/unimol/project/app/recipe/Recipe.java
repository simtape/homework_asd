package it.unimol.project.app.recipe;

import java.io.Serializable;

/**
 * Classe per la creazione di una nuova ricetta.
 * <p>
 * Implementa l'interfaccia Serializable
 * per permettere la possibilità di salvare un oggetto
 * di tipo Recipe su un file.
 */

public class Recipe implements Serializable {
    private String title;
    private String ingredients;
    private String instructions;

    private final String messageToThrow = "Impossibile inserire una quantità di tempo inferiore o uguale a 0 secondi.";

    private int seconds;

    public void setTitle(String title) {
        this.title = title;

    }


    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;

    }


    public void setInstructions(String instructions) {
        this.instructions = instructions;

    }


    public void setSeconds(int seconds) throws TimeNotValidException {
        if (seconds <= 0)
            throw new TimeNotValidException(messageToThrow);

        this.seconds = seconds;
    }


    public String getTitle() {
        return title;

    }

    public String getIngredients() {
        return ingredients;

    }

    public String getInstructions() {
        return instructions;

    }

    public int getSeconds() {
        return seconds;

    }

    public int getMilliSeconds() {
        return seconds * 1000;

    }


}
