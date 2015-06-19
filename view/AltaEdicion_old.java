package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Edicion;
import model.Publicacion;
import model.SistemaColocacion;

public class AltaEdicion_old extends javax.swing.JFrame 
	{
		static final long serialVersionUID = 42L;	
		java.util.Date fecha = new Date();
		private JLabel jLabel1;
		private JLabel jLabel2;
		private JLabel jLabel3;
		private JLabel jLabel4;
		private JLabel jLabel6;
		private JTextField codigoPublicacion;
		private JTextField titulo;
		private JTextField precio;
		private JTextField fechaSalida;
		private JButton cancelar;
		private JButton aceptar;
	
		private static AltaEdicion_old instancia;
		private SistemaColocacion controlador;
			
		public static AltaEdicion_old getInstancia()
		{
			if (instancia == null)
				instancia = new AltaEdicion_old();
			return instancia;
		}

		public AltaEdicion_old(){
			super();
			initGUI();
			setSize(450, 350);
		}
		
		private void initGUI() 
		{
				getContentPane().setLayout(null);
				
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Codigo Publicacion:");
				jLabel1.setBounds(30, 36, 144, 16);
		
				codigoPublicacion = new JTextField();
				getContentPane().add(codigoPublicacion);
				codigoPublicacion.setBounds(179, 36, 199, 23);
				
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Titulo:");
				jLabel2.setBounds(30, 76, 144, 16);
			
				titulo = new JTextField();
				getContentPane().add(titulo);
				titulo.setBounds(179, 76, 199, 23);
		
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Precio: ");
				jLabel3.setBounds(30, 116, 131, 16);
				
				precio = new JTextField();
				getContentPane().add(precio);
				precio.setBounds(179, 116, 199, 23);
				
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Fecha Salida:");
				jLabel4.setBounds(30, 156, 144, 16);
				
				fechaSalida = new JTextField();
				getContentPane().add(fechaSalida);
				fechaSalida.setBounds(179, 156, 199, 23);
		
				jLabel6= new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Codigo Publicacion:");
				jLabel6.setBounds(30, 196, 144, 16);

				/*publicacion=new JComboBox ();
				getContentPane().add(publicacion);
				publicacion.addItem("5");
				publicacion.addItem("6");
				publicacion.addItem("7");
				publicacion.addItem("8");
				publicacion.setBounds(179, 196, 199, 23);*/
				
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(48, 240, 118, 23);
				aceptar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
					//Edicion e = new Edicion(titulo.getText(), Float.parseFloat(precio.getText()), fechaSalida.getText(), Integer.parseInt(codigoPublicacion.getText()));
					Publicacion p = null;
					p = controlador.buscarPublicacion(titulo.getText());
					//p.addEdicion(e);
					JOptionPane.showMessageDialog(null, "Agregado Correctamente");
					}
				});
				
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(264, 240, 118, 23);
				cancelar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
					dispose();
					}
				});
			} 	
		}