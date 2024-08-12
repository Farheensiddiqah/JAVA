package strings;
// String compression for example
// aaabbcccdd==a3b2c3d2 -> became less
// abc=a1b1c1   ->not compressed if single print only 1 a 
public class strCompression {
    public static void main(String[] args) {
       String str = "aaabbcccdd";
       StringBuilder sb = new StringBuilder("");
       for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
       } 
       System.out.println(sb);
    }
}
