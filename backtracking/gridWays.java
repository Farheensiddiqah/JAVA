package backtracking;
/*  Find the number of ways to reach from (0,0) to (N-1,M-1)
 *  in a N*M Grid.
 * Allowed moves - one right and down diretion only
 * ---> so if righy means (x,y+1) whereas down means (x+1,y)
 * TC : O(2^(n+m))
 * 
 * BUT THE OPTIMIZED by using simple formula
 *  == (n-1+m-1)!
 *     -----------      // SO with thi formula we get TC: O(n+m)
 */ // (n-1)!*(m-1)!

public class gridWays {
    public static int gridwaysfun(int i,int j,int n,int m){
        //Base Case
        if(i==n-1 && j==m-1){  //condition for final destination
            return 1;
        } else if(i==n || j==n){
            return 0;
        }
        //Total Ways
        int w1 = gridwaysfun(i+1,j,n,m);
        int w2 = gridwaysfun(i,j+1,n,m);
        return w1+w2;
    }
    public static void main(String args[]){
        int n=3,m=3;
        System.out.println(gridwaysfun(0,0,n,m));
    }
}
