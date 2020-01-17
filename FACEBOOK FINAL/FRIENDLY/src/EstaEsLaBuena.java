//NICOLE CARRILLO
//JOSE MARIA SANCHEZ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//SECCION DE COMENTARIOS DEL PROGRAMADOR 
/*
 * QUE NO SE AGREGE DOS VECES A LA MISMA PERSONA
 * CHECAR LA FUNCION AMPLIAR DEL GRAFO
 * SI HAY TIEMPO AGREGAR EDITAR PERFIL
 * AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH 
 * CHECAR COMO VERIFICAR BUSCAR CON PROFE 
 * PONER BORDES A LO QUE SEA DICE NICOLE
 * AGREGAR MUCHA PEOPLE EN TEXT AREA
*/
public class EstaEsLaBuena extends JFrame implements ActionListener{

	JPanel contentPane;
	JTextField textField;
	JTextField textField_2;
	JPasswordField passwordField;
	JTextArea textArea,amigosAgregados,Total_per;
	JLabel num_amigos,nombre;
	JButton btnLogIn,btnSignIn,btnAceptar,btnRechazar,btnAgregar,btnCambiarNombre;
	JPanel panel_1,panel;


	GrafoFacebook fc=new GrafoFacebook();
	private JButton btnCerrarSesin;
	private JLabel lblUsuariosEnFriendly;
	private JTextField textField_1;
	private String respaldo="";

	public EstaEsLaBuena() {
		setTitle("Friendly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 225, 920, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 84, 182, 413);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(33, 176, 116, 22);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(58, 147, 56, 16);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblContrasea.setBounds(58, 211, 69, 16);
		panel.add(lblContrasea);

		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(0, 275, 91, 25);
		panel.add(btnLogIn);
		btnLogIn.addActionListener(this);

		btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(91, 275, 91, 25);
		panel.add(btnSignIn);
		btnSignIn.addActionListener(this);

		JLabel label = new JLabel("Usuario");
		label.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\logo.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label.setBounds(58, 30, 62, 90);
		panel.add(label);

		passwordField = new JPasswordField();
		passwordField.setBounds(33, 240, 116, 22);
		panel.add(passwordField);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(206, 13, 684, 554);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textArea = new JTextArea();
		textArea.setBackground(new Color(245, 245, 245));
		textArea.setEditable(false);
		textArea.setBounds(12, 400, 186, 103);
		panel_1.add(textArea);

		amigosAgregados = new JTextArea();
		amigosAgregados.setBackground(new Color(245, 245, 245));
		amigosAgregados.setEditable(false);
		amigosAgregados.setRows(8);
		amigosAgregados.setColumns(10);
		amigosAgregados.setBounds(210, 195, 462, 308);
		panel_1.add(amigosAgregados);

		Total_per = new JTextArea();
		Total_per.setBackground(new Color(245, 245, 245));
		Total_per.setEditable(false);
		Total_per.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		Total_per.setRows(15);
		Total_per.setColumns(3);
		Total_per.setBounds(12, 36, 190, 248);
		panel_1.add(Total_per);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 297, 186, 2);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 385, 186, 2);
		panel_1.add(separator_1);

		textField_2 = new JTextField();
		textField_2.setBounds(12, 312, 186, 22);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(12, 516, 92, 25);
		panel_1.add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnRechazar = new JButton("Rechazar");
		btnRechazar.setBounds(106, 516, 92, 25);
		panel_1.add(btnRechazar);
		btnRechazar.addActionListener(this);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(61, 347, 92, 25);
		panel_1.add(btnAgregar);
		btnAgregar.addActionListener(this);

		JLabel label_1 = new JLabel("Usuario");
		label_1.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\logo.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		label_1.setBounds(376, 13, 62, 90);
		panel_1.add(label_1);

		JLabel lblNumeroDeAmigos = new JLabel("Numero de amigos");
		lblNumeroDeAmigos.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNumeroDeAmigos.setBounds(298, 160, 140, 22);
		panel_1.add(lblNumeroDeAmigos);

		num_amigos = new JLabel("");
		num_amigos.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		num_amigos.setBounds(454, 160, 82, 22);
		panel_1.add(num_amigos);

		nombre = new JLabel("New label");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		nombre.setBounds(337, 131, 155, 16);
		panel_1.add(nombre);

		btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.setBounds(552, 516, 120, 25);
		panel_1.add(btnCerrarSesin);
		btnCerrarSesin.addActionListener(this);
		
		lblUsuariosEnFriendly = new JLabel("Usuarios en Friendly:");
		lblUsuariosEnFriendly.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuariosEnFriendly.setBounds(12, 13, 190, 16);
		panel_1.add(lblUsuariosEnFriendly);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 516, 116, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.setBounds(341, 516, 129, 25);
		panel_1.add(btnCambiarNombre);
		btnCambiarNombre.addActionListener(this);
		
		this.agregarAdmin();
		this.panel.setVisible(true);
		this.panel_1.setVisible(false);
	}

	public void actUser() {
		this.respaldo=this.textField.getText();
		this.nombre.setText(respaldo);
		this.num_amigos.setText(fc.GetAmigos(this.textField.getText()));
		this.Total_per.setText(this.fc.imprimirTotalAmigos());
		this.amigosAgregados.setText(this.fc.imprimirAmigosVertice(this.textField.getText()));
		this.textArea.setText(this.fc.imprimirArreglo(this.fc.getVertice(this.textField.getText())));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.btnAceptar) {
			this.fc.aceptarSolicitud(this.textField.getText(), true);
			this.actUser();
			
		}else if(e.getSource()==this.btnRechazar) {
			this.fc.aceptarSolicitud(this.textField.getText(), false);
			this.actUser();
			
		}else if(e.getSource()==this.btnLogIn) {
			if(fc.buscar(this.textField.getText(), String.valueOf(this.passwordField.getPassword()))) {
				this.panel.setVisible(false);
				this.panel_1.setVisible(true);
				this.actUser();
				
			}else {
				JOptionPane.showMessageDialog(null, "NO HAY NINGUN PERFIL CON ESE NOMBRE Y CONTRASENA","FATAL_ERROR_505",JOptionPane.ERROR_MESSAGE);
				
			}
		}else if(e.getSource()==this.btnAgregar) {
			this.fc.request(this.textField.getText(), this.textField_2.getText());
			JOptionPane.showMessageDialog(null, "SOLICITUD ENVIADA","SOLICITUD",JOptionPane.INFORMATION_MESSAGE);
			this.actUser();
			
		}else if(e.getSource()==this.btnSignIn) {
			if(this.textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "TU NOMBRE ES IMPORTANTE PARA NOSOTROS, PORFAVOR INGRESALO","CHEERS_UP_ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				fc.addPerfil(this.textField.getText(), String.valueOf(this.passwordField.getPassword()));
			}
			
		}else if(e.getSource()==this.btnCerrarSesin) {
			this.panel.setVisible(true);
			this.panel_1.setVisible(false);
			
		}else if(e.getSource()==btnCambiarNombre) {
			this.textField.setText(this.fc.editarPerfil(this.respaldo,String.valueOf(this.passwordField.getPassword()) , this.textField_1.getText()));
			this.actUser();
		}

	}

	private void agregarAdmin() {
		this.fc.addPerfilMaestro(new VerticePersona("nicole","manchas"));
		this.fc.addPerfilMaestro(new VerticePersona("chema","nicole"));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstaEsLaBuena frame = new EstaEsLaBuena();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
