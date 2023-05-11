import javax.swing.JFrame;

public class GUI
{   private Control ctrl;
    private JFrame gWindow;

    public GUI(Control c)
    {   ctrl = c;
    }

    public void gameWindow()
    {   gWindow = new JFrame();
        gWindow.setSize(600, 1200);

        gWindow.setVisible(true);

    }
}