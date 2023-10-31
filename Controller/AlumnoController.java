package Controller;

import java.util.ArrayList;
import java.util.List;

import DaoImpl.AlumnoDaoImpl;
import Model.Alumno;

public class AlumnoController {
private AlumnoDaoImpl alumnoDaoImpl = null;
private CategoriaController categoriaController = new CategoriaController();
private SemestreController semestreController = new SemestreController();
private CarreraController carreraController = new CarreraController();
    
    public AlumnoController(){
    	alumnoDaoImpl = new AlumnoDaoImpl();
    }
    
    public List<Alumno> listarAlumnoEstado(){
    	List<Alumno> listaCompleta = alumnoDaoImpl.listarAlumno();
        List<Alumno> listaFiltrada = new ArrayList<>();

        for (Alumno alumno : listaCompleta) {
            if (alumno.getEstado()) {
                listaFiltrada.add(alumno);
            }
        }
    	
    	return listaFiltrada;
    }
    
    public void agregarAlumnos(Alumno alumno){
    	 try {
    		 // Obtener los IDs correspondientes a partir de los nombres
    	        int idCarrera = carreraController.obtenerIdCarreraPorNombre(alumno.getCarrera());
    	        int idCategoria = categoriaController.obtenerIdCategoriaPorNombre(alumno.getCategoria());
    	        int idSemestre = semestreController.obtenerIdSemestrePorNombre(alumno.getSemestre());

    	        // Crear un objeto Alumno con los valores numéricos
    	        Alumno alumnoObj = new Alumno();
    	        alumnoObj.setNombres(alumno.getNombres());
    	        alumnoObj.setCorreo(alumno.getCorreo());
    	        alumnoObj.setCarrera(String.valueOf(idCarrera)); 
    	        alumnoObj.setCategoria(String.valueOf(idCategoria));
    	        alumnoObj.setSemestre(String.valueOf(idSemestre));

    	        // Llamar a funcion registrarAlumno de DaoImpl
    	        alumnoDaoImpl.registrarAlumno(alumnoObj);
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    }
    
    public void eliminarAlumnos(int id){
        alumnoDaoImpl.eliminarAlumno(id);
    }
    
    public Alumno obtenerAlumnoPorId(int idAlumno) {
        return alumnoDaoImpl.obtenerAlumnoPorId(idAlumno);
    }
}
