package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UsuarioController;
import Model.Usuario;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frm_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageIcon icon = new ImageIcon("Img/iconocesal.ico");
				    frm_Login form = new frm_Login();
				    form.setIconImage(icon.getImage());
				    form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(-27, -33, 341, 589);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/logoinspng250.png")));
		lblNewLabel_2.setBounds(59, 172, 240, 213);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("I.E. SUPERIOR CESAL S.A.C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(20, 94, 321, 42);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Brindando Servicios Educativos Superiores");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(20, 415, 321, 42);
		panel.add(lblNewLabel_3_1);
		
		

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/user1.png")));
		lblNewLabel.setBounds(456, 47, 135, 135);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/user2.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(383, 261, 127, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1_1.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/password.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(355, 324, 155, 45);
		contentPane.add(lblNewLabel_1_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsuario.setBounds(512, 269, 155, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtClave.setBounds(512, 334, 155, 30);
		contentPane.add(txtClave);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/ingresar chico.png")));
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIngresar.setBounds(396, 399, 243, 40);
		contentPane.add(btnIngresar);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setFocusable(false);
		btnCerrar.setFocusPainted(false);
		btnCerrar.setFocusTraversalKeysEnabled(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(new Color(255, 255, 255));
		btnCerrar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/cerrar-sesion.png")));
		btnCerrar.setBounds(643, 11, 57, 40);
		contentPane.add(btnCerrar);
		
		
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioController controller = new UsuarioController();
				
				String usuario = txtUsuario.getText();
				String clave = txtClave.getText();
				
				Usuario usuariovalidado = controller.validarLogin(usuario, clave);
				
				if(usuariovalidado != null) {
					//frm_InicioSistema form = new frm_InicioSistema(usuariovalidado);
					frm_Inicio form = new frm_Inicio(usuariovalidado);
					form.setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario y/o Clave incorrecta", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
	}
}
