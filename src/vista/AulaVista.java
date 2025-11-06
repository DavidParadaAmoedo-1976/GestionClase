package vista;

import controlador.ValidarDatos;
import modelo.AlumnoDTO;

public class AulaVista {

    ValidarDatos entrada;

    public AulaVista(ValidarDatos entrada) {
        this.entrada = entrada;
    }


    public void mostrarMenu() {
        System.out.println("""
                \n\t*** Menú de opciones ***
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
                    System.out.println((i + 1) + ".- " + alumnos[i].getNombreCompleto()
                            + " con DNI " + alumnos[i].getDni() + " nacido en " + alumnos[i].getAnioNacimiento());
                } else {
                    System.err.println((i + 1) + ".- " + alumnos[i].getNombreCompleto()
                            + " con DNI " + alumnos[i].getDni() + " nacido en " + alumnos[i].getAnioNacimiento());
                }
            }
        }
    }
}
