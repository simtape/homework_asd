package it.unimol.project.gui.recipe.viewRecipes;

import it.unimol.project.app.recipe.Recipe;
import it.unimol.project.app.recipe.timeFormatGenerator.TimeGenerator;
import it.unimol.project.app.recipe.threadTimer.TimerRecipe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


/**
 * Frame utilizzato per mostrare una ricetta nel dettaglio.
 * Tramite l'actionListener del JButton {@link #starTimerButton}
 * specificato nel metodo {@link #startTimerButtonListener(Recipe)}
 * viene creato un Timer della durata pari al tempo di preparazione della ricetta specificata.
 */

public class DetailsRecipeFrame extends JFrame {
    private JPanel jPanel;

    private JLabel titleLabel;
    private JLabel ingredientsLabel;
    private JLabel preparationLabel;
    private JLabel timeLabel;

    private final JButton starTimerButton = new JButton("Avvia timer");

    public DetailsRecipeFrame(Recipe recipe) {
        this.setTitle("Dettagli");
        this.setSize(600, 600);

        this.jPanel = new JPanel();
        this.jPanel.setSize(600, 600);
        this.jPanel.setLayout(new GridLayout(5, 1));
        Border padding = BorderFactory.createEmptyBorder(10, 50, 10, 50);
        this.jPanel.setBorder(padding);
        this.add(this.jPanel);


        String recipeTitle = recipe.getTitle();
        titleLabel = new JLabel("Titolo: " + recipeTitle);
        this.jPanel.add(titleLabel);


        String recipeIngredients = recipe.getIngredients();
        ingredientsLabel = new JLabel("Ingredienti: " + recipeIngredients);
        this.jPanel.add(ingredientsLabel);


        String recipePreparation = recipe.getInstructions();
        preparationLabel = new JLabel("Preparazione: " + recipePreparation);
        this.jPanel.add(preparationLabel);


        String time = TimeGenerator.getInstance().getTimeFormat(recipe.getSeconds());
        timeLabel = new JLabel("Tempo (" + time + ")");
        this.jPanel.add(timeLabel);


        startTimerButtonListener(recipe);

        this.jPanel.add(this.starTimerButton);


        this.setVisible(true);
    }


    private void startTimerButtonListener(Recipe recipe) {
        this.starTimerButton.addActionListener(event -> {

            JOptionPane.showMessageDialog(null, "Timer avviato");
            this.dispose();

            assert recipe.getTitle() != null;

            String titleRecipe = recipe.getTitle();
            int millisecondsTimeRecipe = recipe.getMilliSeconds();

            TimerRecipe timerRecipe = new TimerRecipe(millisecondsTimeRecipe, titleRecipe);
            Thread thread = new Thread(timerRecipe);
            thread.start();

        });
    }
}

