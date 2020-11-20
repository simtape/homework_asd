package it.unimol.project.gui.menu;

import it.unimol.project.app.recipe.RecipeHandler;
import it.unimol.project.gui.recipe.viewRecipes.ListRecipesFrame;
import it.unimol.project.gui.recipe.newRecipe.NewRecipeFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;


/**
 * Singleton che estende la classe JFrame per la creazione di un Frame con menu.
 * Per creare il Frame, chiamare il metodo {@link #createFrame()}.
 */

public class MenuFrame extends JFrame {

    private JPanel jPanel;
    private final JButton addRecipeButton = new JButton("Nuova ricetta");;
    private final JButton viewRecipesButton = new JButton("Visualizza ricette");;

    private static MenuFrame instance = new MenuFrame();

    public static MenuFrame getInstance() {
        return instance;
    }

    private MenuFrame() {


    }


    /**
     * Crea il frame;
     * <p>
     * aggiunge al frame i due JButton {@link #addRecipeButton} {@link #viewRecipesButton};
     * <p>
     * Aggiugne ai relativi JButton gli eventi
     * che accadranno dopo il click su uno dei due JButton {@link #addActionListeners()}
     */

    public void createFrame() {
        this.setTitle("Menu");
        this.setSize(600, 600);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.jPanel = new JPanel();
        this.jPanel.setSize(300, 300);
        this.jPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.jPanel.setLayout(new FlowLayout());
        this.add(this.jPanel);
        Border padding = BorderFactory.createEmptyBorder(100, 10, 10, 10);
        this.jPanel.setBorder(padding);


        this.addRecipeButton.setAlignmentX(CENTER_ALIGNMENT);
        this.jPanel.add(this.addRecipeButton);


        this.viewRecipesButton.setAlignmentX(CENTER_ALIGNMENT);
        this.jPanel.add(this.viewRecipesButton);

        addActionListeners();
        loadFile();

        this.setVisible(true);

    }


    private void addActionListeners() {
        this.addRecipeButton.addActionListener(event -> {

            NewRecipeFrame addRecipeFrame = new NewRecipeFrame();
            addRecipeFrame.setVisible(true);
        });


        this.viewRecipesButton.addActionListener(event -> {

            ListRecipesFrame viewRecipesFrame = new ListRecipesFrame();
            viewRecipesFrame.setVisible(true);

        });
    }


    private void loadFile() {
        try {
            RecipeHandler.getInstance().loadRecipes();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
}
