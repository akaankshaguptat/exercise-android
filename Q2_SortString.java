/*
Created By
akaanksha
on 18/02/20
*/
import java.util.*;
import java.lang.*;

public class Q2_SortString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        char temp='@';
        char ch[]=s1.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            for (int j = 0; j < ch.length; j++) {
                if(ch[j]>ch[i]){
                    temp=ch[i];
                    ch[i]=ch[j];
                    ch[j]=temp;
                }

            }

        }
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }

    }


}
