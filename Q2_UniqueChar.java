import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Created By
akaanksha
on 21/02/20
*/
//Write a method that takes a string and returns the number of unique characters in the string.
public class Q2_UniqueChar {
    public static void main(String[] args) {
        String s1;
        System.out.println("enter string");
        Scanner sc=new Scanner(System.in);
        s1=sc.nextLine();
        String s2[]=s1.split("");
        Set<String> set1 = new HashSet<String>();
        for (int i = 0; i < s2.length; i++) {
            set1.add(s2[i]);
        }
        System.out.println("no. of unique character in string :"+ set1.size());
    }
}
