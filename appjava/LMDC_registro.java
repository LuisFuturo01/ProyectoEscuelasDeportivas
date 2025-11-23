package appjava;

public class LMDC_registro {
    private NodoLDC_registro p;

    LMDC_registro() {
        p = null;
    }

    public NodoLDC_registro getP() {
        return p;
    }

    public void setP(NodoLDC_registro p) {
        this.p = p;
    }

    public void adicionar(LDC_registro a) {
        NodoLDC_registro nue = new NodoLDC_registro();
        nue.setListaRegistro(a);
        if (getP() == null) {
            setP(nue);
            nue.setSig(nue);
            nue.setAnt(nue);
        } else {
            NodoLDC_registro w = getP().getAnt();
            w.setSig(nue);
            nue.setAnt(w);
            nue.setSig(getP());
            getP().setAnt(nue);
        }
    }

    public void mostrar() {
        if (getP() == null) {
            System.out.println("MultiLista de registros vacia.");
            return;
        }
        NodoLDC_registro u = getP();
        while (u.getSig() != getP()) {
            u.getListaRegistro().mostrar();
            u = u.getSig();
        }
        // ultimo nodo
        u.getListaRegistro().mostrar();
    }

}
