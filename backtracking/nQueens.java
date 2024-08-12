package backtracking;
/* Place N queens on an n*n chessboard such that no 2 queens can
 * attack each other --
 * posible sols are == 1.all solutions
 *                     2. yes/no if yes print one solution
 *                     3. count solutions
 */

//This sol is about by just considering n queens in n rows by arranging
/*  n==2  --- 4 solutions
 *  Q X  -> Q X -> X Q -> X Q  
 *  Q X     X Q    Q X    X Q
 */
public class nQueens {
    public static void nQueensfun(char board[][],int row){
        //base case
        if(row == board.length){
          printboard(board);
          return;  
        }
        //column loop
        for(int j=0;j<board.length;j++){
            board[row][j] = 'Q';
            nQueensfun(board,row+1);
            board[row][j] = 'X'; //backtracking loop
        }
    }
    //to just print Arr
    public static void printboard(char board[][]){
        System.out.println("---chess board---");
        int n= board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int n=2;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        nQueensfun(board,0);
    }
}
