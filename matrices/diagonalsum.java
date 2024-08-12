// package matrices;
// 2 types of diagonals:1.primary and secondary
// //  1                          1 
//       2                      2
//         3  primary          3    secondary
import java.util.*;
public class diagonalsum {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int matrix[][] = new int[4][4];
      int row= matrix.length;
      int col=matrix[0].length;
      for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            matrix[i][j] = sc.nextInt();
        }
      } 
    //   int sum=0;
    //   for(int i=0;i<row;i++){
    //     for(int j=0;j<col;j++){
    //         if(i==j || i+j==matrix.length-1){
    //             sum+=matrix[i][j];
    //         }
    //     }
    //   }
    //   System.out.println(sum);
    //
    //optimized
    //===========
    int sum=0;
    for(int i=0;i<matrix.length;i++){
        //pd
        sum+=matrix[i][i];
        //sd
        if(i!= matrix.length-i-1){
            sum+=matrix[i][matrix.length-i-1];
        }
    }
    System.out.println(sum);
    }
}

// 1 2 3
// 4 5 6
// 7 8 9

// 1 5 9 3 5 7