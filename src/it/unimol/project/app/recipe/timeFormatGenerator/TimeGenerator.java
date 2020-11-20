package it.unimol.project.app.recipe.timeFormatGenerator;


/**
 * Singleton che permette di specificare una quantità
 * espressa in secondi nel formato: "ore, minuti, secondi"
 * <p>
 * Per implementare il singleton chiamare
 * il metodo {@link #getTimeFormat(int)}.
 * <p>
 * Esempio: {@code #TimeGenerator.getInstance.getTimeFormat(int seconds)}.
 */

public class TimeGenerator {
    private static TimeGenerator instance = new TimeGenerator();
    private int seconds;
    private int minutes;
    private int hours;

    public static TimeGenerator getInstance() {

        return instance;
    }


    private TimeGenerator() {

    }


    private void setSeconds(int seconds) {
        this.seconds = seconds;

    }


    private void splitTime() {

        //assert seconds > 0;

        this.minutes = this.seconds / 60;
        this.seconds = this.seconds % 60;

        if (this.minutes >= 60) {
            this.hours = this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    private String secondsToString() {
        if (seconds != 1)
            return seconds + " secondi";

        return seconds + " secondo";
    }


    private String minutesToString() {
        if (minutes != 1)
            return minutes + " minuti";

        return minutes + " minuto";
    }


    private String hoursToString() {
        if (hours != 1)
            return hours + " ore";

        return hours + " ora";
    }


    private String getTypeFormat() {
        if (minutes == 0 && hours == 0)
            return secondsToString();

        if (seconds == 0 && hours == 0)
            return minutesToString();

        if (seconds == 0 && minutes == 0)
            return hoursToString();

        if (hours == 0)
            return minutesToString() + ", " + secondsToString();

        if (seconds == 0)
            return hoursToString() + ", " + minutesToString();

        if (minutes == 0)
            return hoursToString() + ", " + secondsToString();

        return hoursToString() + ", "
                + minutesToString() + ", "
                + secondsToString();

    }

    /**
     * Il metodo imposta prima i secondi {@link #setSeconds(int)}, poi li divide nel formato ore, minuti, secondi{@link #splitTime()}
     * e come valore di ritorno restituisce una stringa del tipo(X ore, Y minuti, O secondi)
     *
     * @param secondsInput: quantità di tempo espressa in secondi da trasformare nel formato ora/e, minuto/i, secondo/i.
     * @return Restituisce il formato del tempo come stringa.
     **/
    public String getTimeFormat(int secondsInput) {

        setSeconds(secondsInput);
        splitTime();
        String formattedTime = getTypeFormat();

        return formattedTime;
    }
}
