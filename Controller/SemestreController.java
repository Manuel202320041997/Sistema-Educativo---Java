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
	 
	 /*public int obtenerIdSemestrePorNombre(String nombreSemestre) {
		    try {
		    	Semestre semestre = semestreDaoImpl.obtenerSemestrePorNombre(nombreSemestre);

		        if (semestre != null) {
		            return semestre.getId();
		        } else {
		        	throw new SemestreNoEncontradoException("La carrera no se encuentra en la base de datos.");
		        }
		    } catch (Exception e) { // Captura cualquier excepción genérica
		        e.printStackTrace(); // Imprime la información de la excepción en la consola para depuración
		        throw new BaseDeDatosException("Error al acceder a la base de datos.", e);
		    }
	 }*/
	 
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
		        // Resto de la lógica
		    } catch (SemestreNoEncontradoException e) {
		        e.printStackTrace();
		        // Manejo de SemestreNoEncontradoException
		    } catch (BaseDeDatosException e) {
		        e.printStackTrace();
		        // Manejo de BaseDeDatosException
		    }
		}
	 
	 public List<String> obtenerNombresSemestres(){
		    List<String> nombresSemestres = semestreDaoImpl.obtenerNombresSemestres();
		    

		    return nombresSemestres;
	 }
}
