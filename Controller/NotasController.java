package Controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import DaoImpl.NotasDaoImpl;
import Model.Notas;

public class NotasController {
	private NotasDaoImpl notasDaoImpl = null;
	private SemestreController semestreController = new SemestreController();
	
    public NotasController(){
    	notasDaoImpl = new NotasDaoImpl();
    }
    
    public List<Notas> obtenerNotasPorIdAlumno(int idAlumno) {
    	  List<Notas> notasAlumno = notasDaoImpl.obtenerNotasPorIdAlumno(idAlumno);

    	    // Ordena la lista de notas por el ID de semestre (de menor a mayor)
    	    Collections.sort(notasAlumno, new Comparator<Notas>() {
    	        @Override
    	        public int compare(Notas nota1, Notas nota2) {
    	            return Integer.compare(nota1.getSemestre_id(), nota2.getSemestre_id());
    	        }
    	    });

    	    return notasAlumno;
    }
    
    public void agregarNotaUsuario(int idAlumno, int semestreId, double promedio) {        	
        if (!existeNota(idAlumno, semestreId)) {  // Cambiar notasController por existeNota
            notasDaoImpl.agregarNota(idAlumno, semestreId, promedio);
        } else {
            System.err.println("Esta nota ya existe");
        }
    }
    
    public boolean existeNota(int idAlumno, int semestreId) {
        return notasDaoImpl.existeNota(idAlumno, semestreId);
    }
    
    public Notas obtenerUltimaNota(int idAlumno) {
    	return notasDaoImpl.obtenerUltimaNota(idAlumno);
    }
   
}
