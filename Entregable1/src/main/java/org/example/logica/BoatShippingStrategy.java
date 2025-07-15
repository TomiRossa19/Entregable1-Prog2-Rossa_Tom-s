package org.example.logica;

public class BoatShippingStrategy implements ShippingStrategy{
    @Override
    public float calculateCost(float peso, float dimensiones, String origen, String destino) {
        return peso * dimensiones * 1.0f + 20;
    }
}
