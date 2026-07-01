package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import java.util.Arrays;

public enum PaymentType {
    EXIT("0"),
    STRIPE("1"),
    PAYPAL("2"),
    TBANK("3");

    private final String value;

    PaymentType(String value) {
        this.value = value;
    }

    public static PaymentType fromValue(String value) {
        return Arrays.stream(PaymentType.values())
                .filter(chose -> chose.value.equals(value))
                .findFirst().orElseThrow(
                () -> new IllegalArgumentException("Неизвестный тип оплаты: " + value));
    }

}