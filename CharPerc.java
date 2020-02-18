//Q4. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String
import java.util.*;
import java.lang.*;

public class CharPerc {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s1=sc.nextLine();
        int lo=0,up=0,di=0,sp=0;
        for(int i=0;i<s1.length();i++){
            if(Character.isLowerCase(s1.charAt(i))){
                lo++;
            }
           else if(Character.isUpperCase(s1.charAt(i))){
                up++;
            }
           else if(Character.isDigit(s1.charAt(i))){
            di++;
            }
           else{
            sp++;
            }



    }
        int len=s1.length();

        float lo1=((float) lo/len)*100;
        float up1=((float)up/len)*100;
        float di1=((float)di/len)*100;
        float sp1=((float)sp/len)*100;
        System.out.println("lower case percentage"+lo1);
        System.out.println("upper case percentage"+up1);
        System.out.println("digit percentage"+di1);
        System.out.println("special char percentage"+sp1);

}}
