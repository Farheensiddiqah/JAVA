package Recursion;
//print all binary strings of size n without 
//consecutive ones
public class binaryStrings {
    public static void binaryStr(int n,int lastplace, String str){
        //base class
        if(n==0){
            System.out.println(str);
            return;
        }
        //work
        binaryStr(n-1,0,str+"0");
        if(lastplace==0){
            binaryStr(n-1,1,str+"1");
        }

    }
    public static void main(String args[]){
        int n=3;
        binaryStr(3,0,"");
    }
    
}
