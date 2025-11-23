
package appjava;

public class Estudiante {
    private int idEst;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private boolean estado;
    private String disciplina;
    private String telefono;

    public Estudiante(int idEst, String nombre, String apellido, String fechaNac, String telefono) {
        this.idEst = idEst;
        this.estado=false;
        this.disciplina="";
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String diciplina) {
        this.disciplina = diciplina;
    }
    
    public void mostrar(){
        System.out.println("ID: " + idEst + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Fecha de Nacimiento: " + fechaNac + ", Estado: " + estado + ", Disciplina: " + disciplina + ", Telefono: " + telefono);
    }
}