package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.NotasDao;
import Model.Notas;

public class NotasDaoImpl implements NotasDao{
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public NotasDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	
    public List<Notas> obtenerNotasPorIdAlumno(int idAlumno) {
        List<Notas> listaNotas = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM notas WHERE alumno_id = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idAlumno);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int alumno_id = resultSet.getInt("alumno_id");
                int semestre_id = resultSet.getInt("semestre_id");
                double promedio = resultSet.getDouble("promedio");

                Notas notas = new Notas();
                notas.setId(id);
                notas.setAlumno_id(alumno_id);
                notas.setSemestre_id(semestre_id);
                notas.setPromedio(promedio);

                listaNotas.add(notas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNotas;
    }

	@Override
	public void agregarNota(int idAlumno, int idSemestre, double promedio) {
		
        try {
        	String consulta = "INSERT INTO notas (alumno_id, semestre_id, promedio) VALUES (?, ?, ?)";
        	PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idAlumno);
            statement.setInt(2, idSemestre);
            statement.setDouble(3, promedio);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();            
        }
		
	}
	
	@Override
	public boolean existeNota(int alumnoId, int semestreId) {
		try {
	        String consulta = "SELECT 1 FROM notas WHERE alumno_id = ? AND semestre_id = ?";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, alumnoId);
	        statement.setInt(2, semestreId);
	        ResultSet resultSet = statement.executeQuery();

	        return resultSet.next(); // Si hay resultados, significa que existe una nota para esta combinación.

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Manejo de excepciones aquí
	        return false;
	    }
	}

	@Override
	public Notas obtenerUltimaNota(int idAlumno) {		
	    
	    try {	
	    	String consulta = "SELECT * FROM notas WHERE alumno_id = ? ORDER BY semestre_id DESC";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idAlumno);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            Notas ultimaNota = new Notas();
	            ultimaNota.setId(resultSet.getInt("id"));
	            ultimaNota.setAlumno_id(resultSet.getInt("alumno_id"));
	            ultimaNota.setSemestre_id(resultSet.getInt("semestre_id"));
	            ultimaNota.setPromedio(resultSet.getDouble("promedio"));
	            
	            return ultimaNota;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();	        
	    }
	    
	    return null;
	}

}
