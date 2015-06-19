package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

//import Controlador.ControladorRRHH;

public class Menu extends javax.swing.JFrame 
{
	private JButton AltaEdicion;
	private JButton nuevaColocacion;
	private JButton Close;
	private JLabel header;
	//private Controlador controlador;
	
	public Menu() 
	{
		super();
		initGUI();
		setSize(450, 200);
		//this.controlador= new Controlador();
	}
	
	private void initGUI()
	{
		
			getContentPane().setLayout(null);
			
			header = new JLabel("Menú principal");
			header.setBounds(20, 10, 300, 23);
			getContentPane().add(header);
			
			AltaEdicion = new JButton();
			getContentPane().add(AltaEdicion);
			AltaEdicion.setText("Nueva Edición");
			AltaEdicion.setBounds(20, 40, 200, 50);
			AltaEdicion.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					AltaEdicion a = new AltaEdicion();
					a.setVisible(true);
				}
			});
			
			nuevaColocacion = new JButton();
			getContentPane().add(nuevaColocacion);
			nuevaColocacion.setText("Nueva Colocación");
			nuevaColocacion.setBounds(230, 40, 200, 50);
			nuevaColocacion.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					NuevaColocacion a=new NuevaColocacion();
					a.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					a.setVisible(true);
				}
			});
			
			
			Close = new JButton();
			getContentPane().add(Close);
			Close.setText("Salir");
			Close.setBounds(330, 120, 100, 40);
			Close.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent evt) 
				{
				   dispose();
				}
			});
		}
}