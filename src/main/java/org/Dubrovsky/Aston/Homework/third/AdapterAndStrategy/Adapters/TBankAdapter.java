package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters;

import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.TBankApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.PaymentStrategy;

import java.math.BigDecimal;

public class TBankAdapter implements PaymentStrategy {

    private final TBankApi tBankApi;

    public TBankAdapter(TBankApi tBankApi) {
        this.tBankApi = tBankApi;
    }

    @Override
    public void pay(BigDecimal amount) {

        BigDecimal kopeck = amount;

        tBankApi.createTransaction(kopeck);
    }
}
