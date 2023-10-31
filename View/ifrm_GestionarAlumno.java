package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.SemestreController;
import Controller.CategoriaController;
import Controller.CarreraController;
import Controller.AlumnoController;
import Model.Semestre;
import Model.Categoria;
import Model.Alumno;
import Model.Carrera;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ifrm_GestionarAlumno extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCorreo;
	private JTextField txtNombres;	
	private JComboBox <String> cboCarrera;
	private JComboBox <String> cboCategoria;
	private JComboBox <String> cboSemestre;
	DefaultTableModel modelo;
	private JTable tblAlumno;
	private CarreraController carreraController;
	private CategoriaController categoriaController;
	private SemestreController semestreController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarAlumno frame = new ifrm_GestionarAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ifrm_GestionarAlumno() {
		setBounds(-5, -5, 910, 500);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		//setLocation(-5, -5);
		getContentPane().setBackground(new Color(0, 128, 192));
		getContentPane().setLayout(null);
		
		carreraController = new CarreraController();
		categoriaController = new CategoriaController();
		semestreController = new SemestreController();
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 242, 448);
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Alumnos");
		lblNewLabel.setBounds(10, 11, 222, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(20, 84, 83, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Correo:");
		lblNewLabel_1_1_1.setBounds(20, 134, 83, 26);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Carrera:");
		lblNewLabel_1_1_1_1.setBounds(20, 184, 83, 26);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_1_1_1_1.setBounds(20, 234, 83, 26);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Semestre");
		lblNewLabel_1_1_1_1_1_1.setBounds(20, 284, 83, 26);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(100, 139, 132, 20);
		txtCorreo.setColumns(10);
		panel.add(txtCorreo);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(100, 89, 132, 20);
		txtNombres.setColumns(10);
		panel.add(txtNombres);
		
		cboCarrera = new JComboBox();
		cboCarrera.setBackground(new Color(255, 255, 255));
		cboCarrera.setBounds(100, 189, 132, 21);
		cboCarrera.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Carrera"}));
		actualizarComboBoxCarrera();
		panel.add(cboCarrera);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBackground(new Color(255, 255, 255));
		cboCategoria.setBounds(100, 239, 132, 21);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Categoria"}));
		actualizarComboBoxCategoria();		
		panel.add(cboCategoria);
		
		cboSemestre = new JComboBox();
		cboSemestre.setBackground(new Color(255, 255, 255));
		cboSemestre.setBounds(100, 289, 132, 21);
		cboSemestre.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Semestre"}));
		actualizarComboBoxSemestre();	
		panel.add(cboSemestre);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 146, 1));
		btnGuardar.setBounds(14, 343, 218, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(247, 0, 47));
		btnEliminar.setBounds(14, 414, 218, 23);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLimpiar.setBackground(new Color(254, 202, 2));
		btnLimpiar.setBounds(14, 377, 218, 23);
		panel.add(btnLimpiar);
		
		       
		 modelo = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		                "ID", "Nombres", "Correo", "Carrera", "Cat.", "Sems."
		            }
		        );

		 tblAlumno = new JTable(modelo);
		 tblAlumno.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		 tblAlumno.getColumnModel().getColumn(1).setPreferredWidth(100); // Nombre
		 tblAlumno.getColumnModel().getColumn(2).setPreferredWidth(145); // Correo
		 tblAlumno.getColumnModel().getColumn(3).setPreferredWidth(135); // Carrera
		 tblAlumno.getColumnModel().getColumn(4).setPreferredWidth(20); // Categoria
		 tblAlumno.getColumnModel().getColumn(5).setPreferredWidth(20); // Semestre	
		 mostrarTabla();
		 // Crear un JScrollPane y agregar la JTable a él
		 JScrollPane scrollPane = new JScrollPane(tblAlumno);
		 scrollPane.setBounds(262, 11, 622, 448);
		 getContentPane().add(scrollPane);
		 
		 btnGuardar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 try {
					 Alumno alumno = new Alumno();
			            alumno.setNombres(txtNombres.getText());
			            alumno.setCorreo(txtCorreo.getText());
			            alumno.setCarrera(cboCarrera.getSelectedItem().toString());
			            alumno.setCategoria(cboCategoria.getSelectedItem().toString());
			            alumno.setSemestre(cboSemestre.getSelectedItem().toString());
			            
			            AlumnoController controller = new AlumnoController();
			            controller.agregarAlumnos(alumno);
			            mostrarTabla();
			            limpiar();
			            JOptionPane.showMessageDialog(ifrm_GestionarAlumno.this, "Alumno agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				       
				    } catch (Exception ex) {
				        JOptionPane.showMessageDialog(ifrm_GestionarAlumno.this, "Ocurrió un error al registrar el alumno", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				}
		 });
		 
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		 
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AlumnoController controller = new AlumnoController(); // Crea una instancia del controlador
				    int filaSeleccionada = tblAlumno.getSelectedRow();
				    
				    if (filaSeleccionada >= 0) {
				        try {
				            Object idObject = tblAlumno.getValueAt(filaSeleccionada, 0);
				            int idAlumno = Integer.parseInt(idObject.toString()); // Intenta la conversión

				            int confirmacion = JOptionPane.showConfirmDialog(ifrm_GestionarAlumno.this, "¿Está seguro de que desea eliminar este alumno?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

				            if (confirmacion == JOptionPane.YES_OPTION) {
				                controller.eliminarAlumnos(idAlumno); // Llama al método del controlador para eliminar el alumno
				                mostrarTabla();
				            }
				        } catch (NumberFormatException ex) {
				            JOptionPane.showMessageDialog(ifrm_GestionarAlumno.this, "Error de conversión: El valor no es un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    } else {
				        JOptionPane.showMessageDialog(ifrm_GestionarAlumno.this, "Por favor, seleccione un alumno para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				    }    
				    }    
			
		});

		 
}
	public void actualizarComboBoxCarrera() {

        List<Carrera> listarCarrera = carreraController.listarCarrera();

        // Limpia el ComboBox
        cboCarrera.removeAllItems();

        for (Carrera carrera : listarCarrera) {
            cboCarrera.addItem(carrera.getNombre_carrera());
        }
    }
	
	public void actualizarComboBoxCategoria() {

        List<Categoria> listarCategoria = categoriaController.listarCategoria();

        // Limpia el ComboBox
        cboCategoria.removeAllItems();

        for (Categoria categoria : listarCategoria) {
            cboCategoria.addItem(categoria.getNombre_categoria());
        }
    }
	
	public void actualizarComboBoxSemestre() {

        List<Semestre> listarSemestre = semestreController.listarSemestre();

        // Limpia el ComboBox
        cboSemestre.removeAllItems();

        for (Semestre semestre : listarSemestre) {
            cboSemestre.addItem(semestre.getNombre_semestre());
        }
    }
	
	private void limpiar(){
        this.txtNombres.setText("");
        this.txtCorreo.setText("");        
        cboCarrera.setSelectedIndex(0);
        cboCategoria.setSelectedIndex(0);
        cboSemestre.setSelectedIndex(0);
}
	
	private void mostrarTabla() {
	    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos	    
	    AlumnoController controller = new AlumnoController();
	    List<Alumno> listarAlumno = controller.listarAlumnoEstado();
	    
	    for (Alumno alumno : listarAlumno) {
	        Object[] fila = {
	        		alumno.getId(),
	        		alumno.getNombres(),
	        		alumno.getCorreo(),
	        		alumno.getCarrera(),
	        		alumno.getCategoria(),
	        		alumno.getSemestre()
	        };
	        modelo.addRow(fila);
	    }
	}
}
