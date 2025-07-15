import org.example.logica.PaymentManager;
import org.example.logica.enums.ProveedorEnum;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import org.example.logica.*;
import org.example.logica.enums.ProveedorEnum;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentManager manager = new PaymentManager();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Procesador de Pagos ===");

            try {
                // Datos para el pago
                System.out.print("Ingrese el monto a pagar: ");
                float amount = Float.parseFloat(scanner.nextLine());

                System.out.print("Seleccione el proveedor (MercadoPago / PayPal): ");
                String proveedorStr = scanner.nextLine().trim();
                ProveedorEnum proveedor = parseProveedor(proveedorStr);

                // Iniciar pago asincrónico
                CompletableFuture<Boolean> pagoFuturo = manager.processPaymentAsync(amount, proveedor);

                // Datos para el reembolso
                System.out.print("Ingrese el monto a reembolsar: ");
                float amountR = Float.parseFloat(scanner.nextLine());

                System.out.print("Seleccione el proveedor (MercadoPago / PayPal): ");
                String proveedorStrR = scanner.nextLine().trim();
                ProveedorEnum proveedorR = parseProveedor(proveedorStrR);

                // Iniciar reembolso asincrónico
                CompletableFuture<Boolean> reembolsoFuturo = manager.refundPaymentAsync(amountR, proveedorR);

                // Datos para el envío
                System.out.println("\n=== Cálculo de Costo de Envío ===");
                System.out.print("Peso del paquete (kg): ");
                float peso = Float.parseFloat(scanner.nextLine());

                System.out.print("Dimensiones (m3): ");
                float dimensiones = Float.parseFloat(scanner.nextLine());

                System.out.print("Origen: ");
                String origen = scanner.nextLine();

                System.out.print("Destino: ");
                String destino = scanner.nextLine();

                System.out.print("Seleccione el medio de envío (air / truck / boat): ");
                String estrategia = scanner.nextLine().trim().toLowerCase();

                ShippingStrategy strategy;
                switch (estrategia) {
                    case "air":
                        strategy = new AirShippingStrategy();
                        break;
                    case "truck":
                        strategy = new TruckShippingStrategy();
                        break;
                    case "boat":
                        strategy = new BoatShippingStrategy();
                        break;
                    default:
                        System.out.println("Estrategia no válida.");
                        continue;
                }

                // Iniciar cálculo de envío asincrónico
                ShippingCalculator calculator = new ShippingCalculator(peso, dimensiones, origen, destino, strategy);
                CompletableFuture<Float> costoFuturo = calculator.calculateCostAsync();

                // Esperar resultados de forma concurrente
                boolean pagoExitoso = pagoFuturo.get();
                boolean reembolsoExitoso = reembolsoFuturo.get();
                float costoEnvio = costoFuturo.get();

                // Mostrar resultados
                System.out.println(pagoExitoso ? "Pago realizado con éxito." : "Monto fuera de rango.");
                System.out.println(reembolsoExitoso ? "Reembolso realizado con éxito." : "No se pudo realizar el reembolso.");
                System.out.println("Costo estimado de envío: $" + costoEnvio);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("¿Desea realizar otra operación? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    private static ProveedorEnum parseProveedor(String input) {
        return ProveedorEnum.valueOf(
                input.toLowerCase().replace("mercadopago", "MercadoPago").replace("paypal", "PayPal")
        );
    }
}



