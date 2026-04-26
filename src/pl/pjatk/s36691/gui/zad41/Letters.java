package pl.pjatk.s36691.gui.zad41;

public class Letters {
    private Thread[] threads;

    public Letters(String text) {
        threads = new Thread[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char name = text.charAt(i);
            threads[i] = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.print(name);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Thread " + name);
        }
    }

    public Thread[] getThreads() {
        return threads;
    }

}
