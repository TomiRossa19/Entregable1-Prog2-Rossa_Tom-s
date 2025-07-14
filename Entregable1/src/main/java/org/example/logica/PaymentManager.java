package org.example.logica;

import org.example.logica.enums.ProveedorEnum;

public class PaymentManager {
    public void processPayment(float amount, ProveedorEnum provider){
        switch (provider){
            case MercadoPago:
                MercadoPagoPaymentProcessor mercadoPagoPaymentProcessor = new MercadoPagoPaymentProcessor();
                mercadoPagoPaymentProcessor.processPayment(amount);
            case PayPal:
                PaypalPaymentProcessor paypalPaymentProcessor = new PaypalPaymentProcessor();
                paypalPaymentProcessor.processPayment(amount);
        }
    }
}
