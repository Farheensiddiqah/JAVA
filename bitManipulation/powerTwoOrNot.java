package bitManipulation;
import java.util.*;
public class powerTwoOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n&(n-1))==0){
            System.out.println("Power of Two");
        } else{
            System.out.println("not the power of two");
        }
    }
}
/*there is a special property to check that
 * 4-> 1 0 0
 * 3-> 0 1 1
 * if we and opeartion ans:0
 * ------------------
 * 8-> 1 0 0 0
 * 7-> 0 1 1 1
 * and=0
 * --------------
 * simillarly if we do (n&(n-1))==0
 */
