package src;

import java.awt.Dimension;

public class Main {
    public Main() {
        Game.new_game("Test Game", new Dimension(720, 480), "assets/images/icon.png", 60);
        Game.get_instance().run();
    }

    public static void main(String args[]) {
        new Main();
    }
}
