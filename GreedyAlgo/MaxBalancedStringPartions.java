package GreedyAlgo;
/*
 * Maximum Balanced String Partitions We have balanced string str of
 * size N with an equal number of L and R,the task is to find a 
 * maximum number X,such that a given string can be partitioned 
 * into X balanced substring.A string is called to be balanced
 *  if the number of ‘L’s in the string equals the number of ‘R’s.
 * Input: “LRRRRLLRLLRL”
 * output : 3
 */
public class MaxBalancedStringPartions {
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int l=0,r=0;
        int ansCount=0;
        for(int i=0;i<str.length();i++){
            //if l then increase count
            if(str.charAt(i) == 'L'){
                l++;
            }
            //if r means increase count
            if(str.charAt(i) == 'R'){
                r++;
            }
            //if equal then ans count increases
            if(l==r){
                ansCount++;
            }
        }
        System.out.println("It Becmes equal for = "+ ansCount +" times");
    }
}
