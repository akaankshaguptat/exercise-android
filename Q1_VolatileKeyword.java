/*
Created By
akaanksha
on 20/02/20
*/
public class Q1_VolatileKeyword implements Runnable {
    private volatile int count = 0;
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            count++;
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new Q1_VolatileKeyword());
        Thread t2=new Thread(new Q1_VolatileKeyword());
        t1.start();
        t2.start();
    }
}
