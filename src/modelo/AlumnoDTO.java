package modelo;

public class AlumnoDTO {
    String nombreCompleto;
    String dni;
    int anioNacimiento;
    boolean estaEnClase;

    public AlumnoDTO(String nombreCompleto, String dni, int anioNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.anioNacimiento = anioNacimiento;
        this.estaEnClase = false;
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

    public boolean isEstaEnClase() {
        return estaEnClase;
    }

    public void setEstaEnClase(boolean estaEnClase) {
        this.estaEnClase = estaEnClase;
    }
}
