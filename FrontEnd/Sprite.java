import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;

public class Sprite {
    private BufferedImage[] spritesheet;

    public Sprite(int size)
    {   spritesheet = new BufferedImage[size];
    }

    public void addSprite(int index, BufferedImage b)
    {   spritesheet[index] = b;
    }

    public BufferedImage getSprite(int index)
    {   return spritesheet[index];
    }


    public static BufferedImage toBuff(String filename) throws IOException
    {   BufferedImage i = ImageIO.read(new File(filename));
        return i;

    }
}
