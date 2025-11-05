package controlador;

import modelo.AlumnoDTO;
import vista.AulaVista;

public class AulaControlador {
    private static final int MAXIMO_ALUMNOS = 30;
    private AulaVista vista;

    private AlumnoDTO[] alumnos = new AlumnoDTO[MAXIMO_ALUMNOS];

    public AulaControlador(AulaVista vista) {
        this.vista = vista;
    }

    public void ejecuta() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarMenu();
            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> System.out.println(" pendiente");
                case 3 -> buscarPorNombreParcial();
                case 6 -> vista.mostrarClase();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no implementada.");
            }
        } while (opcion != 0);
    }
    public void crearAlumno(){
        AlumnoDTO alumno = vista.obtenerDatosAlumno();
        System.out.println("Alumno añadido.- " + alumno.getNombreCompleto() +
                " con DNI: " + alumno.getDni() +
                " Y nacido en el año " + alumno.getAnioNacimiento());

    }

    public  void crearAlumnoPrueba(){
        AlumnoDTO[] alumnos = {
                new AlumnoDTO("María González Pérez", "12345678A", 2002),
                new AlumnoDTO("Juan López Martínez", "87654321B", 2001),
                new AlumnoDTO("Lucía Fernández Ruiz", "11223344C", 2003),
                new AlumnoDTO("Carlos García Torres", "44332211D", 2000),
                new AlumnoDTO("Ana Morales Díaz", "55667788E", 1999),
                new AlumnoDTO("Pedro Navarro Gómez", "99887766F", 2004),
                new AlumnoDTO("Elena Romero Castro", "33445566G", 2002),
                new AlumnoDTO("David Herrera León", "66778899H", 2001),
                new AlumnoDTO("Sara Muñoz Vega", "44556677I", 2003),
                new AlumnoDTO("Javier Ruiz Pardo", "77889900J", 1998),
                new AlumnoDTO("Laura Blanco Santos", "99001122K", 2000),
                new AlumnoDTO("Diego Ortega Rivas", "22113344L", 1999),
                new AlumnoDTO("Paula Ramos Gil", "55443322M", 2002),
                new AlumnoDTO("Alejandro Castro Mora", "88776655N", 2001),
                new AlumnoDTO("Marta Jiménez Soto", "33221100O", 2004),
                new AlumnoDTO("Sergio Lozano Peña", "66554433P", 2003),
                new AlumnoDTO("Nuria Vidal Cano", "77885544Q", 2000),
                new AlumnoDTO("Adrián Flores Rubio", "88990011R", 2002),
                new AlumnoDTO("Carmen Molina Lara", "11225544S", 1999),
                new AlumnoDTO("Hugo Sánchez Bravo", "22336655T", 2001)
        };

    }

    public void borrarAlumno(){

    }

    public void buscarPorNombreParcial (){
        int contador = 0;
        AlumnoDTO[] alumnosEncontrados = new AlumnoDTO[MAXIMO_ALUMNOS];
        String nombreParcial = vista.obtenerNombreParcial();
        for( int i = 0; i < alumnosEncontrados.length; i++) {
            String nombre = alumnos[i].getNombreCompleto();
            if (nombre.contains(nombreParcial)){
            alumnosEncontrados[contador] = alumnos[i];
            contador++;
            }
        }



    }

    public void buscarPorDni(){

    }

    public void pasarLista(){

    }



}
