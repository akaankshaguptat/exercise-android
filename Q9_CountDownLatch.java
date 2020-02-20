/*
Created By
akaanksha
on 20/02/20
*/
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor1 implements Runnable {
    private CountDownLatch latch;

    public Processor1(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        latch.countDown();
    }
}

public class Q9_CountDownLatch {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=0; i < 5; i++) {
            executor.submit(new Processor1(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }

}