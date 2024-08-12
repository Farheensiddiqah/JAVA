package strings;
//here since strings are immutable we cannot modify so in this case we can use string builder
//Syntax:  StringBuilder sb= new StringBuilder(" ");
public class strBuilder {
    public static void main(String[] args) {
        StringBuilder sb =  new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }
        System.out.println(sb);
        //o(26)
    }
}
//there is also string buffer
