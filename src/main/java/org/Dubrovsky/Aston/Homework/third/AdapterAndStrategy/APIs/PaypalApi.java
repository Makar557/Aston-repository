package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs;

import java.math.BigDecimal;

public class PaypalApi {

    public void sendMoney(String currency, BigDecimal amount) {
        System.out.println("PayPal: отправлено " + amount + " " + currency);
    }
}
