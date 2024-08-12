package bitManipulation;

public class checkOddEven {
    public static void main(String[] args) {
        int n = 14;
        int bitmask = 1;
        if((n&bitmask)==0){
            //even
            System.out.println("even");
        } else {
            //odd
            System.out.println("odd");
        }
    }
}

/* check oddd or even using bit manipulation
 * 0= 000
 * 1= 001
 * 2= 010
 * 3= 011
 * 4= 100
 * 5= 101
 * here if we observe the last no(lsb) will be 
 * always one --- for odd
 * always zero --- for even
 */