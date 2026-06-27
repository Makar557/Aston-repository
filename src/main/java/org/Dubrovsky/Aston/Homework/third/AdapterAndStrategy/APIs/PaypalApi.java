package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs;

public class PaypalApi {

    public void sendMoney(String currency, double amount) {
        System.out.println("PayPal: отправлено " + amount + " " + currency);
    }
}
