package org.Dubrovsky.Aston.Homework.fourth;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTools {

    private boolean firstTurn = true;

    public void threadWait(Object lock) {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void threadStarter(Thread... threds) {
        for (Thread threads : threds) {
            threads.start();
        }

        for (Thread threads : threds) {
            try {
                threads.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void makeDeadlock(Object lock1, Object lock2) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1 захватил lock1");

                sleep();

                synchronized (lock2) {
                    System.out.println("Поток 1 захватил lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2 захватил lock2");

                sleep();

                synchronized (lock1) {
                    System.out.println("Поток 2 захватил lock1");
                }
            }
        });

        threadStarter(t1, t2);
    }

    public void makeLiveLock(ReentrantLock lock1, ReentrantLock lock2) {

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

        threadStarter(t1, t2);
    }

    public void printOneAndTwo(Object lock) {

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (!firstTurn) {
                        threadWait(lock);
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
                        threadWait(lock);
                    }

                    System.out.println("2");
                    firstTurn = true;
                    lock.notifyAll();
                }
            }
        });

        threadStarter(t1, t2);
    }
}