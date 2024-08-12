package strings;
//gives length lexographically like alphabet wise largest
// here we can use str1.compareTo(str2);
    // --here A and a are treated differently
//and also other function -->comparetoignorecase
// here A and a are used as same
//for compareTo function -->if equals = zero
//--> <0 : -Ve  and >0 : +Ve
public class largestStr {
    public static void main(String args[]){
        String fruits[]={"apple","banana","mango"};
        String largest=fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i]) <0 ){
                largest=fruits[i];
            }   
        }
        System.out.println(largest);
    }
}
