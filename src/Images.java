package src;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Images {
    public static BufferedImage load_image(final String filename, final Dimension dimension) {
        BufferedImage buffered_image = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = buffered_image.createGraphics();

        try {
            graphics.drawImage(ImageIO.read(new File(filename)), 0, 0, dimension.width, dimension.height, null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return buffered_image;
    }
}
