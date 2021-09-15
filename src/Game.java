package src;
import java.awt.*;

public class Game {
    private Game(final String title, final Dimension dimension, final String icon, final int fps) {
        Window.new_window(title, dimension, icon);
        SceneManager.new_scene_manager();
        LoopTimer.new_loop_timer(60);

        Window.get_instance().get_canvas().addKeyListener(Keyboard.new_keyboard());
        Window.get_instance().setVisible(true);

        System.out.println("OK Game().");
    }

    public void run() {
        while(SceneManager.get_instance().contains_scene()) {
            Scene scene_current = SceneManager.get_instance().get_current_scene();
            scene_current.init();

            while(scene_current.is_running()) {
                scene_current.handle_events();
                LoopTimer.get_instance().update();

                while(LoopTimer.get_instance().is_ready()) {
                    if(!scene_current.is_paused())
                        scene_current.update();

                    LoopTimer.get_instance().reset();
                    scene_current.render();
                }
            }

            SceneManager.get_instance().switch_scene();
        }
    }

    public static  Game new_game(final String title, final Dimension dimension, final String icon, final int fps) {
        if(instance == null)
            instance = new Game(title, dimension, icon, fps);

        return instance;
    }

    public static Game get_instance() {
        return instance;
    }

    private static Game instance;
}
