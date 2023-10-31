package Model;

public class Notas {
	
	private int id;
	private int alumno_id;
	private int semestre_id;
	private double promedio;
    private boolean finalizado;

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAlumno_id() {
		return alumno_id;
	}
	
	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	
	public int getSemestre_id() {
		return semestre_id;
	}
	
	public void setSemestre_id(int semestre_id) {
		this.semestre_id = semestre_id;
	}
	
	public double getPromedio() {
		return promedio;
	}
	
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
}
