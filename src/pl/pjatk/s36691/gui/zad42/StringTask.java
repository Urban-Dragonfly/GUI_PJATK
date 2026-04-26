package pl.pjatk.s36691.gui.zad42;

public class StringTask implements Runnable {
    private final String text;
    private final int count;
    private TaskState state;
    private String result;
    private Thread thread;

    public StringTask(String text, int runs) {
        this.text = text;
        this.count = runs;
        this.state = TaskState.CREATED;
        this.thread = new Thread(this);
        this.result = "";
    }

    @Override
    public void run() {
        state = TaskState.RUNNING;

        for (int i = 0; i < count; i++) {
            if (Thread.currentThread().isInterrupted()) {
                state = TaskState.ABORTED;
                return;
            }

            result += text;
        }

        state = TaskState.READY;
    }

    public String getResult() {
        return result;
    }

    public TaskState getState() {
        return state;
    }

    public void start() {

        thread.start();
    }

    public void abort() {
        if (thread != null) {
            thread.interrupt();
        }
    }

    public boolean isDone() {
        return state == TaskState.READY || state == TaskState.ABORTED;
    }
}
