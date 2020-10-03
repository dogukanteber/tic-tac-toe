import javax.swing.*;
import java.awt.*;

public class Window {

    JFrame frame;

    public Window() {
        frame = new JFrame();
        initFrame();
    }

    private void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe Game");
        frame.setPreferredSize( new Dimension(800,700) );
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLayout( new BorderLayout() );
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
