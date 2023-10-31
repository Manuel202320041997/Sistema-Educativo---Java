package Controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import DaoImpl.SemestreDaoImpl;
import Model.Semestre;
import Exceptions.SemestreNoEncontradoException;
import Exceptions.BaseDeDatosException;

public class SemestreController {
	private SemestreDaoImpl semestreDaoImpl = null;
	 public SemestreController(){
	    	semestreDaoImpl = new SemestreDaoImpl();
	    }
	 
	 public List<Semestre> listarSemestre(){
	    	List<Semestre> listarSemestre = null;
	    	listarSemestre = semestreDaoImpl.listarSemestre();
	    	return listarSemestre;
	 }
	
	 public int obtenerIdSemestrePorNombre(String nombreSemestre) throws BaseDeDatosException, SemestreNoEncontradoException {
		    Semestre semestre = semestreDaoImpl.obtenerSemestrePorNombre(nombreSemestre);

		    if (semestre != null) {
		        return semestre.getId();
		    } else {
		        throw new SemestreNoEncontradoException("El semestre no se encuentra en la base de datos.");
		    }
		}
	 
	 public void metodoException() {
		    try {
		        int idSemestre = obtenerIdSemestrePorNombre("nombreDelSemestre");
		        
		    } catch (SemestreNoEncontradoException e) {
		        e.printStackTrace();		        
		    } catch (BaseDeDatosException e) {
		        e.printStackTrace();		        
		    }
		}
	 
	 public List<String> obtenerNombresSemestres(){
		    List<String> nombresSemestres = semestreDaoImpl.obtenerNombresSemestres();		    

		    return nombresSemestres;
	 }
}
