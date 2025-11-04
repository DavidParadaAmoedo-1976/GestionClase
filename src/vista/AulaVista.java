package vista;

import controlador.ValidarDatos;
import modelo.AlumnoDTO;

public class AulaVista {

    ValidarDatos entrada;

    public AulaVista(ValidarDatos entrada) {
        this.entrada = entrada;
    }

    public void mostrarClase(){

    }

    public void mostrarMenu(){
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

    public int solicitarMenu(){

        int opcion = entrada.enteroCorrecto("Elije una opción: ",0,6);
        return opcion;
    }

    public AlumnoDTO obtenerDatosAlumno(){
        AlumnoDTO alumnoRetorno;
        String nombre = entrada.leerNombre();
        String dni = entrada.leerDni();
        int nacimiento = entrada.enteroCorrecto("Introduce el año de nacimiento: ",1900,2025);
        alumnoRetorno = new AlumnoDTO(nombre,dni,nacimiento);
        return alumnoRetorno;
    }
}
