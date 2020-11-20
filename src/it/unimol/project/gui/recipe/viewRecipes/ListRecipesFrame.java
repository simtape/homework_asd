package it.unimol.project.gui.recipe.viewRecipes;

import it.unimol.project.app.recipe.EmptyListException;
import it.unimol.project.app.recipe.Recipe;
import it.unimol.project.app.recipe.RecipeHandler;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Frame utilizzabile per
 * visualizzare la lista di ricette contenuta nel singleton {@link RecipeHandler}
 */

public class ListRecipesFrame extends JFrame {
    private final JLabel description = new JLabel(" Clicca su un elemento per vedere la ricetta");

    private JList jlist;
    private JPanel jPanel;
    private String[] titles;

    public ListRecipesFrame() {
        this.setTitle("Lista");
        this.setSize(600, 600);
        this.jPanel = new JPanel();
        this.jPanel.setLayout(new GridLayout(2, 1));
        Border padding = BorderFactory.createEmptyBorder(10, 50, 10, 50);
        this.jPanel.setBorder(padding);


        this.titles = RecipeHandler.getInstance().titleRecipesToString();


        this.jlist = new JList();
        jlist.setModel(new AbstractListModel() {

            @Override
            public int getSize() {
                return titles.length;
            }

            @Override
            public Object getElementAt(int index) {
                return titles[index];
            }
        });
        addListListener();


        this.jPanel.add(this.description);
        this.jPanel.add(this.jlist);
        this.add(this.jPanel);

        checkRecipesListIsNotEmpty();

    }


    private void checkRecipesListIsNotEmpty() {
        try {
            RecipeHandler.getInstance().checkListIsNotEmpty();

        } catch (EmptyListException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }


    private void addListListener(){
        this.jlist.addListSelectionListener(event -> {

            int indexSelectedRecipe = jlist.getSelectedIndex();
            Recipe recipe = RecipeHandler.getInstance().findRecipeByIndex(indexSelectedRecipe);

            if (event.getValueIsAdjusting()) {
                DetailsRecipeFrame detailsRecipeFrame = new DetailsRecipeFrame(recipe);
            }
        });

    }

}
