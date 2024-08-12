// package matrices;
// 10 20 30 40--->if we observe a pattern in 40 cell:(0,(m-1))
// 15 25 35 45
// 27 29 37 48
// 32 33 39 50 -->ans: for key 33 : found at(3,1)
//->as the search key if(key<cell value) - move left
// if key>cellvalue then- move bottom
import java.util.*;
public class searchInSortedarr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int matrix[][] = new int[4][4];
    int key=33;
    int n=matrix.length,m=matrix[0].length;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            matrix[i][j]= sc.nextInt();
        }
    }
    int row=0,col=matrix.length-1;
    int flag=0;
    while(row<matrix.length && col>=0){
        if(matrix[row][col]==key){
            System.out.println("found at index ("+row+","+col+")");
            flag=1;
            break;
        }
        else if(key<matrix[row][col]){
            col--;
        }
        else{
            row++;
        }
    }
    if(flag==0){
        System.out.println("index not found");
    }
    }
}
