package pl.pjatk.s36691.gui.zad39;

public class ThreadsTest {
    public static final int STEPS = 10000000;
    public static final int MAX_AMOUNT = 10000000;

    public static void main(String[] args) {
        Bank bank = new Bank(4, MAX_AMOUNT);

        Runnable operation_0_1 = ()-> {
            for (int i = 0; i < STEPS; i++) {
                int amount = (int) (Math.random() * (MAX_AMOUNT +1));
                int from = (int) (Math.random() * 4);
                int to = (int) (Math.random() * 4);

                while (to == from) {
                    to = (int) (Math.random() * 4);
                }
                bank.transfer(from, to, amount);
                System.out.println("Thread1, Total bank balance: " + bank.getTotalBalance());
            }
        };

        Runnable operation_2_3 = ()-> {
            for (int i = 0; i < STEPS; i++) {
                int amount = (int) (Math.random() * (MAX_AMOUNT +1));
                int from = (int) (Math.random() * 4);
                int to = (int) (Math.random() * 4);

                while (to == from) {
                    to = (int) (Math.random() * 4);
                }
                bank.transfer(from, to, amount);
                System.out.println("Thread2, Total bank balance: " + bank.getTotalBalance());
            }
        };

        Thread t1 = new Thread(operation_0_1);
        Thread t2 = new Thread(operation_2_3);
        t1.start();
        t2.start();

    }

}


