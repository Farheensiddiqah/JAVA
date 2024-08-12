// Question 1 : Print the number of 7’s that are in the 2d array.
// Example :
// Input - int[][] array = { {4,7,8},{8,8,7} };
// Output - 2
import java.util.*;
public class countofnums {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int matrix[][] = new int[2][3];
        int row=matrix.length,col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int num= sc.nextInt();
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==num){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
