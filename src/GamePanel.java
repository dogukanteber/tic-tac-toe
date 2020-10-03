import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel implements ActionListener {

    public static final int BUTTON_NUMBER = 9;

    Game game;
    JFrame frame;
    JPanel gamePanel;
    JButton[] buttons;
    JLabel title;

    boolean player1Turn;
    boolean isGameOver;
    boolean xWins = false;
    boolean oWins = false;

    public GamePanel( Game game ) {
        this.game = game;
        frame = game.getWindow().getFrame();
        gamePanel = new JPanel();
        buttons = new JButton[BUTTON_NUMBER];
        player1Turn = game.isPlayer1_turn();
        isGameOver = game.isGameOver();
        title = game.topPanel.getTitle();
        initPanel();
    }

    private void initPanel() {
        gamePanel.setLayout( new GridLayout(3,3) );

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            gamePanel.add(buttons[i]);
            buttons[i].setFont( new Font("MV Boli", Font.BOLD,120) );
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
    }


    private void check() {
        // x wins conditions
        if (    buttons[0].getText().equals("X") &&
                buttons[1].getText().equals("X") &&
                buttons[2].getText().equals("X") )
            xWins(0,1,2);
        if (    buttons[3].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[5].getText().equals("X") )
            xWins(3,4,5);
        if (    buttons[6].getText().equals("X") &&
                buttons[7].getText().equals("X") &&
                buttons[8].getText().equals("X") )
            xWins(6,7,8);
        if (    buttons[0].getText().equals("X") &&
                buttons[3].getText().equals("X") &&
                buttons[6].getText().equals("X") )
            xWins(0,3,6);
        if (    buttons[1].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[7].getText().equals("X") )
            xWins(1,4,7);
        if (    buttons[2].getText().equals("X") &&
                buttons[5].getText().equals("X") &&
                buttons[8].getText().equals("X") )
            xWins(2,5,8);
        if (    buttons[0].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[8].getText().equals("X") )
            xWins(0,4,8);
        if (    buttons[2].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[6].getText().equals("X") )
            xWins(2,4,6);


        // o wins contiditions
        if (    buttons[0].getText().equals("0") &&
                buttons[1].getText().equals("0") &&
                buttons[2].getText().equals("0") )
            oWins(0,1,2);
        if (    buttons[3].getText().equals("0") &&
                buttons[4].getText().equals("0") &&
                buttons[5].getText().equals("0") )
            oWins(3,4,5);
        if (    buttons[6].getText().equals("0") &&
                buttons[7].getText().equals("0") &&
                buttons[8].getText().equals("0") )
            oWins(6,7,8);
        if (    buttons[0].getText().equals("0") &&
                buttons[3].getText().equals("0") &&
                buttons[6].getText().equals("0") )
            oWins(0,3,6);
        if (    buttons[1].getText().equals("0") &&
                buttons[4].getText().equals("0") &&
                buttons[7].getText().equals("0") )
            oWins(1,4,7);
        if (    buttons[2].getText().equals("0") &&
                buttons[5].getText().equals("0") &&
                buttons[8].getText().equals("0") )
            oWins(2,5,8);
        if (    buttons[0].getText().equals("0") &&
                buttons[4].getText().equals("0") &&
                buttons[8].getText().equals("0") )
            oWins(0,4,8);
        if (    buttons[2].getText().equals("0") &&
                buttons[4].getText().equals("0") &&
                buttons[6].getText().equals("0") )
            oWins(2,4,6);
    }

    // highlights the winning combination
    private void xWins(int a, int b, int c) {
        buttons[a].setBackground( Color.GREEN );
        buttons[b].setBackground( Color.GREEN );
        buttons[c].setBackground( Color.GREEN );

        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        title.setText("X wins");
        xWins = true;
        isGameOver = true;
    }

    // highlights the winning combination
    private void oWins(int a, int b, int c) {
        buttons[a].setBackground( Color.GREEN );
        buttons[b].setBackground( Color.GREEN );
        buttons[c].setBackground( Color.GREEN );

        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        title.setText("O wins");
        oWins = true;
        isGameOver = true;
    }

    private boolean isDraw() {
        for ( JButton button : buttons ) {
            if ( button.getText().equals("") )
                return false;
        }
        return true;
    }

    // pops up game over message dialog
    private void gameOver() {
        int n = JOptionPane.showConfirmDialog(game.frame,"Game is over. Would you like to play again?","Game over message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if ( n == JOptionPane.YES_OPTION) {
            restartGame();

        }
        else if ( n == JOptionPane.NO_OPTION ) {
            System.exit(0);
        }
    }

    private void restartGame() {
        frame.getContentPane().removeAll();
        isGameOver = false;
        xWins = false;
        oWins = false;
        gamePanel.removeAll();
        title.setText("Tic Tac Toe");
        frame.add(game.topPanel.getTopPanel(), BorderLayout.NORTH);
        frame.add(gamePanel);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            gamePanel.add(buttons[i]);
            buttons[i].setFont( new Font("MV Boli", Font.BOLD,120) );
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton button : buttons) {
            if (e.getSource() == button) {
                if (player1Turn) {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(255, 0, 0));
                        button.setText("X");
                        player1Turn = false;
                        title.setText("O turn");
                        check();
                    }
                } else {
                    if (button.getText().equals("")) {
                        button.setForeground(new Color(0, 0, 255));
                        button.setText("0");
                        player1Turn = true;
                        title.setText("X turn");
                        check();
                    }
                }
            }
        }

        if ( isGameOver){
            gameOver();
        }
        if ( !xWins && !oWins && isDraw() ) {
            title.setText("DRAW");
            gameOver();
        }
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }
}
