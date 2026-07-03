package org.Dubrovsky.Aston.Homework.third.AdapterAndStrategy;

import java.math.BigDecimal;

public interface PaymentStrategy {
    void pay(BigDecimal amount);
}