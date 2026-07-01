package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.PaypalApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.StripeApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.TBankApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters.PaypalAdapter;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters.StripeAdapter;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters.TBankAdapter;

import java.util.Map;
import java.util.NoSuchElementException;

public class PaymentStrategyFactory {

    private static Map<PaymentType, PaymentStrategy> choiceToStrategy = Map.of(
            PaymentType.STRIPE, new StripeAdapter(new StripeApi()),
            PaymentType.PAYPAL, new PaypalAdapter(new PaypalApi()),
            PaymentType.TBANK, new TBankAdapter(new TBankApi())
    );

    public static PaymentStrategy fromValue(PaymentType type) throws NoSuchElementException {
        if (!choiceToStrategy.containsKey(type)) {
            throw new NoSuchElementException();
        }
        return choiceToStrategy.get(type);
    }
}