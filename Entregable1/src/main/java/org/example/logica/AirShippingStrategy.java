package org.example.logica;

public class AirShippingStrategy implements ShippingStrategy{
    @Override
    public float calculateCost(float peso, float dimensiones, String origen, String destino) {
        return peso * dimensiones * 2.5f + 50;
    }
}
