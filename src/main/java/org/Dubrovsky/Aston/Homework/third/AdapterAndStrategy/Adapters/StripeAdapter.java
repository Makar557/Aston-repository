package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters;

import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.StripeApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.PaymentStrategy;

import java.math.BigDecimal;

public class StripeAdapter implements PaymentStrategy {

    private final StripeApi stripeApi;

    public StripeAdapter(StripeApi stripeApi) {
        this.stripeApi = stripeApi;
    }

    @Override
    public void pay(BigDecimal amount) {
        stripeApi.makePayment(amount);
    }
}
