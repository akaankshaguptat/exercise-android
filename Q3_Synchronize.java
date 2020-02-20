/*
Created By
akaanksha
on 20/02/20
*/
public class Q3_Synchronize extends Thread{
    public int count=0;

    //using synchronized method
    public  void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println("Inside thread classs using synchronized method "+ i);
            incrementCount();
            synchronizedBlock();

        }
        System.out.println("count=="+count);

    }

    //synchronized method
    private synchronized void incrementCount() {
        count++;
    }

    //synchronized block
    private void synchronizedBlock() {

        //using synchronized block
        synchronized(this)
        {
            count++;
        }
    }


    public static void main(String[] args) {

        Q3_Synchronize q3_synchroni=new Q3_Synchronize();
        Q3_Synchronize q3_synchroni1=new Q3_Synchronize();
        q3_synchroni.start();
        q3_synchroni1.start();

    }
}
