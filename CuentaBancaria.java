import java.util.*;

public class CuentaBancaria {
    // Constante
    public static final double Saldo_Inicial_Minimo = 0.0;

    // Atributos estáticos
    private static int totalCuentas = 0;
    private static int proximoId = 1;

    // Colección estática para reporte global
    private static List<CuentaBancaria> registroCuentas = new ArrayList<>();

    // Atributos de instancia
    private final int id;
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.id = proximoId++;
        this.titular = titular;
        this.saldo = Math.max(saldoInicial, Saldo_Inicial_Minimo);
        totalCuentas++;
        registroCuentas.add(this);
    }

    public static int obtenerTotalCuentas() {
        return totalCuentas;
    }

    public static int obtenerProximoId() {
        return proximoId;
    }

    public static void reporteGlobal() {
        System.out.println("------- REPORTE DE CUENTAS ----------");
        System.out.printf("%-5s %-20s %-10s%n", "ID", "Titular", "Saldo");
        System.out.println("------------------------------------");
        for (CuentaBancaria c : registroCuentas) {
            System.out.printf("%-5d %-20s $%-10.2f%n", c.id, c.titular, c.saldo);
        }
        System.out.println("------------------------------------");
        System.out.println("Total de cuentas creadas: " + totalCuentas);
        System.out.println("Proximo ID a asignar: " + proximoId + "\n");
    }

    public static void main(String[] args) {
        
        new CuentaBancaria("Diana Bruno", 1500.0);
        new CuentaBancaria("Ilse Dimas", 2300.50);
        new CuentaBancaria("Harry Calixto", 500.0);
        new CuentaBancaria("Ana Torres", 12000.75);
        new CuentaBancaria("David Martinez", 340.0);

        CuentaBancaria.reporteGlobal();
    }
}

