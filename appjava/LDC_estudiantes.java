package appjava;
public class LDC_estudiantes {
    private NodoEstudiante p;

    public LDC_estudiantes() {
        p=null;
    }
    
    public NodoEstudiante getP() {
        return p;
    }

    public void setP(NodoEstudiante p) {
        this.p = p;
    }
    public void adicionar(Estudiante est)
    {   
        NodoEstudiante nue=new NodoEstudiante();
        nue.setEstudiante(est);
        
        if(getP()==null)
        {
            setP(nue);
            nue.setSig(nue);
            nue.setAnt(nue);
        }
        else
        {
            NodoEstudiante w=getP().getAnt();
            w.setSig(nue);
            nue.setAnt(w);
            nue.setSig(getP());
            getP().setAnt(nue);
        }
    }
    public void mostrar()
    {
        NodoEstudiante u=getP();
        while(u.getSig()!=getP())
        {
            u.getEstudiante().mostrar();
            u=u.getSig();
        }
        u.getEstudiante().mostrar();
    }
    
}