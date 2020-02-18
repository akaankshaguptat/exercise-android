//Q2. Write a program to find the number of occurrences of the duplicate words in a string and print them ?
import java.lang.*;
import java.util.*;
public class Duplicatewords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        String s1=sc.nextLine();
        String words[]=s1.split(" ");
//        Arrays.sort(words);
        for (int i = 0; i <words.length ; i++) {
            int count=1;
            for (int j = i+1; j < words.length; j++) {
                if(words[i].equals(words[j])){
                    count++;
                    words[j]="#";
                }

            }
            if(count>1 && words[i]!="#"){
                System.out.println(words[i]);
            }
        }
    }
}
