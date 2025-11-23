package appjava;

public class CCM_espera {
    int max=100;
    int ini;
    int fin;
    CC_espera v[]=new CC_espera [max];

    public CCM_espera() {
        ini=fin=0;
    }
    
    
    public int nroelem (int i)
    {
	return v[i].nroelem();
    }


    public boolean esvacia (int i)
    {
	return v[i].esvacia();
    }


    public boolean esllena (int i)
    {
	return v[i].esllena();
    }


    public void adicionar (int i, Inscripcion elem)
    {
	    v[i].adicionar(elem);
    }


    public Inscripcion eliminar (int i)
    {
	    return v[i].eliminar();
    }


    public void mostrar (int i)
    {
	v[i].mostrar();
    }

    public void vaciar(int i, CC_espera z){
        v[i].vaciar(z);
    }
    public void vaciar(int i, int j){
        v[i].vaciar(v[j]);
    }

}   