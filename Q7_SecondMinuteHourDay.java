/*
Created By
akaanksha
on 18/02/20
*/
import java.lang.*;
import java.util.*;
public class Q7_SecondMinuteHourDay {
    public static void main(String[] args) {
        float sec,min;
        int hour,day;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter seconds");
        sec=sc.nextFloat();
        min=sec/60;
        hour=(int)min/60;
        day=hour/24;
        System.out.println("seconds: "+sec);
        System.out.println("minutes: "+min);
        System.out.println("hour: "+hour);
        System.out.println("days: "+day);
    }
}
