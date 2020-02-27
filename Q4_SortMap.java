//Write a program to sort HashMap by value.
import java.util.*;

public class Q4_SortMap {

    public static void main(String[] args) {

        LinkedHashMap<String, String> hm = new LinkedHashMap<>();
        Scanner sc=new Scanner(System.in);
        String key,val;
        for (int i = 0; i <5 ; i++) {
            System.out.println("enter key:  value pair");
            key=sc.nextLine();
            val=sc.nextLine();
            hm.put(key,val);
        }
        Map<String, String> result = sortMap(hm);

        for (Map.Entry<String, String> entry : result.entrySet())
        {
            System.out.print("Key: " + entry.getKey());
            System.out.println(" Value: " + entry.getValue());
        }
    }

    public static LinkedHashMap<String, String> sortMap(LinkedHashMap<String, String> map) {
        List<Map.Entry<String, String>> hm1 = new LinkedList<>(map.entrySet());

        Collections.sort(hm1, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : hm1)
        {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}