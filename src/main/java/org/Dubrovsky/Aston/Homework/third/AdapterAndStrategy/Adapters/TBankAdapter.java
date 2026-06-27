package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters;

import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.TBankApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.PaymentStrategy;

public class TBankAdapter implements PaymentStrategy {

    private final TBankApi tBankApi;

    public TBankAdapter(TBankApi tBankApi) {
        this.tBankApi = tBankApi;
    }

    @Override
    public void pay(double amount) {

        long kopeck = (long) amount;

        tBankApi.createTransaction(kopeck);
    }
}
