import java.util.Scanner;

/*
Created By
akaanksha
on 19/02/20
*/
public class Q8_WordDone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1;
        do {
            System.out.println("enter a word");
            s1=sc.nextLine();
            if(!s1.equals("done")){
                if(s1.charAt(0)==s1.charAt(s1.length()-1))
                {
                    System.out.println("first and last character of "+s1+" is equal");
                }
            }
        }while(!s1.equals("done"));
    }
}
