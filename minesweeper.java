import java.util.ArrayList;

public class Minesweeper {
  
  public static int[][] generate(int r, int c){
    int[][] board = new int[r][c];
    //10% of the board should have mines
    double threshold = 0.9;
    for (int i = 0; i < r; i++){
      for (int j = 0; j < c; j++){
        if (Math.random() > threshold){
          board[i][j] = -1;
        }
      }
    }
    for (int i = 0; i < r; i++){
      for (int j = 0; j < c; j++){
        board[i][j] = countMines(board, i, j);
      }
    }
    return board;
  }
  
}
