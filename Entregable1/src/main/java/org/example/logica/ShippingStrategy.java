package org.example.logica;

public interface ShippingStrategy {
    float calculateCost(float peso, float dimensiones, String origen, String destino);
}
