/*
Created By
akaanksha
on 20/02/20
*/

public class Q5_WaitAndNotify {
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("count is: " + b.count);
        }
    }
}

class ThreadB extends Thread{
    int count;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                count += i;
            }
            notify();
        }
    }
}