package org.example.logica;

public class TruckShippingStrategy implements ShippingStrategy{
    @Override
    public float calculateCost(float peso, float dimensiones, String origen, String destino) {
        return peso * dimensiones * 1.2f;
    }
}
