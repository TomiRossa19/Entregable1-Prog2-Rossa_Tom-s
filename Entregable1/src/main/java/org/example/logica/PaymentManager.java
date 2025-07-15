package org.example.logica;

import org.example.logica.enums.ProveedorEnum;

public class PaymentManager {
    public boolean processPayment(float amount, ProveedorEnum provider){
        switch (provider){
            case MercadoPago:
                MercadoPagoPaymentProcessor mercadoPagoPaymentProcessor = new MercadoPagoPaymentProcessor(new MercadoPagoPaymentGateway());
                return mercadoPagoPaymentProcessor.processPayment(amount);
            case PayPal:
                PaypalPaymentProcessor paypalPaymentProcessor = new PaypalPaymentProcessor(new PayPalPaymentGateway());
                return paypalPaymentProcessor.processPayment(amount);
        }
        return false;
    }

    public boolean refundPayment(float amount, ProveedorEnum provider){
        switch (provider){
            case MercadoPago:
                MercadoPagoPaymentProcessor mercadoPagoPaymentProcessor = new MercadoPagoPaymentProcessor(new MercadoPagoPaymentGateway());
                return mercadoPagoPaymentProcessor.refundPayment(amount);
            case PayPal:
                PaypalPaymentProcessor paypalPaymentProcessor = new PaypalPaymentProcessor(new PayPalPaymentGateway());
                return paypalPaymentProcessor.refundPayment(amount);
        }
        return false;
    }
}

