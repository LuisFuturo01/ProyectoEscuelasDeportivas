package appjava;


public class EscuelaDeportiva {
    private int idEsc;
    private String nombre;
    private int cupos;
    private String horario;
    private String descripcion;
    private String responsable;

    public EscuelaDeportiva(int idEsc, String nombre, int cupos, String horario, String descripcion, String responsable) {
        this.idEsc = idEsc;
        this.nombre = nombre;
        this.cupos = cupos;
        this.horario = horario;
        this.descripcion = descripcion;
        this.responsable = responsable;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void mostrar() {
        System.out.println("ID de Escuela: " + idEsc + ", Nombre: " + nombre + ", Cupos: " + cupos + ", Horario: " + horario + ", Descripción: " + descripcion + ", Responsable: " + responsable);
    }
}