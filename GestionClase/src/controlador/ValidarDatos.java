package controlador;

import java.util.Scanner;

public class ValidarDatos {
    static Scanner sc =new Scanner(System.in);

    public static int enteroCorrecto(String dato, int minInclusive, int maxInclusive) {

        int num = 0;
        boolean datoOk = false;

        while (!datoOk) {
            System.out.println(dato);
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

    public static String leerNombre() {
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

    public static String leerDni() {
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

    private static boolean validarDni(String dni) {
        if (!dni.matches("[0-9]{8}[A-Z]")) return false;


//        try {
//            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
//            int numero = Integer.parseInt(dni.substring(0, 8));
//            char letraCorrecta = letras.charAt(numero % 23);
//            return dni.charAt(8) == letraCorrecta;
//        } catch (NumberFormatException e) {
//            System.out.println("Error en formato del DNI.");
//            return false;
//        }
        return true;
    }
}
