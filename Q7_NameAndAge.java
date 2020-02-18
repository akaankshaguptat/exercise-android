//Q7. Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively
import java.lang.*;
import java.util.*;
public class Q7_NameAndAge {
    static{
        String firstname="Akaanksha ";
        System.out.println(firstname);
    }
    static void printLastName(){
        String lastname="Gupta";
        System.out.println(lastname);
    }

    static int age=20;

    public static void main(String[] args) {
        printLastName();
        System.out.println(age);

    }
}
