package it.unimol.project.app.recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeHandlerTest {

    @Test
    void checkEmptyListException() {
        try {
            RecipeHandler.getInstance().checkListIsNotEmpty();
            fail();

        } catch (EmptyListException e) {

        }

    }

}