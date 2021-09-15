package src;

public class SceneManager {
    private SceneManager() {
        current_scene = new SceneMain();

        System.out.println("OK SceneManager().");
    }

    public static SceneManager new_scene_manager() {
        if(instance == null)
            instance = new SceneManager();

        return instance;
    }

    public void switch_scene() {
        current_scene = next_scene;
    }

    public boolean contains_scene() {
        return current_scene != null;
    }

    public void set_next_scene(final Scene scene_next) {
        this.next_scene = scene_next;
    }

    public static SceneManager get_instance() {
        return instance;
    }

    public Scene get_current_scene() {
        return current_scene;
    }

    private static SceneManager instance;
    private Scene current_scene;
    private Scene next_scene;
}
