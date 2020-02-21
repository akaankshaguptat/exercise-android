import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
Created By
akaanksha
on 21/02/20
*/

//Write a method that takes a string and print the number of occurrence of each character characters in the string.

public class Q3_CharOccurence {
    static void occurence(String s1){
        HashMap<Character,Integer> h1=new HashMap<Character, Integer>();
        char[] s3=s1.toCharArray();
        for (char c: s3) {
            if(h1.containsKey(c))
            {
                //System.out.println(c);
                h1.put(c, h1.get(c)+1);
            }
            else
            {
                h1.put(c, 1);
            }

        }
        System.out.println(s1+" : "+h1);


    }
    public static void main(String[] args) {
        String s1;
        Scanner sc =new Scanner(System.in);
        System.out.println("enter string");
        s1=sc.nextLine();
        occurence(s1);

    }
}
