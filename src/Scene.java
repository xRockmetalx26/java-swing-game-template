package src;

public abstract class Scene {
    public Scene() {
        running = true;
        pause = false;

        System.out.println("OK Scene().");
    }

    public abstract void init();
    public abstract void handle_events();
    public abstract void update();
    public abstract void render();

    public void set_running(final boolean running) {
        this.running = running;
    }

    public void set_pause(final boolean pause) {
        this.pause = pause;
    }

    public boolean is_running() {
        return running;
    }

    public boolean is_paused() {
        return pause;
    }

    protected boolean running;
    protected boolean pause;
}
