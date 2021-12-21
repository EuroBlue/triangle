import javax.swing.*;
import java.awt.*;

public class Window {
    private static final double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double heigth=Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private final JFrame frame;
    Window()
    {
        System.out.println(heigth);
        frame = new JFrame("Draw Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        Triangle panel = new Triangle(this,7);
        frame.add(panel);
        frame.setVisible(true);
    }
    public static double getWidth()
    {
        return width;
    }
    public static double getHeigth()
    {
        return heigth;
    }
    public JFrame getFrame()
    {
        return frame;
    }

}
