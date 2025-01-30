import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650; // 50px for the title bar

    JFrame frame = new JFrame("Tic Tac Toe");// create a window with the title "Tic Tac Toe"
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;

    TicTacToe() {
        frame.setVisible(true);// make the window visible
        frame.setSize(boardWidth, boardHeight);// set the size of the window
        frame.setLocationRelativeTo(null);// center the window
        frame.setResizable(false);// make the window not resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// make the window close when you click the close button
        frame.setLayout(new BorderLayout());// set the layout of the window to BorderLayout

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);// set the text color to white
        textLabel.setFont(new Font("Arial", Font.BOLD, 32));// set the font of the text
        textLabel.setHorizontalAlignment(JLabel.CENTER);// center the text
        textLabel.setText("Tic Tac Toe");// set the text
        textLabel.setOpaque(true);// make the background color visible

        textPanel.setLayout(new BorderLayout());// set the layout of the textPanel to BorderLayout
        textPanel.add(textLabel);// add the textLabel to the textPanel
        frame.add(textPanel, BorderLayout.NORTH);// add the textPanel to the window

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.DARK_GRAY);
        frame.add(boardPanel);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 32));
                tile.setFocusable(false);
                //tile.setText(currentPlayer);
                
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e ) {

                        if (gameOver) return;                          

                        JButton tile = (JButton) e.getSource();

                        if(tile.getText() == "") {
                            
                            tile.setText(currentPlayer);

                            //checkWinner();

                            if(!gameOver) {
                                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn");
                            }

                        } 
                        

                    }
                });
            }
        }

        // void checkWinner(){
        //     //Check rows
            
        // }
    }
}
