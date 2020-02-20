import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Created By
akaanksha
on 20/02/20
*/
public class Q4_OddEven {

    public static void main(String[] args){

        ExecutorService executor= Executors.newFixedThreadPool(2);
        executor.submit(new OddThread());
        executor.submit(new EvenThread());
        executor.shutdown();
    }

}

class EvenThread implements Runnable{


    @Override
    public synchronized void run() {

        for(int i=1;i<=10;i++){
            if(i%2==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("even number "+i);

            }

        }
      notify();


    }
}


class OddThread implements Runnable{



    @Override
    public synchronized void run() {

        for(int i=1;i<=10;i++){

            if(i%2==1){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("odd number "+i);
            }
            notify();

        }
    }
}
