//for an array with height = [4,2,0,6,3,2,5]
// so to find the trapped water between the different buildings
// with the simple logic 
    // 1.first find the left max boundary 
    // 2.find the right max boundary
    // 3.then find the minimum(left bound,right bound) = trapped water
package arrays;
//got in online compiler you are waste compiler
//Tc: o(n)
import java.util.*;
public class trappingrainwater {
    public static int trappedwater(int height[]){
        int n = height.length;
        //calculate left max boundary-array
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for(int i=1;i<n;i++){
            leftmax[i]= Math.max(height[i], leftmax[i-1]);
        }
        //right max boundary-array
        int rightmax[]= new int[n];
        rightmax[n-1]=height[n-1];
        for(int j=n-2;j>=0;j--){
            rightmax[j] = Math.max(height[j],rightmax[j+1]); 
        }
        //loop
        int trappwaterans=0;
        for(int k=0;k<n;k++){
            //waterlevel = min(leftmaxboun-rightmaxbound)
            // trapped water = waterlevel-height[i]
            int waterlevel = Math.min(rightmax[k],leftmax[k]);
            trappwaterans += waterlevel-height[k];
        }
        return trappwaterans;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(trappedwater(height));
    }
}
