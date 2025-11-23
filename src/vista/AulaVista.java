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

/*
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
*/

    public void mostrarClase(AlumnoDTO[] alumnos) {
        if (alumnos == null || alumnos.length == 0) {
            mostrarListaVacia();
        } else {
            final String ROJO = "\u001B[31m";
            final String RESET = "\u001B[0m";
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] != null) {
                    if (alumnos[i].isEstaEnClase()) {
                        System.out.printf("\n" + (i + 1) + "-\t " + "%-25s, con DNI: %-10s  Nacido en: %-4d", alumnos[i].getNombreCompleto(),
                                alumnos[i].getDni(), alumnos[i].getAnioNacimiento());
                    } else {
                        System.out.printf("\n" + (i + 1) + "-\t " + ROJO + "%-25s, con DNI: %-10s  Nacido en: %-4d" + RESET, alumnos[i].getNombreCompleto(),
                                alumnos[i].getDni(), alumnos[i].getAnioNacimiento());
                    }
                }
            }
        }
    }

    public boolean pasarlista() {
        boolean alumnoEsta = entrada.leerBooleano("si este alumno esta en clase");
        return alumnoEsta;
    }

//          Mensajes    

    public void mostrarSalida() {
        System.out.println("Saliendo...");
    }

    public void mostrarCreado(AlumnoDTO alumno) {
        System.out.println("Alumno añadido.- " + alumno.getNombreCompleto() +
                " con DNI: " + alumno.getDni() +
                " Y nacido en el año " + alumno.getAnioNacimiento());
    }

    public void mostrarErrAulaLlena() {
        System.err.println("Aula llena, no podemos añadir más alumnos");
    }

    public void mostrarMensajeAlumnosPrueba(int contadorArray) {
        System.out.println("Creados " + contadorArray + " alumnos de prueba.");
    }

    public void mostrarAlumnosEncontrados(int contador, AlumnoDTO[] alumnosEncontrados) {
        System.out.println("Con la parte parcial de ese nombre me aparecen:\n");
        if (contador == 0) {
            System.out.println("No se han encontrado alumnos");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(alumnosEncontrados[i].getNombreCompleto() +
                        " con DNI: " + alumnosEncontrados[i].getDni() +
                        " Y nacido en el año " + alumnosEncontrados[i].getAnioNacimiento());
            }
        }
    }

    public void mostrarAlumnoDni(AlumnoDTO alumno) {
        System.out.println("Con el DNI.- " + alumno.getDni().toUpperCase() + " está:  " + alumno.getNombreCompleto() +
                ", nacido en el año " + alumno.getAnioNacimiento());
    }

    public void mostrarNoEncontrado(String dni) {
        System.out.println("El DNI: " + dni + " no corresponde a ningún alumno.");
    }

    public void mostrarFinlista() {
        System.out.println("Lista terminada.");
    }

    public void mostrarListaVacia() {
        System.out.println("No hay ningún alumno en la lista.");
    }

    public void mostrarAlumnoEliminado(AlumnoDTO alumno) {
        System.out.println("Se va eliminar a : " + alumno.getNombreCompleto() + " de la lista.");
    }
}
