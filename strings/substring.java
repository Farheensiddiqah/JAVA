package strings;
//Inbulit also available
 //strname.substring(stratindex,endindex);
public class substring {
    public static void main(String args[]){
        String str="HelloWorld";
        int st=0,end=5;
        String substr="";
        for(int i=st;i<end;i++){
            substr+=str.charAt(i);
        }
        System.out.println(substr);
        //Inbulit also available
        //strname.substring(stratindex,endindex);
    }
}
