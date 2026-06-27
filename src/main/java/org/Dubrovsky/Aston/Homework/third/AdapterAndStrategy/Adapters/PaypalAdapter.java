package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters;

import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.PaypalApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.PaymentStrategy;

public class PaypalAdapter implements PaymentStrategy {

    private final PaypalApi paypalApi;

    public PaypalAdapter(PaypalApi paypalApi) {
        this.paypalApi = paypalApi;
    }

    @Override
    public void pay(double amount) {
        paypalApi.sendMoney("USD", amount);
    }
}