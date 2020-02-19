/*
Created By
akaanksha
on 19/02/20
*/
public class Q3b_ClassNotFoundException {
    public static void main(String[] args) {
        try {
            Class.forName("hello world");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
