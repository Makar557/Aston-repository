package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy.APIs;

public class TBankApi {

    public void createTransaction(long amountInCents) {

        System.out.println("Т-Банк: операция на " + amountInCents + " копеек");
    }
}
