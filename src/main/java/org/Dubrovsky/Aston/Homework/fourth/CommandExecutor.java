package org.Dubrovsky.Aston.Homework.fourth;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class CommandExecutor {

    private final DeadLock dead = new DeadLock();
    private final LiveLock live = new LiveLock();
    private final OneAndTwoPrinter oneAndTwo = new OneAndTwoPrinter();

    private final Object deadlockLockA = new Object();
    private final Object deadlockLockB = new Object();

    private final ReentrantLock livelockLockA = new ReentrantLock();
    private final ReentrantLock livelockLockB = new ReentrantLock();

    private final Map<Commands, Runnable> commands = Map.of(
            Commands.makeDL, () -> dead.invoke(deadlockLockA, deadlockLockB),
            Commands.makeLL, () -> live.invoke(livelockLockA, livelockLockB),
            Commands.printOneAndTwo, () -> oneAndTwo.invoke(deadlockLockA));

    public void getMethod(String chose) {

        Runnable command;
        try {
            command = commands.get(Commands.getCommands(chose));
        } catch (IllegalArgumentException e) {
            return;
        }
        command.run();
    }
}
