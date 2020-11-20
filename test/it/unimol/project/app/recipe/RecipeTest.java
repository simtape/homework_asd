package it.unimol.project.app.recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void checkTimeException() {
        Recipe recipe = new Recipe();

        try {
            recipe.setSeconds(-1);
            fail();
        } catch (TimeNotValidException e) {

        }
    }

}