package appjava;

public class Historial {
    private int idHist;
    private int idEst;
    private String fecha;
    private String tipoMod;
    private String descripcion;

    public Historial(int idHist, int idEst, String fecha, String tipoMod, String descripcion) {
        this.idHist = idHist;
        this.idEst = idEst;
        this.fecha = fecha;
        this.tipoMod = tipoMod;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdHist() {
        return idHist;
    }

    public void setIdHist(int idHist) {
        this.idHist = idHist;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoMod() {
        return tipoMod;
    }

    public void setTipoMod(String tipoMod) {
        this.tipoMod = tipoMod;
    }
    
    public void mostrar(){
        System.out.println("ID de Historial: " + idHist + ", ID de Estudiante: " + idEst + ", Fecha: " + fecha + ", Tipo de Modificación: " + tipoMod + ", Descripción: " + descripcion);
    }
}