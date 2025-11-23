package appjava;

public class main {
    public static void main(String[] args) {
        LMDC_registro lmcr = new LMDC_registro();
        CCM_espera ccm = new CCM_espera();
        PM_historial pmh = new PM_historial();

        LDC_escuelaDeportiva ldced = new LDC_escuelaDeportiva();
        ldced.adicionar(new EscuelaDeportiva(1, "Futbol", 25, "Lunes a Viernes de 8:00 a 12:00","Escuela basica de futbol", "RUbben Salinas"));
        ldced.adicionar(new EscuelaDeportiva(2, "Baloncesto", 25, "Lunes a Viernes de 8:00 a 12:00","Escuela basica de baloncesto", "Martin Salazar"));
        ldced.adicionar(new EscuelaDeportiva(3, "Voleybol", 25, "Lunes a Viernes de 8:00 a 12:00","Escuela basica de voleybol", "Juan Perez"));
        LDC_estudiantes ldce = new LDC_estudiantes();
        ldce.adicionar(new Estudiante(1,"Juan", "Perez", "15-03-2005", "70123456"));
        ldce.adicionar(new Estudiante(2,"Maria", "Rodriguez", "22-07-2006", "70234567"));
        ldce.adicionar(new Estudiante(3,"Pedro", "Martinez", "10-11-2004", "70345678"));
        ldce.adicionar(new Estudiante(4,"Ana", "Lopez", "05-01-2005", "70456789"));
        ldce.adicionar(new Estudiante(5,"Carlos", "Sanchez", "30-09-2006", "70567890"));
        ldce.adicionar(new Estudiante(6,"Laura", "Gomez", "12-04-2005", "70678901"));
        ldce.adicionar(new Estudiante(7,"Diego", "Torres", "18-08-2004", "70789012"));
        ldce.adicionar(new Estudiante(8,"Sofia", "Diaz", "25-02-2006", "70890123"));
        ldce.adicionar(new Estudiante(9,"Luis", "Ramirez", "09-06-2005", "70901234"));
        ldce.adicionar(new Estudiante(10,"Elena", "Morales", "14-12-2004", "71012345"));
    }
    public int contarlista(LDC_estudiantes ldce){
        int cont=0;
        if(ldce.getP()!=null){
            NodoEstudiante u=ldce.getP();
            while(u.getSig()!=ldce.getP()){
                u=u.getSig();
                cont++;
            }
            cont++;
        }
        return cont;
    }
    public int contarlista(LDC_escuelaDeportiva ldce){
        int cont=0;
        if(ldce.getP()!=null){
            NodoEscuelaDeportiva u=ldce.getP();
            while(u.getSig()!=ldce.getP()){
                u=u.getSig();
                cont++;
            }
            cont++;
        }
        return cont;
    }
    public int contarlista(LDC_registro ldce){
        int cont=0;
        if(ldce.getP()!=null){
            NodoEstudiante u=ldce.getP();
            while(u.getSig()!=ldce.getP()){
                u=u.getSig();
                cont++;
            }
            cont++;
        }
        return cont;
    }
    
    Estudiante buscarEstudiante(int idEst, LDC_estudiantes ldce){
        if(ldce.getP()!=null){
            NodoEstudiante u=ldce.getP();
            while(u.getSig()!=ldce.getP()){
                if(u.getEstudiante().getIdEst()==idEst){
                    return u.getEstudiante();
                }
                u=u.getSig();
            }
            if(u.getEstudiante().getIdEst()==idEst){
                return u.getEstudiante();
            }
        }
        return null;
    }
    EscuelaDeportiva buscarEscuela(int idEsc, LDC_escuelaDeportiva ldced){
        if(ldced.getP()!=null){
            NodoEscuelaDeportiva u=ldced.getP();
            while(u.getSig()!=ldced.getP()){
                if(u.getEscuela().getIdEsc()==idEsc){
                    return u.getEscuela();
                }
                u=u.getSig();
            }
            if(u.getEscuela().getIdEsc()==idEsc){
                return u.getEscuela();
            }
        }
        return null;
    }   
    
    public void adicionarEstudiante(String nombre, String apellido, String fechaNac, String telefono, LDC_estudiantes ldce){
        int idEst=contarlista(ldce)+1;
        ldce.adicionar(new Estudiante(idEst, nombre, apellido, fechaNac, telefono));
    }
    public void adicionarEscuela(String nombre, int cupo, String horario, String descripcion, String instructor, LDC_escuelaDeportiva ldced){
        int idEsc=contarlista(ldced)+1;
        ldced.adicionar(new EscuelaDeportiva(idEsc, nombre, cupo, horario, descripcion, instructor));
    }
    
    public void actualizarEstudiante(int idEst, int idEsc, LDC_estudiantes ldce, LDC_escuelaDeportiva ldced){
        Estudiante est=buscarEstudiante(idEst, ldce);
        if(est!=null){
            est.setDisciplina(buscarEscuela(idEsc, ldced).getNombre());
            est.setEstado(true);
        }
    }

    public void inscribir(int idEst, int idEsc, LDC_registro ldcr, LDC_estudiantes ldce, LDC_escuelaDeportiva ldced){
        Estudiante est=buscarEstudiante(idEst, ldce);
        EscuelaDeportiva esc=buscarEscuela(idEsc, ldced);
        if(est!=null&&esc!=null){
            ldcr.adicionar(est);
        }
    }
}
