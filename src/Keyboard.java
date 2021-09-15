package src;

import java.awt.event.*;

public class Keyboard implements KeyListener {
    private Keyboard() {
        Keys = new boolean[256];
        A = false;
        D = false;
        S = false;
        W = false;
        LEFT = false;
        RIGHT = false;
        DOWN = false;
        UP = false;
        SPACE = false;
    }

    public static Keyboard new_keyboard() {
        if(instance == null)
            instance = new Keyboard();

        return instance;
    }

    public void update() {
        A = Keys[KeyEvent.VK_A];
        D = Keys[KeyEvent.VK_D];
        S = Keys[KeyEvent.VK_S];
        W = Keys[KeyEvent.VK_W];
        LEFT = Keys[KeyEvent.VK_LEFT];
        RIGHT = Keys[KeyEvent.VK_RIGHT];
        DOWN = Keys[KeyEvent.VK_DOWN];
        UP = Keys[KeyEvent.VK_UP];
        SPACE = Keys[KeyEvent.VK_SPACE];
    }

    public static Keyboard get_instance() {
        return instance;
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        Keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        Keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(final KeyEvent e) {}

    private static Keyboard instance;
    private static boolean Keys[];

    public boolean A;
    public boolean D;
    public boolean S;
    public boolean W;
    public boolean LEFT;
    public boolean RIGHT;
    public boolean DOWN;
    public boolean UP;
    public boolean SPACE;
}
