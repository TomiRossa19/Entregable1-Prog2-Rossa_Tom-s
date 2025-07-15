package org.example.logica;

public class PaypalPaymentProcessor extends PaymentProcessor{
    public PaypalPaymentProcessor(PayPalPaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public boolean processPayment(float amount) {
        if(paymentGateway.authorize(amount)){
            paymentGateway.capture(amount);
            return true;
        }
        return false;
    }
    @Override
    public boolean refundPayment(float amount){
        // Supongamos que el pago ya fue hecho en otro momento
        if(paymentGateway.refund(amount)){
            return true;
        }
        return false;
    }
}
