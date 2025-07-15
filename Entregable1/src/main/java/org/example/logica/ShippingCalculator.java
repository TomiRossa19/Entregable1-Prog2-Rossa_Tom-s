package org.example.logica;

import java.util.concurrent.CompletableFuture;

public class ShippingCalculator {
    public float peso;
    public float dimensiones;
    public String origen;
    public String destino;
    public ShippingStrategy shippingStrategy;

    public ShippingCalculator(float dimensiones, float peso, String origen, String destino, ShippingStrategy shippingStrategy) {
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.origen = origen;
        this.destino = destino;
        this.shippingStrategy = shippingStrategy;
    }
    public CompletableFuture<Float> calculateCostAsync() {
        return CompletableFuture.supplyAsync(() -> calculateCost());
    }
    public float calculateCost(){
        return shippingStrategy.calculateCost(peso, dimensiones, origen, destino);
    }
}
