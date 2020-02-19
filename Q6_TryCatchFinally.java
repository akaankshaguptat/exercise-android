/*
Created By
akaanksha
on 18/02/20
*/
public class Q6_TryCatchFinally {
    public static void main(String[] args) {
        try
        {
            int a=50/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("finally block");
        }

    }
}
