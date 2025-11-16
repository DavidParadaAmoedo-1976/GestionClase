package vista;

import controlador.ValidarDatos;
import modelo.AlumnoDTO;

import java.util.Scanner;

public class AulaVista {

    ValidarDatos entrada;

    public AulaVista(ValidarDatos entrada) {
        this.entrada = entrada;
    }


    public void mostrarMenu() {
        Scanner pausa = new Scanner(System.in);
        pausa.nextLine();
        System.out.println("""
                \n
                    *** Menú de opciones ***
                1.- Añadir alumnos al aula
                2.- Eliminar alumnos del aula.
                3.- Buscar alumnos por nombre parcial.
                4.- Buscar alumnos por dni.
                5.- Pasar lista.
                6.- Mostrar clase.
                0.- Salir.
                """);
    }

    public int solicitarMenu() {

        int opcion = entrada.enteroCorrecto("Elije una opción: ", 0, 6);
        return opcion;
    }

    public AlumnoDTO obtenerDatosAlumno() {
        AlumnoDTO alumnoRetorno;
        String nombre = entrada.leerNombre();
        String dni = entrada.leerDni();
        int nacimiento = entrada.enteroCorrecto("Introduce el año de nacimiento: ", 1900, 2025);
        alumnoRetorno = new AlumnoDTO(nombre, dni, nacimiento);
        return alumnoRetorno;
    }

    public String obtenerDni() {
        String dni = entrada.leerDni();
        return dni;
    }

    public String obtenerNombreParcial() {
        String nombreParcial = entrada.leerNombre();
        return nombreParcial;
    }

    public void mostrarClase(AlumnoDTO[] alumnos) {

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                if (alumnos[i].isEstaEnClase()) {
                    System.out.printf("\n%-25s, con DNI: %-10s  Nacido en: %-4d", alumnos[i].getNombreCompleto(),
                            alumnos[i].getDni(), alumnos[i].getAnioNacimiento());
                } else {
                    System.err.printf("\n%-25s, con DNI: %-10s  Nacido en: %-4d", alumnos[i].getNombreCompleto(),
                            alumnos[i].getDni(), alumnos[i].getAnioNacimiento());
                }
            }
        }
    }
    /*    public void mostrarClase(AlumnoDTO[] alumnos) {
        final String ROJO = "\u001B[31m";
        final String RESET = "\u001B[0m";
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                if (alumnos[i].isEstaEnClase()) {
                    System.out.printf("\n" + (i+1) + ".- " + "%-25s, con DNI: %-10s  Nacido en: %-4d", alumnos[i].getNombreCompleto(),
                            alumnos[i].getDni(), alumnos[i].getAnioNacimiento());
                } else {
                    System.out.printf("\n" + (i+1) + ".- " + ROJO + "%-25s, con DNI: %-10s  Nacido en: %-4d" + RESET, alumnos[i].getNombreCompleto(),
                            alumnos[i].getDni(), alumnos[i].getAnioNacimiento());
                }
            }
        }
    }

     */


    public boolean pasarlista() {
        boolean alumnoEsta = entrada.leerBooleano("si este alumno esta en clase");
        return alumnoEsta;
    }
}
