package appjava;

public class NodoEstudiante {
    private Estudiante estudiante;
    private NodoEstudiante ant, sig;

    public NodoEstudiante() {
        ant=sig=null;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public NodoEstudiante getAnt() {
        return ant;
    }

    public void setAnt(NodoEstudiante ant) {
        this.ant = ant;
    }

    public NodoEstudiante getSig() {
        return sig;
    }

    public void setSig(NodoEstudiante sig) {
        this.sig = sig;
    }
    
    
    
}