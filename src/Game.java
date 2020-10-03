import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game {

    Window window;
    TopPanel topPanel;
    GamePanel gamePanel;

    JFrame frame;

    Random random = new Random();
    private boolean player1_turn;

    private boolean isGameOver;

    public Game() {
        window = new Window();
        topPanel = new TopPanel();
        gamePanel = new GamePanel(this);
        frame = window.getFrame();
        player1_turn = true;
        isGameOver = false;
        addPanels();
        firstTurn();
    }


    private void addPanels() {
        frame.add(topPanel.getTopPanel(),BorderLayout.NORTH);
        frame.add(gamePanel.getGamePanel());
    }


    private void firstTurn() {
        if ( random.nextInt(2) == 0 ) {
            player1_turn = true;
            topPanel.setTitle( new JLabel("X turn") );
        }
        else {
            player1_turn = false;
            topPanel.setTitle( new JLabel("O turn") );
        }
    }

    public Window getWindow() {
        return window;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isPlayer1_turn() {
        return player1_turn;
    }
}
