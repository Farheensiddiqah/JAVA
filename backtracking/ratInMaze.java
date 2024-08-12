package backtracking;
/*
 * Question 1 :Rat in a Maze You are given a starting position for a rat which is 
 * stuck in a maze at an initial point(0,0) (the maze can be thought of as a 
 * 2-dimensional plane).The maze would be given in the form of a square matrix
 *  of order N*N where the cell swith value 0 represent the maze’s blocked
 * locations while value 1 is the open /available path that the rat can 
 * take to reach its destination.The rat's destination is at (N - 1, N - 1).
 * Your task is to find all the possible paths that the rat can take to reach
 * from source to destination in the maze.The possible directions that it can
 * take to move in the maze are 'U'(up) i.e.(x,y-1),'D'(down)i.e. (x, y + 1) ,
 *  'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).(This problem is
 *  similar to Grid ways.)
 * Sample Input: int maze[][] = { { 1, 0, 0, 0 },
 *                                { 1, 1, 0, 1 },
 *                                { 0, 1, 0, 0 },
 *                                { 1, 1, 1, 1 } };
 */
public class ratInMaze {
    //To print result
    public static void printMaze(int n,int mazeres[][]){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mazeres[i][j]);
            }
            System.out.println();
        }
    }
    //To check wheather safe or not
    public static boolean isSafe(int n,int maze[][],int mazeres[][],int row,int col){
        if(row < n && col < n && maze[row][col]==1){
            return true;
        }
        return false;
    }
    public static boolean ratInMazeFun(int n,int maze[][],int mazeres[][],int row,int col){
        //Base case
        if(row==n-1 && col == n-1){ //doubt
            mazeres[row][col] = 1;
            return true;
        }
        //recursion
        if(isSafe(n,maze,mazeres,row,col)){
            mazeres[row][col] = 1;
            // //UP
            // if(ratInMazeFun(n,maze,mazeres,row-1,col)){
            //     return true;
            // }
            //Down
            if(ratInMazeFun(n,maze,mazeres,row+1,col)){
                return true;
            }
            //right
            if(ratInMazeFun(n,maze,mazeres,row,col+1)){
                return true;
            }
            //left
            // if(ratInMazeFun(n,maze,mazeres,row,col-1)){
            //     return true;
            // }
            mazeres[row][col] =0;
            return false;
        }
        return false;
    }
    public static void main(String args[]){
        int n=4;
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        int mazeres[][]= new int[n][n];
        ratInMazeFun(n, maze, mazeres, 0 ,0);
        printMaze(n,mazeres);
    }
}
