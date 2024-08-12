package backtracking;
//To check n safe places in n queens and TC: O(n!)
public class nQueenIsSafe {
    public static boolean isSafe(char board[][],int row,int col){
        //vertically upp
        for(int i= row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonally left up
        for(int i=row-1, j=col-1;i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //diagonally right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueensfun(char board[][],int row){
        //base case
        if(row == board.length){
          printboard(board);
          return;  
        }
        //column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueensfun(board,row+1);
                board[row][j] = 'X'; //backtracking loop
            }
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
        int n=4;
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
