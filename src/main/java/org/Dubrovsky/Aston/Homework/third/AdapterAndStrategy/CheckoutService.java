package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import java.math.BigDecimal;

public class CheckoutService {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(BigDecimal amount) {

        paymentStrategy.pay(amount);

        System.out.println("Заказ оформлен");
    }
}