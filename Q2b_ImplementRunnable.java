/*
Created By
akaanksha
on 20/02/20
*/
public class Q2b_ImplementRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("thread running");
    }

    public static void main(String[] args) {
        Thread tc=new Thread(new Q2b_ImplementRunnable());
        tc.start();
    }
}
