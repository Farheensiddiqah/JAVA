package strings;
import java.util.*;
public class anagrams {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        //here we can just sort the strings and check simply
        //so to sort here we use chararray
        if(str1.length()==str2.length()){
            //convert strings to char arr
            char str1arr[] = str1.toCharArray();
            char str2arr[] = str2.toCharArray();
            //sort the  char array
            Arrays.sort(str1arr);
            Arrays.sort(str2arr);
            //check using command
            if(Arrays.equals(str1arr,str2arr)){
                System.out.println("Anagarams");
            } else{
                System.out.println("not anagarams");
            }
        } else{
            System.out.println("not anagarms");
        }
    }
}
