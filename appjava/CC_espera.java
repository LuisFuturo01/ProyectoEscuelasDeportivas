package appjava;

public class CC_espera {
    int max=100;
    int ini;
    int fin;
    Inscripcion v[]=new Inscripcion [max];

    public CC_espera() {
        ini=fin=0;
    }
    
    
    int nroelem ()
    {
	return ((max + fin - ini) % max);
    }


    boolean esvacia ()
    {
	if (nroelem () == 0)
	    return (true);
	return (false);
    }


    boolean esllena ()
    {
	if (nroelem () == max - 1)
	    return (true);
	return (false);
    }


    void adicionar (Inscripcion elem)
    {
	if (!esllena ())
	{

	    fin = (fin + 1) % max;
	    v [fin] = elem;
	}
	else
	    System.out.println ("Cola circular llena");
    }


    Inscripcion eliminar ()
    {
	Inscripcion elem = null;
	if (!esvacia ())
	{
	    ini = (ini + 1) % max;
	    elem = v [ini];
	    if (nroelem () == 0)
		ini = fin = 0;
	}
	else
	    System.out.println ("Cola circular vacia");
	return (elem);
    }


    void mostrar ()
    {
	Inscripcion elem;
	if (esvacia ())
	    System.out.println ("Cola vacia xxx");
	else
	{
	    System.out.println ("\n Datos de la Cola ");
	    CC_espera aux = new CC_espera ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		elem.mostrar();
	    }
	    while (!aux.esvacia ())
	    {
		elem = aux.eliminar ();

		adicionar (elem);
	    }
	}
    }


    void invertir ()
    {
	CC_espera a = new CC_espera ();
	CC_espera b = new CC_espera ();
	while (!esvacia ())
	{
	    while (nroelem () != 1)
		a.adicionar (eliminar ());
	    b.adicionar (eliminar ());
	    while (!a.esvacia ())
		adicionar (a.eliminar ());
	}
	while (!b.esvacia ())
	    adicionar (b.eliminar ());

    }


    void vaciar (CC_espera a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar ());

    }
}