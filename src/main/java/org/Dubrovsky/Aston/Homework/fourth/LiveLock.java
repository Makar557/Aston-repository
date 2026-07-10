package org.Dubrovsky.Aston.Homework.fourth;

import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final ThreadTools tools = new ThreadTools();

    public void invoke(ReentrantLock lock1, ReentrantLock lock2) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Поток 1 захватил lock1");

                        tools.sleep();

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

                        tools.sleep();

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

        tools.threadStarter(t1, t2);
    }
}
