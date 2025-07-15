package org.example.logica;

public class MercadoPagoPaymentGateway implements PaymentGateway{

    @Override
    public boolean authorize(float amount) {
        if(amount > 0 && amount < 2000000)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean capture(float amount) {
        System.out.println("[MercadoPago] Capturando $" + amount);
        return true;
    }

    @Override
    public boolean refund(float amount) {
        if(amount > 0 && amount < 2000000)
        {
            return true;
        }
        return false;
    }
}
