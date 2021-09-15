package src;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class SceneMain extends Scene {
    public SceneMain() {
        super();

        x = y = 0;
        buffered_image = Images.load_image("assets/images/icon.png", new Dimension(128, 128));
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void handle_events() {
        if(Keyboard.get_instance().SPACE)
            set_pause(!is_paused());
    }

    @Override
    public void update() {
        Keyboard.get_instance().update();

        if(Keyboard.get_instance().A)
            x -= 6;

        if(Keyboard.get_instance().D)
            x += 6;

        if(Keyboard.get_instance().S)
            y += 6;

        if(Keyboard.get_instance().W)
            y -= 6;
    }

    @Override
    public void render() {
        Graphics2D graphics = (Graphics2D) Window.get_instance().get_buffer_strategy().getDrawGraphics();

        graphics.clearRect(0, 0, Window.get_instance().get_dimension().width, Window.get_instance().get_dimension().height);

        // -------------- BEGIN RENDER -------------- //

        graphics.drawImage(buffered_image, x, y, null);

        // -------------- END RENDER -------------- //

        graphics.dispose();
        Window.get_instance().get_buffer_strategy().show();
    }

    BufferedImage buffered_image;
    int x;
    int y;
}
