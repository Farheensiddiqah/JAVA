package arrayLists;
import java.util.*;
public class containerWithMostWater {
    public static int storeWater(ArrayList<Integer> height){
        //Brute force approch
        int maxWater=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht = Math.min(height.get(i),height.get(j));
                int width = j-i;
                int currwater = ht*width;
                maxWater = Math.max(maxWater,currwater);
            }
        }
        return maxWater;
    }

    public static int storeWater2Pointer(ArrayList<Integer> height) {
        //2 pointer approch
        int maxWater = 0;
        int lp=0;
        int rp = height.size()-1;
        while(lp < rp){
            //calculate water area
            int ht = Math.min(height.get(lp),height.get(rp));
            int wt = rp-lp;
            int currWater = ht*wt;
            maxWater = Math.max(maxWater,currWater);

            //update ptr
            if(height.get(lp)<height.get(rp)){
               lp++; 
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        //1 8 6 2 5 4 8 3 7
        System.out.println(storeWater(height));
        System.out.println(storeWater2Pointer(height));
    }
}
