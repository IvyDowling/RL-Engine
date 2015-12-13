package rlengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    private static Controller controller;

    public Listener() {
        controller = Controller.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.takeInput(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
