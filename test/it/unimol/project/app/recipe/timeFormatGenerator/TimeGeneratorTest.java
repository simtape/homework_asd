package it.unimol.project.app.recipe.timeFormatGenerator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeGeneratorTest {

    @BeforeAll
    static void before() {
        System.out.println("Before all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @AfterAll
    static void after() {
        System.out.println("Test ended");
    }


    @Test
    void testSecondsInMinutes() {
        String formattedTime = TimeGenerator.getInstance().getTimeFormat(61);
        assertEquals("1 minuto, 1 secondo", formattedTime);

    }


    @Test
    void testSecondsAndMinutes() {
        String formattedTime = TimeGenerator.getInstance().getTimeFormat(121);
        assertEquals("2 minuti, 1 secondo", formattedTime);
    }


    @Test
    void oneSecondTest() {
        String formattedTime = TimeGenerator.getInstance().getTimeFormat(1);
        assertEquals("1 secondo", formattedTime);
    }


    @Test
    void secondsTest() {
        String time = "59 secondo";
        String formattedTime = TimeGenerator.getInstance().getTimeFormat(59);
        assertFalse(time.equalsIgnoreCase(formattedTime));

    }


}