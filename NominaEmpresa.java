import java.util.Locale;

abstract class Empleado {
    protected int id;
    protected String nombre;
    protected String cedula;
    protected double sueldoBase;

    protected static int totalEmpleados = 0;
    protected static int proximoId = 1001;

    public Empleado(String nombre, String cedula, double sueldoBase) {
        this.id = proximoId++;
        this.nombre = nombre;
        this.cedula = cedula;
        this.sueldoBase = sueldoBase;
        totalEmpleados++;
    }

    public abstract double calcularSueldo();
    public abstract String obtenerDetalles();

    public static int obtenerTotalEmpleados() {
        return totalEmpleados;
    }

    public static void mostrarEstadisticas(Empleado[] empleados) {
        double gastoTotal = 0;
        System.out.println("============================================================================================");
        System.out.println("                   REPORTE GENERAL DE NOMINA                  ");
        System.out.println("============================================================================================");

        for (Empleado e : empleados) {
            if (e != null) {
                System.out.println(e.obtenerDetalles());
                gastoTotal += e.calcularSueldo();
            }
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf(Locale.US, "Gasto Total Acumulado en Nomina: $%.2f%n", gastoTotal);
        System.out.println("Numero Total de Trabajadores Registrados: " + obtenerTotalEmpleados());
        System.out.println("============================================================================================");
    }
}

class Obrero extends Empleado {
    public Obrero(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase;
    }

    @Override
    public String obtenerDetalles() {
        return String.format(Locale.US, "ID: %d | Nombre: %-20s | Puesto: Obrero     | Sueldo Final: $%.2f",
                id, nombre, calcularSueldo());
    }
}

class Supervisor extends Empleado {
    private static final double BONIFICACION = 200.00;

    public Supervisor(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase + BONIFICACION;
    }

    @Override
    public String obtenerDetalles() {
        return String.format(Locale.US, "ID: %d | Nombre: %-20s | Puesto: Supervisor | Sueldo Final: $%.2f",
                id, nombre, calcularSueldo());
    }
}

class Gerente extends Empleado {
    private static final double BONIFICACION = 500.00;

    public Gerente(String nombre, String cedula, double sueldoBase) {
        super(nombre, cedula, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        return this.sueldoBase + BONIFICACION;
    }

    @Override
    public String obtenerDetalles() {
        return String.format(Locale.US, "ID: %d | Nombre: %-20s | Puesto: Gerente    | Sueldo Final: $%.2f",
                id, nombre, calcularSueldo());
    }
}

public class NominaEmpresa {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[8];

        empleados[0] = new Gerente("Fernando Ruiz", "44556677", 4800.00);
        empleados[1] = new Gerente("Patricia Vega", "88990011", 5200.00);

        empleados[2] = new Supervisor("Gabriel Mendoza", "22334455", 2900.00);
        empleados[3] = new Supervisor("Lorena Rios", "66778899", 3100.00);

        empleados[4] = new Obrero("Miguel Angel Torres", "11224433", 1450.00);
        empleados[5] = new Obrero("Sofia Escalante", "55667788", 1500.00);
        empleados[6] = new Obrero("Daniel Gutierrez", "99001122", 1400.00);
        empleados[7] = new Obrero("Valeria Morales", "33445566", 1600.00);

        Empleado.mostrarEstadisticas(empleados);
    }
}