package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CheckoutService checkout = new CheckoutService();

        while (true) {

            System.out.println("\nВыберите способ оплаты:");
            System.out.println("1 - STRIPE");
            System.out.println("2 - PAYPAL");
            System.out.println("3 - TBANK");
            System.out.println("0 - выход");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Выход...");
                break;
            }

            PaymentType type = switch (choice) {
                case 1 -> PaymentType.STRIPE;
                case 2 -> PaymentType.PAYPAL;
                case 3 -> PaymentType.TBANK;
                default -> null;
            };

            if (type == null) {
                System.out.println("Неверный выбор");
                continue;
            }

            System.out.print("Введите сумму: ");
            double amount = scanner.nextDouble();

            PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(type);

            checkout.setPaymentStrategy(strategy);

            checkout.checkout(amount);
        }

        scanner.close();
    }
}