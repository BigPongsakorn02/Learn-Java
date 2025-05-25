import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import java.util.Random;


public class tictactoe extends Application {
    private Button[][] board = new Button[3][3];
    private boolean playerTurn = true; // true = X's turn, false = O's turn
    private Text statusText = new Text("Player X's Turn");
    private Random random = new Random();

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        // Create Tic Tac Toe buttons
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btn = new Button(" ");
                btn.setMinSize(60, 60);
                int r = row, c = col;
                btn.setOnAction(e -> makeMove(btn, r, c));
                board[row][col] = btn;
                grid.add(btn, col, row);
            }
        }

        Button restartBtn = new Button("Restart");
        restartBtn.setOnAction(e -> resetGame());

        VBox root = new VBox(10, statusText, grid, restartBtn);
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root, 250, 300));
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }

    private void makeMove(Button btn, int row, int col) {
        if (!btn.getText().equals(" ")) return; // Ignore already filled cells
        btn.setText("X"); // Player move
        playerTurn = false;

        if (checkWin("X")) {
            statusText.setText("Player X Wins!");
            disableBoard();
            return;
        }

        if (isBoardFull()) {
            statusText.setText("It's a Draw!");
            return;
        }

        // Computer Move (Basic Logic)
        computerMove();

        if (checkWin("O")) {
            statusText.setText("Computer Wins!");
            disableBoard();
        }
    }

    private void computerMove() {
    // Try to win first
    if (tryPlaceMark("O")) return;

    // Try to block player’s win
    if (tryPlaceMark("X")) return;

    // Else pick random move
    int row, col;
    do {
        row = random.nextInt(3);
        col = random.nextInt(3);
    } while (!board[row][col].getText().equals(" "));
    board[row][col].setText("O");
}

    private boolean checkWin(String mark) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals(mark) && board[i][1].getText().equals(mark) && board[i][2].getText().equals(mark)) return true;
            if (board[0][i].getText().equals(mark) && board[1][i].getText().equals(mark) && board[2][i].getText().equals(mark)) return true;
        }
        return (board[0][0].getText().equals(mark) && board[1][1].getText().equals(mark) && board[2][2].getText().equals(mark)) ||
               (board[0][2].getText().equals(mark) && board[1][1].getText().equals(mark) && board[2][0].getText().equals(mark));
    }

    private boolean isBoardFull() {
        for (Button[] row : board)
            for (Button btn : row)
                if (btn.getText().equals(" ")) return false;
        return true;
    }

    private void disableBoard() {
        for (Button[] row : board)
            for (Button btn : row)
                btn.setDisable(true);
    }

    private void resetGame() {
        for (Button[] row : board)
            for (Button btn : row) {
                btn.setText(" ");
                btn.setDisable(false);
            }
        playerTurn = true;
        statusText.setText("Player X's Turn");
    }

    public static void main(String[] args) {
        launch();
    }

    private boolean tryPlaceMark(String mark) {
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            if (board[row][col].getText().equals(" ")) {
                board[row][col].setText(mark); // simulate placing X or O
                boolean wouldWin = checkWin(mark);
                board[row][col].setText(" ");  // reset
                if (wouldWin) {
                    board[row][col].setText("O"); // actual bot move
                    return true;
                }
            }
        }
    }
    return false;
}


}


