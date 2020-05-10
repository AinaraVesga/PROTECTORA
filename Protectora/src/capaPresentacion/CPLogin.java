package capaPresentacion;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import capaNegocio.NLogin;

public class CPLogin extends JFrame{
	
	Container contenedor;
	JPanel panelTitulo, panelDatos, panelUsuario, panelPw, panelBotones;
	JLabel lblTitulo, lblUsuario, lblPw;
	JTextField tfUsuario, tfPw;
	JButton btnAceptar, btnCancelar;
	
	public CPLogin() {
		super("Login");
		setBounds(50,50,350,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = getContentPane();
		
		// Titulo del formulario
		
		
		// Panel de datos
		panelDatos = new JPanel(new GridLayout(0,1));
		
		panelTitulo = new JPanel(new FlowLayout());
		lblTitulo = new JLabel("Introduzca su usuario y contraseña:");
		panelTitulo.add(lblTitulo);
		panelDatos.add(panelTitulo);
		
		panelUsuario = new JPanel(new FlowLayout());
		panelPw = new JPanel(new FlowLayout());
		panelDatos.add(panelUsuario);
		panelDatos.add(panelPw);
		
		lblUsuario = new JLabel("Usuario");
		tfUsuario = new JTextField(18);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(tfUsuario);
		
		lblPw = new JLabel("Contraseña");
		tfPw = new JTextField(18);		
		panelPw.add(lblPw);
		panelPw.add(tfPw);
		
		// Panel de botones
		panelBotones = new JPanel(new FlowLayout());
		btnAceptar = new JButton("Aceptar");
		btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		ListenerAceptar listAceptar = new ListenerAceptar();
		btnAceptar.addActionListener(listAceptar);
		
		ListenerCancelar listCancelar = new ListenerCancelar();
		btnCancelar.addActionListener(listCancelar);
		
		contenedor.add(panelDatos, BorderLayout.CENTER);
		contenedor.add(panelBotones, BorderLayout.SOUTH);
	}
	
	// Listener de eventos del Boton aceptar
	public class ListenerAceptar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Usuario: " + tfUsuario.getText());
			//System.out.println("Contraseña: " + tfPw.getText());			
			int res = NLogin.buscarUsuario(tfUsuario.getText(), tfPw.getText());
			switch (res) {
			case 0:
				JOptionPane.showMessageDialog(null, "Rellene los campos");
				break;
			
			case -1:
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Se ha identificado correctamente");
				dispose();
				CPMain f = new CPMain();
				f.setVisible(true);
				break;

			default:
				break;
			}
		}
	}
	
	// Listener de eventos del Boton cancelar
	public class ListenerCancelar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		CPLogin f = new CPLogin();
		f.setVisible(true);
	}
}
