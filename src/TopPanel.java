import javax.swing.*;
import java.awt.*;

public class TopPanel {

    JPanel topPanel;
    JLabel title;

    public TopPanel() {
        topPanel  = new JPanel();
        title = new JLabel();
        initPanel();
        initTitle();
    }

    private void initPanel() {
        topPanel.setLayout( new BorderLayout() );
        topPanel.setBounds(0,0,800,800);
        topPanel.add(title);
    }

    private void initTitle() {
        title.setBackground( new Color(25,25,25) );
        title.setForeground( new Color(25,255,0) );
        title.setFont( new Font("Ink Free", Font.BOLD,75) );
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("Tic Tac Toe");
        title.setOpaque(true);
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }
}
