//Q8. Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer
import java.lang.*;
import java.util.Scanner;

public class Q8_StringBufferReverse
{
    public static void main(String[] args) {
        String s1;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        s1=sc.nextLine();
        StringBuffer sb=new StringBuffer();
        sb.append(s1);
        sb.reverse();
       sb.delete(4,9);
        System.out.println(sb);
    }
}
