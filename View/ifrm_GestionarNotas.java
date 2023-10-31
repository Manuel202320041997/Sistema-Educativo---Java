package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.AlumnoController;
import Controller.NotasController;
import Controller.SemestreController;
import Exceptions.BaseDeDatosException;
import Exceptions.SemestreNoEncontradoException;
import Model.Alumno;
import Model.Notas;
import Model.Semestre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ifrm_GestionarNotas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;	
	DefaultTableModel modelo;
	private JTable tblSemestre;
	private JTextField txtCarrera;
	private JTextField txtBuscar;
	private JComboBox cboSemestre;
	private SemestreController semestreController;
	private NotasController notasController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarNotas frame = new ifrm_GestionarNotas();
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
	public ifrm_GestionarNotas() {
		setBounds(-5, -5, 910, 500);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		//setLocation(-5, -5);
		getContentPane().setBackground(new Color(0, 128, 192));
		getContentPane().setLayout(null);
		
		semestreController = new SemestreController();
		notasController = new NotasController();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 242, 448);
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Notas");
		lblNewLabel.setBounds(10, 11, 222, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(16, 158, 83, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Carrera:");
		lblNewLabel_1_1_1_1.setBounds(16, 208, 83, 26);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Semestre:");
		lblNewLabel_1_1_1_1_1_1.setBounds(16, 258, 83, 26);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Nota:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(16, 308, 83, 26);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setCaretColor(new Color(0, 0, 0));
		txtNombres.setBounds(96, 163, 132, 20);
		txtNombres.setColumns(10);
		panel.add(txtNombres);
		
		JButton btnGuardar = new JButton("Registrar Nota");		
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 146, 1));
		btnGuardar.setBounds(10, 368, 218, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnGuardar);
		
		txtCarrera = new JTextField();
		txtCarrera.setEditable(false);
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(96, 213, 132, 20);
		panel.add(txtCarrera);
		
		JSpinner spinnerNota = new JSpinner();
		spinnerNota.setBackground(new Color(255, 255, 255));
		spinnerNota.setModel(new SpinnerNumberModel(14.0, 0.0, 20.0, 2.0));
		spinnerNota.setBounds(96, 313, 132, 20);
		panel.add(spinnerNota);
		
		cboSemestre = new JComboBox();
		cboSemestre.setBackground(new Color(255, 255, 255));
		cboSemestre.setBounds(96, 262, 132, 20);
		//actualizarComboBoxSemestre();
		panel.add(cboSemestre);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(146, 96, 36, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar por ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(67, 96, 69, 20);
		panel.add(lblNewLabel_1_1);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setIcon(new ImageIcon(ifrm_GestionarNotas.class.getResource("/Img/lupachi.png")));
		btnBuscar.setBounds(192, 96, 36, 20);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel_2.setBounds(47, 89, 185, 31);
		panel.add(lblNewLabel_2);
		
		
		
		String[] nombresSemestres = {"Semestre I", "Semestre II", "Semestre III", "Semestre IV", "Semestre V", "Semestre VI"};      
		modelo = new DefaultTableModel(new Object[][] {}, nombresSemestres);

		 tblSemestre = new JTable(modelo);
		 tblSemestre.getColumnModel().getColumn(0).setPreferredWidth(100); // S1
		 tblSemestre.getColumnModel().getColumn(1).setPreferredWidth(100); // S2
		 tblSemestre.getColumnModel().getColumn(2).setPreferredWidth(100); // S3
		 tblSemestre.getColumnModel().getColumn(3).setPreferredWidth(100); // S4
		 tblSemestre.getColumnModel().getColumn(4).setPreferredWidth(100); // S5
		 tblSemestre.getColumnModel().getColumn(5).setPreferredWidth(100); // S6

		 // Crear un JScrollPane y agregar la JTable a él
		 JScrollPane scrollPane = new JScrollPane(tblSemestre);
		 scrollPane.setBounds(262, 11, 622, 448);
		 getContentPane().add(scrollPane);
		
		 
		 btnBuscar.addActionListener(new ActionListener() {
		  	 public void actionPerformed(ActionEvent e) {
		  				  		 
		  		int idAlumnoBuscado = Integer.parseInt(txtBuscar.getText());
		  		AlumnoController controller = new AlumnoController();
		  		Alumno alumno = controller.obtenerAlumnoPorId(idAlumnoBuscado);

		  		if (alumno != null) {
		             txtNombres.setText(alumno.getNombres());
		             txtCarrera.setText(alumno.getCarrera());
		             String semestre = alumno.getSemestre();
		             
		             actualizarTablaNotas(idAlumnoBuscado);
		             
		             cargarOpcionesSemestre(alumno);
		             cboSemestre.setSelectedItem(semestre);

		  		} else {
		  			JOptionPane.showMessageDialog(ifrm_GestionarNotas.this, "No se ha encontrado un Alumno con este ID en nuestra base de datos. Ingrese uno correspondiente por favor.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		  		}
			 }
		 });
		 
		 btnGuardar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 try {
			            int idAlumno = Integer.parseInt(txtBuscar.getText());
			            String semestreTexto = cboSemestre.getSelectedItem().toString();
			            int semestreId = semestreController.obtenerIdSemestrePorNombre(semestreTexto);
			            double promedio = (double) spinnerNota.getValue();

			            // Verificar si la nota ya existe
			            if (notasController.existeNota(idAlumno, semestreId)) {
			                JOptionPane.showMessageDialog(null, "¡La nota ya existe para este alumno y semestre!", "Advertencia", JOptionPane.WARNING_MESSAGE);
			            } else {
			                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de añadir la nota? ¡No podrás cambiarla una vez registrada!", "Confirmar", JOptionPane.YES_NO_OPTION);

			                if (confirmacion == JOptionPane.YES_OPTION) {
			                    notasController.agregarNotaUsuario(idAlumno, semestreId, promedio);
			                    actualizarTablaNotas(idAlumno);
			                } else {
			                    System.out.println("El usuario canceló el registro");
			                }
			            }
			        } catch (SemestreNoEncontradoException e) {
			            e.printStackTrace();

			        } catch (BaseDeDatosException e) {
			            e.printStackTrace();

			        }
			    }
			});
		  
		 
			txtBuscar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtBuscar.setText("");
				}
			});
		 
	}
	/*----ME QUEDE AQUÍ----*/
	 private void actualizarTablaNotas(int idAlumno) {
		 
			    modelo.setRowCount(0);

			    List<Notas> notasAlumno = notasController.obtenerNotasPorIdAlumno(idAlumno);

			    // Crea una fila para el alumno actual
			    Object[] filaAlumno = new Object[modelo.getColumnCount()];

			    int columnIndex = 0; // Para llevar un seguimiento del índice de columna

			    for (Notas nota : notasAlumno) {
			        // Verifica si el índice de columna es válido
			        if (columnIndex < modelo.getColumnCount()) {
			            filaAlumno[columnIndex] = nota.getPromedio();
			            columnIndex++; // Avanza al siguiente índice de columna
			        } else {
			            break; // No hay más columnas en el modelo de la tabla
			        }
			    }

			    modelo.addRow(filaAlumno); // Agrega la fila del alumno a la tabla
			
	 }
	
	 private void cargarOpcionesSemestre(Alumno alumno) {
		    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		    
		    // Obtener el semestre del alumno y limitar las opciones en el JComboBox
		    String semestreTexto = alumno.getSemestre();
		    int semestreID = -1;
		    
		    try {
		        semestreID = semestreController.obtenerIdSemestrePorNombre(semestreTexto);
		        if (semestreID > 0) {
		            // Obtener la lista de nombres de semestres desde la base de datos
		            List<String> nombresSemestres = semestreController.obtenerNombresSemestres();
		            
		            // Agregar los nombres de semestres a la lista
		            for (int i = 0; i < semestreID; i++) {
		                model.addElement(nombresSemestres.get(i));
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    cboSemestre.setModel(model);
		    cboSemestre.setSelectedItem(semestreTexto);
		}
	 
	/*public void actualizarComboBoxSemestre() {

        List<Semestre> listarSemestre = semestreController.listarSemestre();

        // Limpia el ComboBox
        cboSemestre.removeAllItems();

        for (Semestre semestre : listarSemestre) {
            cboSemestre.addItem(semestre.getNombre_semestre());
        }
	 
    }*/
}
