package controlador;

import modelo.AlumnoDTO;
import vista.AulaVista;

import java.util.Arrays;

public class AulaControlador {
    private final int NUMERO_MAXIMO_ALUMNOS = 20;
    private final AulaVista vista;
    private AlumnoDTO[] alumnos;

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
                case 0 -> vista.mostrarSalida();
            }
        }
    }

    public void crearAlumno() {
        if (alumnos.length >= NUMERO_MAXIMO_ALUMNOS) {
            vista.mostrarErrAulaLlena();
        } else {
        AlumnoDTO alumno = vista.obtenerDatosAlumno();
        AlumnoDTO[] alumnosTemp = Arrays.copyOf(alumnos, alumnos.length + 1);
            for (int i = 0; i < alumnosTemp.length; i++) {
                if (alumnosTemp[i] == null) {
                    alumnosTemp[i] = alumno;
                    alumnos = Arrays.copyOf(alumnosTemp, alumnosTemp.length);
                    vista.mostrarCreado(alumno);
                }
            }
        }
    }

    public void borrarAlumno() {
        if (!comprobarLista()) {
            vista.mostrarListaVacia();
        } else {
            String dni = vista.obtenerDni();
            AlumnoDTO[] alumnosTemp = new AlumnoDTO[alumnos.length - 1];
            int count = 0;
            for (int i = 0; i < alumnos.length; i++) {
                String dnis = alumnos[i].getDni();
                if (dnis.contains(dni)) {
                    vista.mostrarAlumnoEliminado(alumnos[i]);
                } else {
                    alumnosTemp[count] = alumnos[i];
                    count++;
                }
            }
            alumnos = Arrays.copyOf(alumnosTemp, alumnosTemp.length);
            if (count == 0) vista.mostrarNoEncontrado(dni);
        }
    }

    public void buscarPorNombreParcial() {
        if (!comprobarLista()) {
            vista.mostrarListaVacia();
        } else {
            int contador = 0;
            AlumnoDTO[] alumnosEncontrados = new AlumnoDTO[alumnos.length];
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
            vista.mostrarAlumnosEncontrados(contador, alumnosEncontrados);
        }
    }

    public void buscarPorDni() {
        if (!comprobarLista()) {
            vista.mostrarListaVacia();
        } else {
            String dni = vista.obtenerDni();
            int count = 0;
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] != null) {
                    String dnis = alumnos[i].getDni();
                    if (dnis.contains(dni)) {
                        vista.mostrarAlumnoDni(alumnos[i]);
                        count++;
                    }
                }
            }
            if (count == 0) vista.mostrarNoEncontrado(dni);
        }
    }

    public void pasarLista() {
        if (!comprobarLista()) {
            vista.mostrarListaVacia();
        } else {
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] == null) {
                } else {
                    System.out.println(alumnos[i].getNombreCompleto());
                    Boolean estaEnClase = vista.pasarlista();
                    alumnos[i].setEstaEnClase(estaEnClase);
                }
            }
            vista.mostrarFinlista();
        }
    }

    public boolean comprobarLista() {
        return alumnos != null && alumnos.length != 0;
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
        alumnos = Arrays.copyOf(alumnosPrueba, alumnosPrueba.length);
        vista.mostrarMensajeAlumnosPrueba(alumnosPrueba.length);
    }
}
