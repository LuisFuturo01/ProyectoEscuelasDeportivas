
package appjava;

public class PM_historial {
    private int np;
    private P_historial p[] = new P_historial[100];
    
    PM_historial(){
        for(int i=0; i<100;i++)
            p[i]= new P_historial();
        
    }

    public int getNp() {
        return np;
    }

    public void setNp(int np) {
        this.np = np;
    }
    public boolean esvacia(int i){
        return p[i].esVacia();
    }
    public boolean esllena(int i){
        return p[i].esLlena();
    }
    public int nroelem(int i){
        return p[i].nroElem();
    }
    public void adicionar(int i, Historial x){
        p[i].adicionar(x);
    }
    public Historial eliminar(int i){
        return p[i].eliminar();
    }
    public void mostrar(int i){
        p[i].mostrar();
    }
    public void mostrar(){
        for(int i=0; i<np; i++)
            mostrar(i);
    }
    public void vaciar(int i, P_historial z){
        p[i].vaciar(z);
    }
    public void vaciar(int i, int j){
        p[i].vaciar(p[j]);
    }
}
