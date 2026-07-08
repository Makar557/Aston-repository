package org.Dubrovsky.Aston.Homework.fourth;

public class OneAndTwoPrinter {

    private final ThreadTools tools = new ThreadTools();
    private boolean firstTurn = true;

    public void invoke(Object lock) {

        Thread t1 = new Thread(() -> {
            runDemo(lock, 1, true);
        });

        Thread t2 = new Thread(() -> {
            runDemo(lock, 2, false);

        });

        tools.threadStarter(t1, t2);
    }

    private void runDemo(Object lock, int number, boolean isFirst) {
        while (true) {
            synchronized (lock) {

                while (firstTurn != isFirst) {
                    tools.threadWait(lock);
                }

                System.out.println(number);
                firstTurn = !isFirst;

                lock.notifyAll();
            }
        }
    }
}
