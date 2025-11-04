package controlador;

import modelo.AlumnoDTO;
import vista.AulaVista;

public class AulaControlador {

    private AulaVista vista;


    public AulaControlador(AulaVista vista) {
        this.vista = vista;
    }

    public void ejecuta() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarMenu();
            switch (opcion) {
                case 1 -> {
                    AlumnoDTO alumno = vista.obtenerDatosAlumno();
                    System.out.println("Alumno añadido: " + alumno.getNombreCompleto() +
                                       " con DNI: " + alumno.getDni() +
                                       " Y nacido en el año " + alumno.getAnioNacimiento());
                }
                case 6 -> vista.mostrarClase();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no implementada.");
            }
        } while (opcion != 0);
    }
    public void crearAlumno(){
        AlumnoDTO alumno = vista.obtenerDatosAlumno();
    }

    public void borrarAlumno(){

    }

    public void buscarPorNombreParcial (){

    }

    public void buscarPorDni(){

    }

    public void pasarLista(){

    }



}
