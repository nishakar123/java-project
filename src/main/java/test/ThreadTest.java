package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    static void main(String args[]) {
        MultiThreadHandle obj =  new MultiThreadHandle();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable runnableTask1 = () -> { obj.test1(); };
        Runnable runnableTask2 = () -> { obj.test2(); };

        executor.execute(runnableTask1);
        executor.execute(runnableTask2);

        executor.shutdown();
    }
}

class MultiThreadHandle {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void test1() {
        synchronized (lock1) {
            System.out.println("Inside Test1 Method");
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void test2() {
        synchronized (lock2) {
            System.out.println("Inside Test2 Method");
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
