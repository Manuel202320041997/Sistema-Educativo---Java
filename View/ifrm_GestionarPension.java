package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Controller.PensionController;
import Controller.AlumnoController;
import Controller.NotasController;
import Model.Alumno;
import Model.Notas;

public class ifrm_GestionarPension extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscar;
	private JTextField txtNombres;
	private JTextField txtCorreo;
	private JTextField txtCarrera;
	private JTextField txtCategoria;
	private JTextField txtSemestre;
	private JTextField txtNota;
	private NotasController notasController;
	private PensionController pensionController;
	private JTextField txtPensionInicial;
	private JTextField txtDescuento;
	private JTextField txtPension;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarPension frame = new ifrm_GestionarPension();
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
	public ifrm_GestionarPension() {
		setBounds(-5, -5, 910, 500);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		//setLocation(-5, -5);
		getContentPane().setBackground(new Color(0, 128, 192));
		getContentPane().setLayout(null);
		
		notasController = new NotasController();
		pensionController = new PensionController();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 333, 448);
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Pensiones");
		lblNewLabel.setBounds(10, 11, 313, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);

		
		JButton btnCalcularPension = new JButton("Verificar Pension");
		btnCalcularPension.setForeground(new Color(255, 255, 255));
		btnCalcularPension.setBackground(new Color(0, 146, 1));
		btnCalcularPension.setBounds(48, 399, 229, 23);
		btnCalcularPension.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnCalcularPension);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar por ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(159, 66, 69, 20);
		panel.add(lblNewLabel_1_1);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setIcon(new ImageIcon(ifrm_GestionarNotas.class.getResource("/Img/lupachi.png")));
		btnBuscar.setBounds(287, 67, 36, 20);
		panel.add(btnBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(241, 67, 36, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel_2.setBounds(140, 61, 185, 31);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(44, 133, 101, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(44, 173, 101, 23);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Carrera:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(44, 213, 101, 23);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Categoria:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(44, 253, 101, 23);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Semestre:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(44, 293, 101, 23);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Nota:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1_1.setBounds(43, 333, 56, 23);
		panel.add(lblNewLabel_1_2_1_1_1_1);
				
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setBounds(118, 136, 167, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(118, 176, 167, 20);
		panel.add(txtCorreo);
		
		txtCarrera = new JTextField();
		txtCarrera.setEditable(false);
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(118, 216, 167, 20);
		panel.add(txtCarrera);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(118, 256, 167, 20);
		panel.add(txtCategoria);
		
		txtSemestre = new JTextField();
		txtSemestre.setEditable(false);
		txtSemestre.setColumns(10);
		txtSemestre.setBounds(118, 296, 167, 20);
		panel.add(txtSemestre);
		
		txtNota = new JTextField();
		txtNota.setEditable(false);
		txtNota.setColumns(10);
		txtNota.setBounds(118, 336, 167, 20);
		panel.add(txtNota);

		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_3.setBounds(20, 111, 292, 264);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(353, 122, 531, 256);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCalculadorDePensin = new JLabel("Calculador de Pensión Alumno");
		lblCalculadorDePensin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculadorDePensin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCalculadorDePensin.setBounds(10, 11, 313, 39);
		panel_1.add(lblCalculadorDePensin);
		
		JLabel lblNewLabel_4 = new JLabel("Cobro por Categoria:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(57, 81, 121, 25);
		panel_1.add(lblNewLabel_4);
		
		txtPensionInicial = new JTextField();
		txtPensionInicial.setEditable(false);
		txtPensionInicial.setBounds(188, 82, 108, 25);
		panel_1.add(txtPensionInicial);
		txtPensionInicial.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Descuento por Calificaciones:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(10, 141, 181, 25);
		panel_1.add(lblNewLabel_4_1);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(188, 142, 108, 25);
		panel_1.add(txtDescuento);
		
		txtPension = new JTextField();
		txtPension.setHorizontalAlignment(SwingConstants.CENTER);
		txtPension.setEditable(false);
		txtPension.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPension.setBounds(392, 100, 101, 53);
		panel_1.add(txtPension);
		txtPension.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Cobro del Siguiente Ciclo");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(371, 164, 150, 25);
		panel_1.add(lblNewLabel_4_2);
		

		btnBuscar.addActionListener(new ActionListener() {
		  	 public void actionPerformed(ActionEvent e) {
		  				  		 
		  		int idAlumnoBuscado = Integer.parseInt(txtBuscar.getText());
		  		AlumnoController controller = new AlumnoController();
		  		Alumno alumno = controller.obtenerAlumnoPorId(idAlumnoBuscado);

		  		if (alumno != null) {
		             		txtNombres.setText(alumno.getNombres());
		             		txtCorreo.setText(alumno.getCorreo());
		             		txtCarrera.setText(alumno.getCarrera());
		             		txtCategoria.setText(alumno.getCategoria());
		             		txtSemestre.setText(alumno.getSemestre());
		             
		             
		             		Notas ultimaNota = notasController.obtenerUltimaNota(alumno.getId());
		             	if (ultimaNota != null) {
		                	 txtNota.setText(String.valueOf(ultimaNota.getPromedio()));
		             	} else {
		            		 txtNota.setText("N/A");
		             	}
		             
		             
		             
		  		} else {
		  			JOptionPane.showMessageDialog(ifrm_GestionarPension.this, "No se ha encontrado un Alumno con este ID en nuestra base de datos. Ingrese uno correspondiente por favor.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		  		}
			 }
		 });
		
		txtBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtBuscar.setText("");
			}
		});
		
		btnCalcularPension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String categoria = txtCategoria.getText();
					String semestre = txtCategoria.getText();
					double nota = Double.parseDouble(txtNota.getText());
					
					double pension = pensionController.calcularPension(categoria, semestre, nota);
   				    	String porcentajeDescuento = pensionController.obtenerPorcentajeDescuento(nota);
   				    	String pensionInicial = pensionController.obtenerPensionCategoria(categoria);

   			        	txtDescuento.setText(porcentajeDescuento);
   			        	txtPensionInicial.setText(pensionInicial);					
					txtPension.setText("S/."+ pension);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(ifrm_GestionarPension.this, "Que raro que no se haya calcular xd.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}
