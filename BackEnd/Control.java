public class Control
{   private GUI gui;
    private Boolean isPlaying;

    public Control()
    {   init();
    }

    private init()
    {   gui = new GUI(this);
        gui.gameWindow();
        isPlaying = true;

    }

    private update()
    {   //things to do/check per cyclus
        //input handling

        while(isPlaying)
        {   //TODO Collision-Detection

        }
    }


    public static void main(String[] args)
    {   Control c = new Control;
        c.update();

    }

}