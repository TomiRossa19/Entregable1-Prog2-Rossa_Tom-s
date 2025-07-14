package org.example.logica;

public abstract class PaymentProcessor {
    public PaymentGateway paymentGateway;
    public abstract void processPayment(float amount);
    public abstract void refundPayment();
}
