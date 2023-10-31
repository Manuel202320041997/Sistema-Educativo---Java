package Dao;

import java.util.List;

import Model.Notas;

public interface NotasDao {
	 public List<Notas> obtenerNotasPorIdAlumno(int idAlumno);
	 public void agregarNota(int idAlumno, int idSemestre, double promedio);
	 public boolean existeNota(int alumnoId, int semestreId);
	 public Notas obtenerUltimaNota(int idAlumno);
}
