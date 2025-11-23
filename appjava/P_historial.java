
package appjava;

public class P_historial {
    private int max=50;
    private Historial v[] = new Historial[max+1];
    private int tope;
    P_historial(){
        tope=0;
    }
    boolean esVacia(){
        if(tope==0){
            return true;
        }
        return false;
    }
    boolean esLlena(){
        if(tope==max){
            return true;
        }
        return false;
    }
    int nroElem(){
        return tope;    
    }
    void adicionar(Historial elem){
        if(esLlena()){
            System.out.println("Pila llena");
        }else{
            tope++;
            v[tope]=elem;
        }
    }
    Historial eliminar(){
        Historial elem=null;
        if(esVacia()){
            System.out.println("Pila vacia");
        }
        else{
            elem=v[tope];
            tope--;
        }
        return elem;
    }
    void mostrar(){
        P_historial aux = new P_historial();
        while(!esVacia()){
            Historial x=eliminar();
            x.mostrar();
            aux.adicionar(x);
        }
        vaciar(aux);
    }
    void vaciar(P_historial z){
        while(!z.esVacia()){
            adicionar(z.eliminar());
        }
        
    }
}
    