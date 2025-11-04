package controlador;

import modelo.AlumnoDTO;
import vista.AulaVista;

public class AulaControlador {

    private AulaVista vista;

    public void ejecuta(){
        vista.mostrarMenu();
    }

    public AulaControlador(AulaVista vista) {
        this.vista = vista;
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
