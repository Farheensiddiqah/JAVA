// package matrices;
import java.util.*;
public class searchno {
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int key = 5;
        int n = matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int ansss=0,anss=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==key){
                    ansss=i;
                    anss=j;
                    break;
                }
            }
        }
        System.out.print("found at indexes: "+ansss+" and"+anss);
    }   
}
