package Recursion;
//remove dupicates that are from "a-z"
public class removeDuplicates {
    public static void removeDups(String str, int idx, StringBuilder newstr, boolean map[]){
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }

        //kaam
        char currchar = str.charAt(idx);
        if(map[currchar-'a']== true){
            removeDups(str,idx+1,newstr,map);
        } else{
            map[currchar-'a']=true;
            removeDups(str,idx+1,newstr.append(currchar),map);
        }
    }
    public static void main(String args[]){
        String str = "appnnacollege";
        removeDups(str,0,new StringBuilder(""),new boolean[26]);
    }
}
