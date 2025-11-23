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
    public int contarlistaEst(LDC_estudiantes ldce){
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
    public int contarlistaEsc(LDC_escuelaDeportiva ldce){
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
    public int contarlistaReg(LDC_registro ldce){
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
    
    public void eliminarEst(int idEst, LDC_estudiantes ldce){
        Estudiante est=buscarEstudiante(idEst, ldce);
        if(est!=null){
           NodoEstudiante nre = ldce.getP();
           while(nre.getSig()!=ldce.getP()){
            if(nre.getEstudiante().getIdEst()==idEst){
                nre.getAnt().setSig(nre.getSig());
                nre.getSig().setAnt(nre.getAnt());
                if(nre==ldce.getP()){
                    ldce.setP(nre.getSig());
                }
                break;
            }
            nre=nre.getSig();
           }
        }
    }
    public void eliminarEsc(int idEsc, LDC_escuelaDeportiva ldced){
        EscuelaDeportiva esc=buscarEscuela(idEsc, ldced);
        if(esc!=null){
           NodoEscuelaDeportiva nre = ldced.getP();
           while(nre.getSig()!=ldced.getP()){
            if(nre.getEscuela().getIdEsc()==idEsc){
                nre.getAnt().setSig(nre.getSig());
                nre.getSig().setAnt(nre.getAnt());
                if(nre==ldced.getP()){
                    ldced.setP(nre.getSig());
                }
                break;
            }
            nre=nre.getSig();
           }
        }
    }
    public void eliminarReg(int idEst, LDC_registro ldcr){
        Estudiante est=buscarEstudianteReg(idEst, ldcr);
        if(est!=null){
           NodoEstudiante nre = ldcr.getP();
           while(nre.getSig()!=ldcr.getP()){
            if(nre.getEstudiante().getIdEst()==idEst){
                nre.getAnt().setSig(nre.getSig());
                nre.getSig().setAnt(nre.getAnt());
                if(nre==ldcr.getP()){
                    ldcr.setP(nre.getSig());
                }
                break;
            }
            nre=nre.getSig();
           }
        }
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
    Estudiante buscarEstudianteReg(int idEst, LDC_registro ldcr){
        if(ldcr.getP()!=null){
            NodoEstudiante u=ldcr.getP();
            while(u.getSig()!=ldcr.getP()){
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

    public void adicionarEstudiante(String nombre, String apellido, String fechaNac, String telefono, LDC_estudiantes ldce){
        int idEst=contarlistaEst(ldce)+1;
        ldce.adicionar(new Estudiante(idEst, nombre, apellido, fechaNac, telefono));
    }
    public void adicionarEscuela(String nombre, int cupo, String horario, String descripcion, String instructor, LDC_escuelaDeportiva ldced){
        int idEsc=contarlistaEsc(ldced)+1;
        ldced.adicionar(new EscuelaDeportiva(idEsc, nombre, cupo, horario, descripcion, instructor));
    }
    public void adicionarRegistro(Estudiante est, LDC_registro ldcr){
        ldcr.adicionar(est);
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
    public void desinscribir(int idEst, int idEsc, LDC_registro ldcr, LDC_estudiantes ldce, LDC_escuelaDeportiva ldced){
        Estudiante est=buscarEstudiante(idEst, ldce);
        EscuelaDeportiva esc=buscarEscuela(idEsc, ldced);
        if(est!=null&&esc!=null){
            
        }
    } 
}
