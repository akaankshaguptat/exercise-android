/*
Created By
akaanksha
on 20/02/20
*/
public class SleepMethod implements Runnable {
    Thread t;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public static void main(String[] args) {
        Thread t = new Thread(new SleepMethod());
        t.start();
    }
}
