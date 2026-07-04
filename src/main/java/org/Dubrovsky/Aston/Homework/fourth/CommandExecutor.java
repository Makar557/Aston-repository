package org.Dubrovsky.Aston.Homework.fourth;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class CommandExecutor {

    private final ThreadTools tools = new ThreadTools();

    private final Object deadlockLockA = new Object();
    private final Object deadlockLockB = new Object();

    private final ReentrantLock livelockLockA = new ReentrantLock();
    private final ReentrantLock livelockLockB = new ReentrantLock();

    private final Map<String, Runnable> commands = Map.of(
            "makeDL", () -> tools.makeDeadlock(deadlockLockA, deadlockLockB),
            "makeLL", () -> tools.makeLiveLock(livelockLockA, livelockLockB),
            "printOneAndTwo", () -> tools.printOneAndTwo(deadlockLockA));

    public void getMethod(String chose) {
        if (commands.get(chose) == null) {
            System.out.println("Неизвестная команда");
            return;
        }
        commands.get(chose).run();
    }
}
