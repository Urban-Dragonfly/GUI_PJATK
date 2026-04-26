package pl.pjatk.s36691.gui.zad37;

public class Main {
    public static void main(String[] args) {
        Runnable sleepyKitty1 = ()-> {
            try {
                while(!Thread.currentThread().isInterrupted()) {
                    System.out.println("^o.o^ Cat1 woke up!");
                    Thread.sleep(500);
                    System.out.println("^-.-^ Cat1 goes to sleep!");
                    Thread.sleep(1000);
                    if(Math.random() < 0.15) {
                        Thread.currentThread().interrupt();
                        //the loop
                        //will stop after checking condition, and
                        //we’ll reach the end of run method
                    }
                }
            }catch(InterruptedException e){
                System.out.println("How could you cause an exception for Cat1?!");
            }finally{
                System.out.println("Cat1 went somewhere else...");
            }
        };
        Runnable sleepyKitty2 = ()-> {
            try {
                while(!Thread.currentThread().isInterrupted()) {
                    if(Math.random() < 0.15) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("^o.o^ Cat2 woke up!");
                    Thread.sleep(500);
                    //if the thread is interrupted
                    //calling sleep on it will cause an exception.
                    System.out.println("^-.-^ Cat2 goes to sleep!");
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println("How could you cause an exception for Cat2?!");
            }finally{
                System.out.println("Cat2 went somewhere else...");
            }
        };
        Thread cat1 = new Thread(sleepyKitty1);
        cat1.start();
        Thread cat2 = new Thread(sleepyKitty2);
        cat2.start();
    }
}
