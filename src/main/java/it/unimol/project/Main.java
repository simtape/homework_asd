package it.unimol.project;

import it.unimol.project.gui.menu.MenuFrame;


public class Main {
    public static void main(String args[]) {
        System.setProperty("java.awt.headless", "false");
        MenuFrame.getInstance().createFrame();
    }
}
