package org.Dubrovsky.Aston.Homework.fourth;

public class ThreadTools {

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
}