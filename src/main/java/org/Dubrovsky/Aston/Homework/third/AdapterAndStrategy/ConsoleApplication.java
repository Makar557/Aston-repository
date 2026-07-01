package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleApplication {

    CheckoutService checkoutService = new CheckoutService();
    MenuService menuService = new MenuService();

    public void run() {

        while (true) {
            PaymentType type = menuService.choosePaymentType();

            if (type == PaymentType.EXIT) {
                System.out.println("Выход...");
                break;
            }

            PaymentStrategy strategy = PaymentStrategyFactory.fromValue(type);

            checkoutService.setPaymentStrategy(strategy);

            BigDecimal amount;
            try {
                amount = menuService.readAmount();
            } catch (NumberFormatException e) {
                System.out.println("попробуйте еще раз");
                continue;
            }

            checkoutService.checkout(amount);
        }
    }
}
