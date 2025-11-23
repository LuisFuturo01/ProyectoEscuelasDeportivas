package appjava;
public class LDC_escuelaDeportiva {
    private EscuelaDeportiva escuela;
    private NodoEscuelaDeportiva p;

    public LDC_escuelaDeportiva() {
        p=null;
    }
    
    public EscuelaDeportiva getEscuela() {
        return escuela;
    }

    public void setEscuela(EscuelaDeportiva escuela) {
        this.escuela = escuela;
    }
    public NodoEscuelaDeportiva getP() {
        return p;
    }

    public void setP(NodoEscuelaDeportiva p) {
        this.p = p;
    }
    public void adicionar(EscuelaDeportiva a)
    {   
        NodoEscuelaDeportiva nue=new NodoEscuelaDeportiva();
        nue.setEscuela(a);
        
        if(getP()==null)
        {
            setP(nue);
            nue.setSig(nue);
            nue.setAnt(nue);
        }
        else
        {
            NodoEscuelaDeportiva w=getP().getAnt();
            w.setSig(nue);
            nue.setAnt(w);
            nue.setSig(getP());
            getP().setAnt(nue);
        }
    }
    public void mostrar()
    {
        NodoEscuelaDeportiva u=getP();
        while(u.getSig()!=getP())
        {
            u.getEscuela().mostrar();
            u=u.getSig();
        }
        //ultimo nodo
        u.getEscuela().mostrar();
    }
    
}