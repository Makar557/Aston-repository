package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs;

import java.math.BigDecimal;

public class StripeApi {

    public void makePayment(BigDecimal amount) {
        System.out.println("Stripe: списано " + amount + "$");
    }
}
