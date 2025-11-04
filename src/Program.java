import controlador.AulaControlador;
import vista.AulaVista;


public class Program {

    public static void main(String[] args) {
        AulaVista controlador = new AulaControlador(vista);
        controlador.ejecuta();
    }

}
