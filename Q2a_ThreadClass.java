/*
Created By
akaanksha
on 20/02/20
*/
public class Q2a_ThreadClass extends Thread
{
    public void run(){
        System.out.println("thread running");
    }

    public static void main(String[] args) {
        Q2a_ThreadClass tc= new Q2a_ThreadClass();
        tc.start();
    }
}
