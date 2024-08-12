package strings;

public class charAtmethod {
    public static void main(String[] args) {
        String firstname="Farheen";
        // String lastname="Siddiqah";
        String fullname = "Farheen Siddiqah";
        System.out.println(fullname.charAt(0));
        //above gives the str at 0th index
        for(int i=0;i<fullname.length();i++){
            System.out.print(fullname.charAt(i)+" ");
        }
        System.out.println();
    }
}
