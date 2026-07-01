package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuService {

    Scanner scanner = new Scanner(System.in);

    public PaymentType choosePaymentType() {

        while (true) {

            printMenu();

            String choice = scanner.nextLine();

            try {
                return PaymentType.fromValue(String.valueOf(choice));
            } catch (IllegalArgumentException e) {
                System.out.println("Попробуйте еще раз");
                continue;
            }
        }

    }

    public BigDecimal readAmount() throws NumberFormatException {

        System.out.print("Введите сумму: ");

        return new BigDecimal(scanner.nextLine());
    }

    public void printMenu() {
        System.out.println("\nВыберите способ оплаты:");
        System.out.println("1 - STRIPE");
        System.out.println("2 - PAYPAL");
        System.out.println("3 - TBANK");
        System.out.println("0 - выход");
    }

}
