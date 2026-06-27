package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

public class CheckoutService {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {

        paymentStrategy.pay(amount);

        System.out.println("Заказ оформлен");
    }
}