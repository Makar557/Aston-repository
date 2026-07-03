package org.Dubrovsky.Aston.Homework.fourth;

import java.util.concurrent.locks.ReentrantLock;

public class LiveLockDemo {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Поток 1 захватил lock1");

                        sleep();

                        if (lock2.tryLock()) {
                            try {
                                System.out.println("Поток 1 выполнил работу");
                                break;
                            } finally {
                                lock2.unlock();
                            }
                        }

                        System.out.println("Поток 1 уступил");

                    } finally {
                        lock1.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Поток 2 захватил lock2");

                        sleep();

                        if (lock1.tryLock()) {
                            try {
                                System.out.println("Поток 2 выполнил работу");
                                break;
                            } finally {
                                lock1.unlock();
                            }
                        }

                        System.out.println("Поток 2 уступил");

                    } finally {
                        lock2.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}