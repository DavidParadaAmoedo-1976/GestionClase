import controlador.AulaControlador;
import controlador.ValidarDatos;
import vista.AulaVista;


public class Program {

    static void main(String[] args) {
        ValidarDatos entrada = new ValidarDatos();
        AulaVista vista = new AulaVista(entrada);
        AulaControlador controlador = new AulaControlador(vista);

        controlador.crearAlumnoPrueba();
        controlador.ejecuta();
    }
}


