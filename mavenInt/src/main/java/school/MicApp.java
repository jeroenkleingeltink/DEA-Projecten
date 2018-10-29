package school;

public class MicApp {
    private static final int MAXTHREADS = 1000;

    public static void main(String[] args) {
        MicInt mi = new MicInt(0);
        Thread[] threads = new Thread[MAXTHREADS];

        Thread t = new Thread (new MicCounter(mi));
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(mi.getValue());
    }
}
