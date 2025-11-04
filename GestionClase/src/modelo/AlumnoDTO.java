package modelo;

import java.time.LocalDate;

public class AlumnoDTO {
    String nombreCompleto;
    String dni;
    int anioNacimiento;

    public AlumnoDTO(String nombreCompleto, String dni, int anioNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }
}
