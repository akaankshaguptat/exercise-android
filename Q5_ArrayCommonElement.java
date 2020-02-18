//Q5. Find common elements between two arrays.
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
public class Q5_ArrayCommonElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size");
        int m=sc.nextInt();
        System.out.println("enter array size");

        int n=sc.nextInt();

        int arr1[]=new int[m];

        int arr2[]=new int[n];
        System.out.println("enter array 1 elements");
        for(int i=0;i<m;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter array 2 elements");
        for(int j=0;j<n;j++){
            arr2[j]=sc.nextInt();
        }
      int s=m<n?m:n; //small array length
      int l=m>n?m:n; //large array length
        System.out.println("common elements");

        for(int k=0;k<s;k++){
            for(int q=0;q<l;q++){

               if(arr1[k]==arr2[q])
               {
                   System.out.println(arr1[k]);
               }
            }

        }

    }






}


