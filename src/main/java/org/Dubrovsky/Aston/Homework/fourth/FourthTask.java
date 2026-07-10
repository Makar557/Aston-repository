package org.Dubrovsky.Aston.Homework.fourth;

import java.util.Scanner;

public class FourthTask {

    Scanner scanner = new Scanner(System.in);
    CommandExecutor commandExecutor = new CommandExecutor();

    public void startApp() {

        while (true) {
            System.out.println("makeDL - создает Deadlock");
            System.out.println("makeLL - создает LiveLock");
            System.out.println("printOneAndTwo - печатает 1 и 2 ");
            System.out.printf("Введите команду: ");
            String command = scanner.nextLine();
            commandExecutor.getMethod(command);
        }
    }
}