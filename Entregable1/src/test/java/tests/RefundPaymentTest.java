package tests;

import org.example.logica.PaymentManager;
import org.example.logica.enums.ProveedorEnum;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefundPaymentTest {
    private PaymentManager paymentManager = new PaymentManager();
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund_conAsync() throws Exception {
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.refundPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund_conAsync1() throws Exception {
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.refundPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund_conAsync2() throws Exception {
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.refundPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund_conAsync3() throws Exception {
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.refundPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund_conAsync4() throws Exception {
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.refundPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund_conAsync5() throws Exception {
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        CompletableFuture<Boolean> resultadoFuturo = paymentManager.refundPaymentAsync(amount, proveedor);
        boolean resultado = resultadoFuturo.get();

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund(){
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        boolean resultado = paymentManager.refundPayment(amount, proveedor);

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund1(){
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        boolean resultado = paymentManager.refundPayment(amount, proveedor);

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund2(){
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.MercadoPago;

        boolean resultado = paymentManager.refundPayment(amount, proveedor);

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund3(){
        float amount = 200;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        boolean resultado = paymentManager.refundPayment(amount, proveedor);

        assertTrue(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund4(){
        float amount = 0;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        boolean resultado = paymentManager.refundPayment(amount, proveedor);

        assertFalse(resultado);
    }
    @Test
    public void testQueElMontoEsteDentroDelRangoParaRefund5(){
        float amount = 5000000;
        ProveedorEnum proveedor = ProveedorEnum.PayPal;

        boolean resultado = paymentManager.refundPayment(amount, proveedor);

        assertFalse(resultado);
    }
}
