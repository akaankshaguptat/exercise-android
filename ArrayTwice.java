//Q6. There is an array with every element repeated twice except one. Find that element
import java.util.*;
import java.lang.*;
public class ArrayTwice {
    public static void main(String[] args) {
        System.out.println("enter size of array");
        Scanner sc =new Scanner(System.in);
        int m=sc.nextInt();
        System.out.println("enter element of array");
        int ar[]=new int[m];
        for (int i = 0; i <m; i++) {
            ar[i]=sc.nextInt();
        }
        Arrays.sort(ar);
        boolean flag=true;
        for (int j = 0; j <m-1; j=j+2) {

            if((ar[j]!=ar[j+1]))
            {
                System.out.println(ar[j]);
                flag=false;

                break;
            }




        }
        if (flag){
            System.out.println(ar[m-1]);
        }
    }
}
