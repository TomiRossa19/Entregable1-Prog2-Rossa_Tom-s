package tests;

import org.example.logica.PaymentManager;
import org.example.logica.enums.ProveedorEnum;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessPaymentTest {
    private PaymentManager paymentManager = new PaymentManager();

    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment_conAsync() throws Exception {
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.processPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment_conAsync1() throws Exception {
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.processPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment_conAsync2() throws Exception {
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.processPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment_conAsync3() throws Exception {
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.processPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment_conAsync4() throws Exception {
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.processPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment_conAsync5() throws Exception {
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.processPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment(){
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        boolean resultado = paymentManager.processPayment(amount, proveedor);

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment1(){
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        boolean resultado = paymentManager.processPayment(amount, proveedor);

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment2(){
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        boolean resultado = paymentManager.processPayment(amount, proveedor);

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment3(){
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        boolean resultado = paymentManager.processPayment(amount, proveedor);

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment4(){
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        boolean resultado = paymentManager.processPayment(amount, proveedor);

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaPayment5(){
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        boolean resultado = paymentManager.processPayment(amount, proveedor);

        assertFalse(resultado);
    }
}
