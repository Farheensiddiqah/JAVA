package backtracking;
//Check if problem can be solved and print only 1 solution 
//to N queens problem.
public class nQueensPrintOneSol {
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
    public static boolean nQueensfun(char board[][],int row){
        //base case
        if(row == board.length){
          printboard(board);
          return true;  
        }
        //column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                if(nQueensfun(board,row+1)){
                    return true;
                }
                board[row][j] = 'X'; //backtracking loop
            }
        }
        return false;
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
        if(nQueensfun(board,0)){
            System.out.println("Solution is possible");
        } else {
            System.out.println("Solution is not possible");
        }
    }
}
