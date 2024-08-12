package Recursion;
/* Tilling Problem==
 * Given a "2*n board and tiles of a size "2*1",
 * count the number of ways to tile the given board using the 2*1 tiles.
 * (A tile can either be placed horizantally or vertically.)
 */
public class tillingProblem {
    public static int tillingqn(int n){
        if(n==0 || n==1){
            return 1;
        }

        //choice of selecting --
        //vertically
        int vertical = tillingqn(n-1);
        //horizantally
        int horizantal = tillingqn(n-2);
        //Total Ways are
        int totalways = vertical+horizantal;
        return totalways;
    }
    public static void main(String args[]){
        int n=4;
        System.out.println(tillingqn(n));
    }
}
