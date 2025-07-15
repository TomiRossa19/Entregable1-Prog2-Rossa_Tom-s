import org.example.logica.PaymentManager;
import org.example.logica.enums.ProveedorEnum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentManager manager = new PaymentManager();

        System.out.println("=== Procesador de Pagos ===");

        try {
            // Leer monto
            System.out.print("Ingrese el monto a pagar: ");
            float amount = Float.parseFloat(scanner.nextLine());

            // Leer proveedor
            System.out.print("Seleccione el proveedor (MercadoPago / PayPal): ");
            String proveedorStr = scanner.nextLine().trim();

            ProveedorEnum proveedor = parseProveedor(proveedorStr);

            // Procesar el pago
            if(manager.processPayment(amount, proveedor)){
                System.out.println("Pago realizado con éxito");
            }else {
                System.out.println("monto fuera de rango");
            };

            // Reembolso
            System.out.print("Ingrese el monto a reembolsar: ");
            float amountR = Float.parseFloat(scanner.nextLine());

            System.out.print("Seleccione el proveedor (MercadoPago / PayPal): ");
            String proveedorStrR = scanner.nextLine().trim();
            ProveedorEnum proveedorR = parseProveedor(proveedorStrR);

            // Reembolsar
            if(manager.processPayment(amount, proveedor)){
                System.out.println("Reembolso realizado con éxito");
            }else {
                System.out.println("monto fuera de rango");
            };

        }catch (Exception e) {
            System.out.println("Error al procesar el pago: " + e.getMessage());
        }

        scanner.close();
    }

    private static ProveedorEnum parseProveedor(String input) {
        return ProveedorEnum.valueOf(
                input.toLowerCase().replace("mercadopago", "MercadoPago").replace("paypal", "PayPal")
        );
    }
}

