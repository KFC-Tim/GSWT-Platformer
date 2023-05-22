import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Map
{   private Tile tileMap[][];
    private BufferedImage tiles[];

    public Map(int h, int w)
    {   tileMap = new Tile[h][w];
    }

    public void addTile(int x, int y, BufferedImage buffImg)
    {   tileMap[x][y] = new Tile(x*16, y*16, buffImg);
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


        tileMap[0][0] = new Tile(0, 5, tiles[0]);
        tileMap[1][0] = new Tile(2, 5, tiles[1]);
        tileMap[2][0] = new Tile(3, 5, tiles[2]);
        tileMap[3][0] = new Tile(4, 5, tiles[3]);
        tileMap[4][0] = new Tile(5, 5, tiles[4]);
        tileMap[5][0] = new Tile(6, 5, tiles[5]);
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
    
}