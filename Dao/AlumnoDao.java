package Dao;

import java.util.List;

import Model.Alumno;


public interface AlumnoDao {
	public List<Alumno> listarAlumno();
	
    public void registrarAlumno(Alumno alumno);
    
    public void eliminarAlumno(int id);
    
    public Alumno obtenerAlumnoPorId (int idAlumno);
	
}
