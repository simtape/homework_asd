package it.unimol.project.gui.recipe.newRecipe;

import it.unimol.project.app.recipe.Recipe;
import it.unimol.project.app.recipe.RecipeHandler;
import it.unimol.project.app.recipe.TimeNotValidException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;


/**
 * Frame utilizzabile per
 * inserire una nuova ricetta alla lista di ricette {@link RecipeHandler}
 */

public class NewRecipeFrame extends JFrame {

    private JPanel jPanel;

    private final JLabel titleLabel = new JLabel("Titolo");
    private final JLabel ingredientsLabel = new JLabel("Ingredienti");
    private final JLabel preparationLabel = new JLabel("Preparazione");
    private final JLabel timeLabel = new JLabel("Tempo");

    private JTextField titleField;
    private JTextField ingredientsField;
    private JTextField preparationField;
    private JTextField timeField;

    private JButton saveButton;


    public NewRecipeFrame() {
        this.setTitle("Aggiunta");
        this.setSize(600, 600);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        this.jPanel = new JPanel();
        this.jPanel.setLayout(new GridLayout(5, 2));
        this.jPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.jPanel);

        Border padding = BorderFactory.createEmptyBorder(50, 25, 50, 25);
        this.jPanel.setBorder(padding);


        this.jPanel.add(this.titleLabel);
        this.titleField = new JTextField();
        titleField.setColumns(50);
        this.jPanel.add(this.titleField);


        this.jPanel.add(this.ingredientsLabel);
        this.ingredientsField = new JTextField();
        ingredientsField.setColumns(50);
        this.jPanel.add(this.ingredientsField);


        this.jPanel.add(this.preparationLabel);
        this.preparationField = new JTextField();
        preparationField.setColumns(50);
        this.jPanel.add(this.preparationField);


        this.jPanel.add(this.timeLabel);
        this.timeField = new JTextField();
        timeField.setColumns(50);
        this.jPanel.add(this.timeField);


        this.saveButton = new JButton("Salva");
        addSaveButtonActionListener();
        this.jPanel.add(this.saveButton);

    }


    private void addSaveButtonActionListener() {
        this.saveButton.addActionListener(event -> {
            Recipe recipe = new Recipe();

            recipe.setTitle(this.titleField.getText());
            recipe.setIngredients(this.ingredientsField.getText());
            recipe.setInstructions(this.preparationField.getText());

            try {
                recipe.setSeconds(Integer.parseInt(this.timeField.getText()));

                try {
                    RecipeHandler.getInstance().addNewRecipe(recipe);
                    JOptionPane.showMessageDialog(this, "Ricetta salvata correttamente.");
                    this.dispose();

                } catch (IOException e) {
                    e.getMessage();

                }

            } catch (TimeNotValidException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        });

    }
}
