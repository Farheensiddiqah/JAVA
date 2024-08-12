// Question 2 : Print out the sum of the numbers in the second row of the “nums” array.
// Example :
// Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
// Output - 18
import java.util.*;
public class sumOfSecondRow {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int row=matrix.length,col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int sum=0;
        for(int j=0;j<col;j++){
            sum+=matrix[1][j];
        }
        
        System.out.println(sum);
    }
}
