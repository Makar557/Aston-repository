package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.PaypalApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.StripeApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs.TBankApi;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters.PaypalAdapter;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters.StripeAdapter;
import org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.Adapters.TBankAdapter;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(PaymentType type) {

        return switch (type) {
            case STRIPE -> new StripeAdapter(new StripeApi());

            case PAYPAL -> new PaypalAdapter(new PaypalApi());

            case TBANK -> new TBankAdapter(new TBankApi());
        };
    }
}
