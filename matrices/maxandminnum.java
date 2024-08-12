// package matrices;
import java.util.*;
public class maxandminnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][]=new int[3][3];
        int n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int maxnum = Integer.MIN_VALUE,minnum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxnum=Math.max(maxnum,matrix[i][j]);
                minnum=Math.min(minnum,matrix[i][j]);
            }
        }
        System.out.println(maxnum+" is maximum");
        System.out.println(minnum+" is minimum");
    }
}
