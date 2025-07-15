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
        //Acá iría la lógica que descuenta el dinero de la cuenta del usuario y crea un nuevo pago
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
