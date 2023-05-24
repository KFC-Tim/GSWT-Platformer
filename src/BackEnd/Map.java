import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JPanel;


public class Map extends JPanel
{   private Tile tileMap[][];
    private BufferedImage tiles[];

    public Map(int h, int w, Dimension d)
    {   super();
        super.setBounds(100, 100, 500, 500);

        tileMap = new Tile[h][w];
    }

    public void addTile(int x, int y, BufferedImage buffImg, boolean hitbox)
    {   tileMap[x][y] = new Tile(x, y, buffImg, hitbox);
    }

    public Tile getTile(int x, int y)
    {   return tileMap[x][y];
    }

    public int getHeight()
    {   return tileMap[0].length;
    }
    
    public int getWidth()
    {   return tileMap.length;

    }

    public void loadMap() throws IOException
    {   Set<String> files;
        
        try 
        {   files = listFiles("./Starter Tiles Platformer/DarkCastleTiles", 1);
        } 
        catch (IOException e) 
        {   // TODO Auto-generated catch block
            files = null;
            e.printStackTrace();
        }

        tiles = new BufferedImage[files.size()];

        Iterator<String> filesIterator = files.iterator();

        int i=0;
        while(filesIterator.hasNext())
        {   tiles[i] = Sprite.toBuff("./Starter Tiles Platformer/DarkCastleTiles/"+filesIterator.next());
            ++i;
        }


        tileMap[0][0] = new Tile(0, 21, tiles[0], true);
        tileMap[1][0] = new Tile(1, 21, tiles[1], true);
        tileMap[2][0] = new Tile(2, 21, tiles[2], true);
        tileMap[3][0] = new Tile(3, 21, tiles[3], true);
        tileMap[4][0] = new Tile(4, 21, tiles[4], true);
        tileMap[5][0] = new Tile(5, 21, tiles[5], true);
    }


    public Set<String> listFiles(String dir, int depth) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
            return stream
              .filter(file -> !Files.isDirectory(file))
              .map(Path::getFileName)
              .map(Path::toString)
              .collect(Collectors.toSet());
        }
    }


    @Override
    public void paintComponent(Graphics g)
    {   super.paintComponent(g);
        super.setSize(500, 500);
        Graphics2D g2 = (Graphics2D) g;

        g2.setClip(0, 0, 1800, 1000);

        
        for(int i=0; i<tileMap.length; ++i)
        {   for(int j=0; j<tileMap[0].length; ++j)
            {   if(tileMap[i][j] != null)
                {   Tile nowTile = tileMap[i][j];
                    Rectangle2D r2 = new Rectangle2D.Float(nowTile.getX()*32, nowTile.getY()*32, 32, 32);
                    TexturePaint t = new TexturePaint(nowTile.getTexture(), r2);

                    g2.setPaint(t);
                    g2.fill(r2);
                }
            }
        }
    }
}