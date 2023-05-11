public class Control
{   private GUI gui;
    private Player player;
    private Boolean isPlaying;

    public Control()
    {   init();
    }

    private void init()
    {   gui = new GUI(this);
        player = new Player(this, gui.getGWindow());
        gui.gameWindow();
        isPlaying = true;

    }

    private void update()
    {   //things to do/check per cyclus
        //input handling

        while(isPlaying)
        {   //TODO Collision-Detection

        }
    }

    public void walkRight()
    {   gui.setFrame("/Sprites/Male_walk.gif");

    }

    public void standStill()
    {   gui.setFrame("/Sprites/Male_idle.gif");

    }


    public static void main(String[] args)
    {   Control c = new Control();
        c.update();

    }

}