import java.util.Scanner;

/*
Created By
akaanksha
on 27/02/20
*/
public class Q2a_UniqueChar {
    static final int NO_OF_CHARS = 256;


    static void printDistinct(String str)
    {

        int c=0;
        int[] count = new int[NO_OF_CHARS];

        /* Count frequency of characters */
        int i;
        for (i = 0; i < str.length(); i++)
            if(str.charAt(i)!=' ')
                count[(int)str.charAt(i)]++;
        int n = i;


        for (i = 0; i < n; i++)
            if (count[(int)str.charAt(i)] == 1)
                c++;
        System.out.println(c);
    }


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        String str =sc.nextLine();
        printDistinct(str);
    }
}
