package org.example.logica;

import org.example.logica.enums.ProveedorEnum;

import java.util.concurrent.CompletableFuture;

public class PaymentManager {
    public CompletableFuture<Boolean> processPaymentAsync(float amount, ProveedorEnum provider) {
        return CompletableFuture.supplyAsync(() -> processPayment(amount, provider));
    }

    public CompletableFuture<Boolean> refundPaymentAsync(float amount, ProveedorEnum provider) {
        return CompletableFuture.supplyAsync(() -> refundPayment(amount, provider));
    }

    public boolean processPayment(float amount, ProveedorEnum provider){
        switch (provider){
            case MercadoPago:
                MercadoPagoPaymentProcessor mercadoPago = new MercadoPagoPaymentProcessor(new MercadoPagoPaymentGateway());
                return mercadoPago.processPayment(amount);
            case PayPal:
                PaypalPaymentProcessor paypal = new PaypalPaymentProcessor(new PayPalPaymentGateway());
                return paypal.processPayment(amount);
        }
        return false;
    }

    public boolean refundPayment(float amount, ProveedorEnum provider){
        switch (provider){
            case MercadoPago:
                MercadoPagoPaymentProcessor mercadoPago = new MercadoPagoPaymentProcessor(new MercadoPagoPaymentGateway());
                return mercadoPago.refundPayment(amount);
            case PayPal:
                PaypalPaymentProcessor paypal = new PaypalPaymentProcessor(new PayPalPaymentGateway());
                return paypal.refundPayment(amount);
        }
        return false;
    }
}

