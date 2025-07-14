package org.example.logica;

public interface PaymentGateway {
    boolean authorize(float amount);
    boolean capture(float amount);
    boolean refund(float amount);
}
