package Dao;

import java.util.List;

import Model.Semestre;

public interface SemestreDao {
	public List<Semestre> listarSemestre();
	
	public Semestre obtenerSemestrePorNombre (String nombreSemestre);
	
	public List<String> obtenerNombresSemestres();
	

}
