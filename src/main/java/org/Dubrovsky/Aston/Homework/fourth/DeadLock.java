package org.Dubrovsky.Aston.Homework.fourth;

public class DeadLock {
    private final ThreadTools tools = new ThreadTools();

    public void invoke(Object lock1, Object lock2) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1 захватил lock1");

                tools.sleep();

                synchronized (lock2) {
                    System.out.println("Поток 1 захватил lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2 захватил lock2");

                tools.sleep();

                synchronized (lock1) {
                    System.out.println("Поток 2 захватил lock1");
                }
            }
        });

        tools.threadStarter(t1, t2);
    }
}
