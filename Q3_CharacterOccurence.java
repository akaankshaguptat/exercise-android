//Q3. Write a program to find the number of occurrences of a character in a string without using loop?
import java.util.*;
import  java.lang.*;
public class Q3_CharacterOccurence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        String s1=sc.nextLine();

        System.out.println("enter character");
        String s2=sc.nextLine();

        int count=s1.length()-s1.replace(s2,"").length();
        System.out.println("occurence of "+s2+" is "+count);

    }
}
