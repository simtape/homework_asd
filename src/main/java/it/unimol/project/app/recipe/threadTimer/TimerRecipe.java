package it.unimol.project.app.recipe.threadTimer;

import it.unimol.project.app.recipe.timeFormatGenerator.TimeGenerator;

import javax.swing.*;


/**
 *
 * Classe che realizza un Timer tramite l'implementazione dell'interfaccia {@link Runnable}.
 * Il codice della realizzazione del timer è specificato nel metodo {@link #run()}
 *
 */

public class TimerRecipe implements Runnable {
    private int milliseconds;
    private String titleRecipe;


    public TimerRecipe(int milliSeconds, String titleRecipe) {
        this.milliseconds = milliSeconds;
        this.titleRecipe = titleRecipe;
    }



    /**
     *
     * Mette in pausa il thread per un tempo totale pari a {@link #milliseconds}
     * <p>
     * Gestisce l'eccezione InterruptedException in caso si verifichi
     * <p>
     * Finito il tempo di pausa del Thread mostra una finestra di dialogo
     * contenente il tempo di preparazione della ricetta e il titolo
     *
     */

    @Override
    public void run() {
        try {

            assert milliseconds > 0;
            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

        }

        int secondsRecipe = milliseconds / 1000;
        String time = TimeGenerator.getInstance().getTimeFormat(secondsRecipe);

        JOptionPane.showMessageDialog(null,
                "Il tempo per la preparazione della ricetta " +
                        this.titleRecipe +
                        "(" + time + ") " +
                        " e' terminato. ");
    }
}
