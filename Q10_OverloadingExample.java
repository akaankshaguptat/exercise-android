//Q10.Write a single program for following operation using overloading
//        A) Adding 2 integer number
//        B) Adding 2 double
//        C) multiplying 2 float
//        D) multiplying 2 int
//        E) concate 2 string
//        F) Concate 3 String
import java.lang.*;
public class Q10_OverloadingExample {
    void add(int a,int b){
        System.out.println(a+b);
    }
    void add(double a,double b)
    {
        System.out.println(a+b);
    }
    void multiply(float a,float b){
        System.out.println(a*b);
    }
    void multiply(int a,int b){
        System.out.println(a*b);
    }
    void concatenate(String a,String b){
        System.out.println(a+b);
    }
    void concatenate(String a,String b,String c){
        System.out.println(a+b+c);
    }

    public static void main(String[] args) {
        Q10_OverloadingExample ob=new Q10_OverloadingExample();
        ob.add(5,5);
        ob.add(10.10,10.10);
        ob.multiply(5,5);
        ob.multiply(2.1f,2.1f);
        ob.concatenate("ab","cd");
        ob.concatenate("aa","ff","gg");

    }

}
