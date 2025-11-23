package appjava;

public class NodoEscuelaDeportiva {
    private EscuelaDeportiva escuela;
    private NodoEscuelaDeportiva ant, sig;

    public NodoEscuelaDeportiva() {
        ant=sig=null;
    }

    public EscuelaDeportiva getEscuela() {
        return escuela;
    }

    public void setEscuela(EscuelaDeportiva escuela) {
        this.escuela = escuela;
    }

    public NodoEscuelaDeportiva getAnt() {
        return ant;
    }

    public void setAnt(NodoEscuelaDeportiva ant) {
        this.ant = ant;
    }

    public NodoEscuelaDeportiva getSig() {
        return sig;
    }

    public void setSig(NodoEscuelaDeportiva sig) {
        this.sig = sig;
    }
    
    
    
}