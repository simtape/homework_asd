package it.unimol.project.app.recipe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Singleton per gestire le istanze della classe {@link Recipe}
 * Il singleton può caricare le ricette salvate su un file nella sua lista {@link #loadRecipes()},
 * può salvare la lista completa delle ricette su file {@link #saveRecipes()},
 * restituire i titoli delle ricette {@link #titleRecipesToString()},
 * trovare una ricetta specifica {@link #findRecipeByIndex(int)}.
 */

public class RecipeHandler {
    private static RecipeHandler instance = new RecipeHandler();

    private static final String NOME_FILE = "ricette.txt";
    private List<Recipe> recipesList = new ArrayList<>();

    private final String messageToThrow = "Non è presente nessuna ricetta da visualizzare. ";

    public static RecipeHandler getInstance() {
        return instance;
    }

    private RecipeHandler() {
    }


    private void saveRecipes() throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(RecipeHandler.NOME_FILE);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(this.recipesList);
        }
    }


    /**
     * Carica nella lista {@link #recipesList}, le ricette presenti nel file.
     *
     * @throws IOException se ci sono problemi nell'apertura del file.
     */

    public void loadRecipes() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream(RecipeHandler.NOME_FILE);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object object = objectInputStream.readObject();
            assert object instanceof List;

            RecipeHandler.getInstance().setRecipesList((List) object);

        } catch (ClassNotFoundException e) {
            assert false : e.getMessage();

        }
    }

    private void setRecipesList(List<Recipe> recipesList) {
        this.recipesList = recipesList;
    }


    /**
     * Aggiunge una nuova ricetta nella lista;
     * Salva su file la lista aggiornata {@link #saveRecipes()}.
     *
     * @param recipe: Ricetta da aggiungere alla lista {@link #recipesList}
     * @throws IOException : Eccezione lanciata dal metodo {@link #saveRecipes()}
     */

    public void addNewRecipe(Recipe recipe) throws IOException {
        this.recipesList.add(recipe);
        saveRecipes();
    }


    /**
     * Metodo che crea un Array di stringhe dei titoli presenti nelle ricette.
     * <p>
     * Esempio: {@code this.titles = RecipeHandler.getInstance().titleRecipesToString();};
     *
     * @return Un array di stringhe, contenente i titoli delle ricette.
     */

    public String[] titleRecipesToString() {

        assert recipesList != null;

        int sizeList = this.recipesList.size();
        String[] titles = new String[sizeList];

        for (int i = 0; i < this.recipesList.size(); i++) {
            titles[i] = "Ricetta " + (i + 1) + ": " + recipesList.get(i).getTitle();
        }

        return titles;
    }


    /**
     * Trova una ricetta all'interno della lista delle ricette {@link #recipesList} tramite la posizione;
     *
     * @param index: posizione della ricetta all'interno della lista di ricette;
     * @return restituisce la ricetta presente nella lista in quella posizione;
     * Esempio: {@code Recipe recipe = RecipeHandler.getInstance().findRecipeByIndex(indexSelectedRecipe);}
     */

    public Recipe findRecipeByIndex(int index) {
        assert index >= 0;
        assert recipesList != null;

        Recipe recipe = recipesList.get(index);
        return recipe;
    }


    public void checkListIsNotEmpty() throws EmptyListException {
        if (this.recipesList.size() == 0)
            throw new EmptyListException(messageToThrow);
    }
}



