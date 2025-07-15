package org.example.logica;

public abstract class PaymentProcessor {
    public PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public abstract boolean processPayment(float amount);
    public abstract boolean refundPayment(float amount);
}
