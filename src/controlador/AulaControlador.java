package controlador;

import modelo.AlumnoDTO;
import vista.AulaVista;

public class AulaControlador {
    public static final int MAXIMO_ALUMNOS = 30;
    private final AulaVista vista;

    private final AlumnoDTO[] alumnos = new AlumnoDTO[MAXIMO_ALUMNOS];

    public AulaControlador(AulaVista vista) {
        this.vista = vista;
    }

    public void ejecuta() {
        int opcion = -1;

        while (opcion != 0) {
            vista.mostrarMenu();
            opcion = vista.solicitarMenu();

            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> borrarAlumno();
                case 3 -> buscarPorNombreParcial();
                case 4 -> buscarPorDni();
                case 5 -> pasarLista();
                case 6 -> vista.mostrarClase(alumnos);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no implementada.");
            }
        }
    }


    public void crearAlumno() {
        AlumnoDTO alumno = vista.obtenerDatosAlumno();
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = alumno;
                System.out.println("Alumno añadido.- " + alumno.getNombreCompleto() +
                        " con DNI: " + alumno.getDni() +
                        " Y nacido en el año " + alumno.getAnioNacimiento());
                return;
            }
        }
        System.err.println("Aula llena, no podemos añadir más alumnos");
    }

    public void borrarAlumno() {
        String dni = vista.obtenerDni();
        int count = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                String dnis = alumnos[i].getDni();
                if (dnis.contains(dni)) {
                    System.out.println("se va eliminar a : " + alumnos[i].getNombreCompleto() + " de la lista.");
                    alumnos[i] = null;
                    count++;
                }
            }
        }
        if (count == 0) System.out.println("No hay alumnos con ese Dni.");
    }

    public void buscarPorNombreParcial() {
        int contador = 0;
        AlumnoDTO[] alumnosEncontrados = new AlumnoDTO[MAXIMO_ALUMNOS];
        String nombreParcial = vista.obtenerNombreParcial();
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                String nombre = alumnos[i].getNombreCompleto().toLowerCase();
                if (nombre.contains(nombreParcial.toLowerCase())) {
                    alumnosEncontrados[contador] = alumnos[i];
                    contador++;
                }
            }
        }
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

    public void buscarPorDni() {
        String dni = vista.obtenerDni();
        int count = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                String dnis = alumnos[i].getDni();
                if (dnis.contains(dni)) {

                    System.out.println(alumnos[i].getNombreCompleto() +
                            " con DNI: " + alumnos[i].getDni() +
                            " Y nacido en el año " + alumnos[i].getAnioNacimiento());
                    count++;
                }
            }
        }
        if (count == 0) System.out.println("No hay alumnos con ese Dni.");
    }

    public void pasarLista() {
        for( int i = 0; i < alumnos.length; i++){
            if(alumnos[i] == null){
                continue;
            } else {
                System.out.println(alumnos[i].getNombreCompleto());
                Boolean estaEnClase = vista.pasarlista();
                alumnos[i].setEstaEnClase(estaEnClase);
            }
        }
        System.out.println("Lista terminada.");
    }

    public void crearAlumnoPrueba() {
        AlumnoDTO[] alumnosPrueba = new AlumnoDTO[]{
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
        for (int i = 0; i < alumnos.length && i < alumnosPrueba.length; i++) {

            if (alumnos[i] == null) {
                alumnos[i] = alumnosPrueba[i];
                System.out.println("Creado alumno de prueba " + (i + 1));

            }
        }
    }
}
