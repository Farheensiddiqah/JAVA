package strings;

public class vowelsCount {
    public static void main(String args[]){
        String str="Farheen Siddiqah";
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch=Character.toUpperCase(str.charAt(i));
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                count++;
            }
        }
        System.out.println(count);
    }
}
