package src;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {
    private Window(final String title, final Dimension dimension, final String icon) {
        super(title);

        this.dimension = dimension;

        init_frame(icon);
        init_canvas();
        init_nimbus();

        System.out.println("OK Window().");
    }

    public static Window new_window(final String title, final Dimension dimension, final String icon) {
        if(instance == null)
            instance = new Window(title, dimension, icon);

        return instance;
    }

    private void init_nimbus() {
        try {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
        }
        catch(Exception e) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }

    private void init_frame(final String icon) {
        setSize(dimension.width + 16, dimension.height + 39);
        setIconImage(Images.load_image(icon, new Dimension(128, 128)));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void init_canvas() {
        canvas = new Canvas();
        canvas.setBounds(0, 0, dimension.width, dimension.height);
        canvas.setFocusable(true);
        canvas.requestFocus();
        canvas.setBackground(Color.BLACK);

        add(canvas);
        pack();

        canvas.createBufferStrategy(2);
        buffer_strategy = canvas.getBufferStrategy();
    }

    public static Window get_instance() {
        return instance;
    }

    public Canvas get_canvas() {
        return canvas;
    }

    public BufferStrategy get_buffer_strategy() {
        return buffer_strategy;
    }

    public Dimension get_dimension() {
        return dimension;
    }

    private static Window instance;
    private Canvas canvas;
    private BufferStrategy buffer_strategy;
    private Dimension dimension;
}