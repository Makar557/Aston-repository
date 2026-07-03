package org.Dubrovsky.Aston.Homework.fourth;

public class PrintNumbers {

    private static final Object lock = new Object();
    private static boolean firstTurn = true;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (!firstTurn) {
                        threadWait();
                    }

                    System.out.println("1");
                    firstTurn = false;
                    lock.notifyAll();

                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (firstTurn) {
                        threadWait();
                    }

                    System.out.println("2");
                    firstTurn = true;
                    lock.notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
    }
    private static void threadWait() {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}