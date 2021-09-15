package src;

public class LoopTimer {
    private LoopTimer(int fps) {
        this.fps = fps;
        delta_time = nanoseconds / fps;
        time_current = System.nanoTime();

        System.out.println("OK LoopTimer().");
    }

    public void update() {
        final long new_time = System.nanoTime();
        final long frame_time = new_time - time_current;
        time_current = new_time;
        accumulator += frame_time;
    }

    public void reset() {
        accumulator -= delta_time;
        time += delta_time;
    }

    public static LoopTimer new_loop_timer(final int fps) {
        if(instance == null)
            instance = new LoopTimer(fps);

        return instance;
    }

    public void set_fps(final int fps) {
        this.fps = fps;
        delta_time = nanoseconds / fps;
    }
    
    public boolean is_ready() {
        return accumulator >= delta_time;
     }

    public static LoopTimer get_instance() {
        return instance;
    }

    public int get_fps() {
        return fps;
    }

    public long get_delta_time() {
        return delta_time;
    };

    private static LoopTimer instance;
    final long nanoseconds = 1000000000;
    int fps;
    long delta_time;
    long time;
    long time_current;
    long accumulator;
}
