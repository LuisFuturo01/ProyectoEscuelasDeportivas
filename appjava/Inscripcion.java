package appjava;

public class Inscripcion {
    private int idIns;
    private int idEsc;
    private int idEst;

    public Inscripcion(int idIns, int idEsc, int idEst) {
        this.idIns = idIns;
        this.idEsc = idEsc;
        this.idEst = idEst;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public int getIdIns() {
        return idIns;
    }

    public void setIdIns(int idIns) {
        this.idIns = idIns;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }
    
    public void mostrar(){
        System.out.println("ID de Inscripcion: " + idIns + ", ID de Escuela: " + idEsc + ", ID de Estudiante: " + idEst);
    }
}