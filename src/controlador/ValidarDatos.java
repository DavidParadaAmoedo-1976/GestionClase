package controlador;

import java.util.Scanner;

public class ValidarDatos {
    public final Scanner sc;

    public ValidarDatos() {
        this.sc = new Scanner(System.in);
    }

    public int enteroCorrecto(String dato, int minInclusive, int maxInclusive) {

        int num = 0;
        boolean datoOk = false;

        while (!datoOk) {
            System.out.print(dato);
            String input = sc.nextLine();
            try {
                num = Integer.parseInt(input);
                if (num >= minInclusive && num <= maxInclusive) {
                    datoOk = true;
                } else {
                    System.out.println("El valor debe estar entre " + minInclusive + " y " + maxInclusive);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número válido.");
            }
        }
        return num;
    }

    public String leerNombre() {
        String nombre = "";
        try {
            do {
                System.out.println("Introduzca su nombre (mínimo 3 caracteres, solo letras y espacios):");
                nombre = sc.nextLine().trim();
            } while (nombre.length() < 3 || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
        } catch (Exception e) {
            System.out.println("Error al leer el nombre. Inténtelo nuevamente.");
        }
        return nombre;
    }

    public String leerDni() {
        String dni = "";
        try {
            do {
                System.out.println("Introduzca su DNI (8 números + 1 letra):");
                dni = sc.nextLine().trim();
            } while (!validarDni(dni));
        } catch (Exception e) {
            System.out.println("Error al leer el DNI. Inténtelo nuevamente.");
        }
        return dni;
    }

    private boolean validarDni(String dni) {
        return dni.matches("[0-9]{8}[A-Za-z]");


//        try {
//            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
//            int numero = Integer.parseInt(dni.substring(0, 8));
//            char letraCorrecta = letras.charAt(numero % 23);
//            return dni.charAt(8) == letraCorrecta;
//        } catch (NumberFormatException e) {
//            System.out.println("Error en formato del DNI.");
//            return false;
//        }
    }

    public boolean leerBooleano(String dato) {
        boolean datoOk = false;
        String input = "";

        while (!datoOk) {
            System.out.println("Introduzca " + dato);
            System.out.println("S|s o N|n");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("S") || input.equalsIgnoreCase("N")) {
                datoOk = true;
            } else {
                System.out.println("Error: Introduzca S o N correctamente.");
            }
        }
        return input.equalsIgnoreCase("S");
    }
}
