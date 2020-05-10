package capaPresentacion;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class CPMain extends JFrame{
	
	JLayeredPane panel1;
	private JMenu menu;
	private JMenuBar mb;
	private JLabel lblTitulo;
	
	public CPMain() {
		super("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50,900,600);
		panel1 = new JLayeredPane();
		panel1.setLayout(null);
		setContentPane(panel1);
		
		// imagen de fondo
		ImageIcon img1 = new ImageIcon("IMAGENES" + File.separator + "MascotasDueños.png");
		JLabel lbl1 = new JLabel(img1);
		lbl1.setBounds(0, 10, 900, 600);
		panel1.add(lbl1,1,0);
		
		// barra de menú
		menu = new JMenu("Menú");
		ImageIcon img2 = new ImageIcon("IMAGENES" + File.separator + "paw.png");
		menu.setIcon(img2);
		mb = new JMenuBar();
		setJMenuBar(mb);
		mb.add(menu);
		
		// nombre de la protectora
		lblTitulo = new JLabel("Protectora Plaiaundi");
		lblTitulo.setFont(new Font("Helvetica Neue", Font.BOLD, 40));
		lblTitulo.setBounds(250, 20, 900, 50);
		panel1.add(lblTitulo,2,0);
				
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPMain ventana = new CPMain();
					ventana.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
