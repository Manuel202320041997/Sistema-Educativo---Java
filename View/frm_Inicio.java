package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Usuario;

public class frm_Inicio extends JFrame {
	private static Usuario usuariovalidado;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar_1;
	private JPanel panel_1;
	private JDesktopPane desktopPane_1;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_Inicio frame = new frm_Inicio(usuariovalidado);
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
	public frm_Inicio(Usuario usuariovalidado) {		
        
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        	String nombreUsuario = usuariovalidado.getNombre();
        	setUndecorated(true);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
	    	panel.setBackground(new Color(0, 128, 192));
		contentPane.setLayout(null);
		
		contentPane.add(panel);

		setContentPane(contentPane);
		
		panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 192));
        panel_1.setBounds(0, 0, 900, 81);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        ImageIcon iconoUsuarioLabel = new ImageIcon(getClass().getResource("/Img/user2.png"));
        JLabel lblNewLabel_1 = new JLabel("Usuario: " + nombreUsuario,iconoUsuarioLabel, JLabel.CENTER);
        lblNewLabel_1.setBounds(664, 25, 198, 45);
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                        
        JLabel lblNewLabel = new JLabel("I.E.S. CESAL");
        lblNewLabel.setIcon(new ImageIcon(frm_Inicio.class.getResource("/Img/logoinspng80icono.png")));
        lblNewLabel.setBounds(10, 7, 271, 72);
        panel_1.add(lblNewLabel);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
               
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(frm_Inicio.class.getResource("/Img/fondoheader.jpg")));
        lblNewLabel_2.setMaximumSize(new Dimension(900, 83));
        lblNewLabel_2.setBounds(0, 0, 900, 83);
        panel_1.add(lblNewLabel_2);

        menuBar_1 = new JMenuBar();
        
        // JMenu
        JMenu menuAlumno = new JMenu("Alumno");        
        JMenu menuNotas = new JMenu("Notas");
        JMenu menuPension = new JMenu("Pensiones");     
        JMenu menuCerrarSesion = new JMenu("Cerrar Sesion");
        
        // Iconos JMenu        
        ImageIcon iconoUsuario = new ImageIcon(getClass().getResource("/Img/usuario.png"));
        menuAlumno.setIcon(iconoUsuario);
        
        ImageIcon iconoNotas = new ImageIcon(getClass().getResource("/Img/cuadernos.png"));
        menuNotas.setIcon(iconoNotas);        
        
        ImageIcon iconoPension = new ImageIcon(getClass().getResource("/Img/calendario.png"));
        menuPension.setIcon(iconoPension);
        
        ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/Img/cerrar-sesion.png"));
        menuCerrarSesion.setIcon(iconoCerrarSesion);        
        
        // JMenuItem
        JMenuItem submenuGestionarAlumno = new JMenuItem("Gestionar Alumno");
        
        JMenuItem submenuGestionarNotas = new JMenuItem("Gestionar Notas");        
        
        JMenuItem submenuGestionarPension = new JMenuItem("Gestionar Pensiones");        
        
        JMenuItem submenuCerrarSesion = new JMenuItem("Cerrar Sesion");        
        
        // Iconos JMenuItems
        ImageIcon iconosubmenuGestionarAlumno = new ImageIcon(getClass().getResource("/Img/gestionaralum.png"));
        submenuGestionarAlumno.setIcon(iconosubmenuGestionarAlumno);
        
        ImageIcon iconosubmenuGestionarNotas = new ImageIcon(getClass().getResource("/Img/gestioncurs.png"));
        submenuGestionarNotas.setIcon(iconosubmenuGestionarNotas);
        
        ImageIcon iconosubmenuGestionarPension = new ImageIcon(getClass().getResource("/Img/pension.png"));
        submenuGestionarPension.setIcon(iconosubmenuGestionarPension);
        
        ImageIcon iconosubmenuCerrarSesion = new ImageIcon(getClass().getResource("/Img/salida-de-emergencia.png"));
        submenuCerrarSesion.setIcon(iconosubmenuCerrarSesion);        

        // Agregar los menús al JMenuBar
        menuBar_1.add(menuAlumno);
        menuBar_1.add(menuNotas);
        menuBar_1.add(menuPension);
        menuBar_1.add(menuCerrarSesion);
        
        // Agregamos submenus
        menuAlumno.add(submenuGestionarAlumno);        
        menuNotas.add(submenuGestionarNotas);        
        menuPension.add(submenuGestionarPension);
        menuCerrarSesion.add(submenuCerrarSesion);

        // Establecer las coordenadas para el JMenuBar
        menuBar_1.setBounds(0, 81, 1280, 30);

        // Agregar el JMenuBar al contenedor
        getContentPane().add(menuBar_1);
        
        desktopPane_1 = new JDesktopPane();
        desktopPane_1.setBackground(new Color(0, 128, 192));
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        desktopPane_1.setBounds(0, 110, ancho, alto);
        getContentPane().add(desktopPane_1);
        desktopPane_1.setLayout(null);
        
        submenuGestionarAlumno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 ifrm_GestionarAlumno ifrm_gestionarAlumno = new ifrm_GestionarAlumno();
        		 desktopPane_1.add(ifrm_gestionarAlumno);
        	     ifrm_gestionarAlumno.setVisible(true);
        	}
        });
        
        submenuGestionarNotas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        	
            		ifrm_GestionarNotas ifrm_gestionarnotas =  new ifrm_GestionarNotas();
            		desktopPane_1.add(ifrm_gestionarnotas);
            		ifrm_gestionarnotas.setVisible(true);
            	}
        	
        });
        
        submenuGestionarPension.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        	
        		ifrm_GestionarPension ifrm_gestionarpension =  new ifrm_GestionarPension();
        		desktopPane_1.add(ifrm_gestionarpension);
        		ifrm_gestionarpension.setVisible(true);
        	}
        });

	submenuCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        		if (confirm == JOptionPane.YES_OPTION) {
        		    
        		    System.exit(0);
        		}
        	}
        });
		
	}
}
