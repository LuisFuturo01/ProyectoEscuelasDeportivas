package appjava;

public class NodoLDC_registro {
    private LDC_registro listaRegistro;

    public LDC_registro getListaRegistro() {
        return listaRegistro;
    }

    public void setListaRegistro(LDC_registro listaRegistro) {
        this.listaRegistro = listaRegistro;
    }

    public NodoLDC_registro getAnt() {
        return ant;
    }

    public void setAnt(NodoLDC_registro ant) {
        this.ant = ant;
    }

    public NodoLDC_registro getSig() {
        return sig;
    }

    public void setSig(NodoLDC_registro sig) {
        this.sig = sig;
    }
    private NodoLDC_registro ant,sig;

    public NodoLDC_registro() {
        ant=sig=null;
    }
    
    
}