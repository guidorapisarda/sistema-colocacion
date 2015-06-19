package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//import Controlador.ControladorRRHH;;


public class ModificarPauta extends javax.swing.JFrame 
	{
		private static final long serialVersionUID = 1L;
	
		java.util.Date fecha = new Date();
	
		private JLabel jLabel1;
		private JLabel jLabel2;
		private JLabel jLabel3;
		
		private JTextField codigoPauta;
		private JTextField nombre;
		private JTextField detalle;
		
		
		private JButton cancelar;
		private JButton aceptar;
	
		
		//private ControladorRRHH controlador;

		public ModificarPauta(){
			super();
			initGUI();
			setSize(450, 300);
			//this.controlador=controlador;
		}
		
		private void initGUI() 
		{
			
				getContentPane().setLayout(null);
				
				
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Cod Pauta a Modificar:");
				jLabel1.setBounds(30, 36, 144, 16);
		
				codigoPauta = new JTextField();
				getContentPane().add(codigoPauta);
				codigoPauta.setBounds(179, 36, 199, 23);

				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre:");
				jLabel2.setBounds(30, 76, 144, 16);
			
				nombre = new JTextField();
				getContentPane().add(nombre);
				nombre.setBounds(179, 76, 199, 23);
		
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Detalle: ");
				jLabel3.setBounds(30, 116, 131, 16);
				
				detalle = new JTextField();
				getContentPane().add(detalle);
				detalle.setBounds(179, 116, 199, 23);
				
		
				
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(48, 210, 118, 23);
				aceptar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
					//controlador.crear(codigoEdicion.getText(), titulo.getText(),Integer.parseInt(tipo.getText()), Integer.parseInt(editor.getText()),Integer.parseInt(tema.getText()), Integer.parseInt(subtema.getText()));
					JOptionPane.showMessageDialog(null, "Pauta modificada");
					}
				});
				
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(264, 210, 118, 23);
				cancelar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
					dispose();
					}
				});
				
				
			} 
		
			
		}