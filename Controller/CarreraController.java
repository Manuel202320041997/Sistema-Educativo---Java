package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DaoImpl.CarreraDaoImpl;
import Model.Carrera;


public class CarreraController {
	private CarreraDaoImpl carreraDaoImpl = null;
	 public CarreraController(){
	    	carreraDaoImpl = new CarreraDaoImpl();
	    }
	 
	 public List<Carrera> listarCarrera(){
	    	List<Carrera> listarCarrera = null;
	    	listarCarrera = carreraDaoImpl.listarCarrera();
	    	return listarCarrera;
	 }
	 
	 public int obtenerIdCarreraPorNombre(String nombreCarrera) {
		 try {
		        System.out.println("Intentando obtener ID de carrera para: " + nombreCarrera);
		        Carrera carrera = carreraDaoImpl.obtenerCarreraPorNombre(nombreCarrera);

		        if (carrera != null) {
		            System.out.println("ID de carrera encontrado: " + carrera.getId());
		            return carrera.getId();
		        } else {
		            JOptionPane.showMessageDialog(null, "La carrera no se encuentra en la base de datos.", "Carrera no encontrada", JOptionPane.WARNING_MESSAGE);
		            return -1;
		        }
		    } catch (Exception e) { // Captura cualquier excepción genérica
		        e.printStackTrace(); // Imprime la información de la excepción en la consola para depuración
		        JOptionPane.showMessageDialog(null, "Error al obtener el ID de la carrera.", "Error", JOptionPane.ERROR_MESSAGE);
		        return -1;
		    }
	 }
	 
}
