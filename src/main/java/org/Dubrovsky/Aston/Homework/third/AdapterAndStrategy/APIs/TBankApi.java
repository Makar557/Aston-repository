package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs;

import java.math.BigDecimal;

public class TBankApi {

    public void createTransaction(BigDecimal amountInCents) {

        System.out.println("Т-Банк: операция на " + amountInCents + " копеек");
    }
}
