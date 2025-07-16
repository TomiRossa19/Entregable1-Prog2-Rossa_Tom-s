package tests;

import org.example.logica.AirShippingStrategy;
import org.example.logica.BoatShippingStrategy;
import org.example.logica.ShippingCalculator;
import org.example.logica.TruckShippingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

public class CalculateCostTest {
    @Test
    public void testCalculateCostTruck_ConAsync() throws Exception {
        ShippingCalculator shippingCalculator = new ShippingCalculator(20, 3, "Argentina", "Chile", new TruckShippingStrategy());
        CompletableFuture<Float> resultadoFuturo = shippingCalculator.calculateCostAsync();
        float resultado = resultadoFuturo.get();
        Assertions.assertEquals(resultado, 72);
    }
    @Test
    public void testCalculateCostAir_ConAsync() throws Exception {
        ShippingCalculator shippingCalculator = new ShippingCalculator(20, 3, "Argentina", "Chile", new AirShippingStrategy());
        CompletableFuture<Float> resultadoFuturo = shippingCalculator.calculateCostAsync();
        float resultado = resultadoFuturo.get();
        Assertions.assertEquals(resultado, 200);
    }
    @Test
    public void testCalculateCostBoat_ConAsync() throws Exception {
        ShippingCalculator shippingCalculator = new ShippingCalculator(20, 3, "Argentina", "Chile", new BoatShippingStrategy());
        CompletableFuture<Float> resultadoFuturo = shippingCalculator.calculateCostAsync();
        float resultado = resultadoFuturo.get();
        Assertions.assertEquals(resultado, 80);
    }
    @Test
    public void testCalculateCostTruck(){
        ShippingCalculator shippingCalculator = new ShippingCalculator(20, 3, "Argentina", "Chile", new TruckShippingStrategy());
        float resultado = shippingCalculator.calculateCost();
        Assertions.assertEquals(resultado, 72);
    }
    @Test
    public void testCalculateCostAir(){
        ShippingCalculator shippingCalculator = new ShippingCalculator(20, 3, "Argentina", "Chile", new AirShippingStrategy());
        float resultado = shippingCalculator.calculateCost();
        Assertions.assertEquals(resultado, 200);
    }
    @Test
    public void testCalculateCostBoat(){
        ShippingCalculator shippingCalculator = new ShippingCalculator(20, 3, "Argentina", "Chile", new BoatShippingStrategy());
        float resultado = shippingCalculator.calculateCost();
        Assertions.assertEquals(resultado, 80);
    }
}
