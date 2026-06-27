package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs;

public class StripeApi {

    public void makePayment(double amount) {
        System.out.println("Stripe: списано " + amount + "$");
    }
}
