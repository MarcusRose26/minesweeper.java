import java.util.ArrayList;

public class Minesweeper {
  
  public static void main(String[] args){
    int[][] board = generate(10, 10);
  }
  
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
  
  public static int countMines(int[][] board, int r, int c){
    int x = 0;
    if (board[r][c] == -1){
      return -1;
    }
    for (int i = r - 1; i < r + 2; i++){
      for (int j = c - 1; j < c + 2; j++){
        if (isValid(board, i, j) && board[i][j] == -1){
          x++;
        }
      }
    }
    return x;
  }
  
  public static boolean isValid(int[][] board, int r, int c){
    if (r < 0 || c < 0){
      return false;
    }
    if (r >= board.length || c >= board[0].length){
      return false;
    }
    return true;
  }
  
  public static void printBoard(int[][] board){
    for (int[] row : board){
      for (int spot : row){
        if (spot == -1){
          System.out.print("X ");
        }
        else{
          System.out.print(spot + " ");
        }
      }
      System.out.println();
    }
  }
  
  
  
}
