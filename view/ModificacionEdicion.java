package view;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Edicion;
import persistencia.AdmPersistenciaEdicion;


//import Controlador.Controlador;


	public class ModificacionEdicion extends javax.swing.JFrame 
		{
			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private JLabel jLabel1;
			private JLabel jLabel2;
			private JLabel jLabel3;
			private JLabel jLabel4;
			
			private JTextField codigoEdicion;
			private JTextField titulo;
			private JTextField precio;
			private JTextField fechaSalida;
			
			private JButton cancelar;
			private JButton aceptar;
		
			
			//private Controlador controlador;

			public ModificacionEdicion(){
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
					jLabel1.setText("Cod Edicion a Modificar:");
					jLabel1.setBounds(30, 36, 144, 16);
			
					codigoEdicion = new JTextField();
					getContentPane().add(codigoEdicion);
					codigoEdicion.setBounds(209, 36, 199, 23);

					jLabel2 = new JLabel();
					getContentPane().add(jLabel2);
					jLabel2.setText("Titulo:");
					jLabel2.setBounds(30, 76, 144, 16);
				
					titulo = new JTextField();
					getContentPane().add(titulo);
					titulo.setBounds(209, 76, 199, 23);
			
					jLabel3 = new JLabel();
					getContentPane().add(jLabel3);
					jLabel3.setText("Precio: ");
					jLabel3.setBounds(30, 116, 131, 16);
					
					precio = new JTextField();
					getContentPane().add(precio);
					precio.setBounds(209, 116, 199, 23);
					
					jLabel4 = new JLabel();
					getContentPane().add(jLabel4);
					jLabel4.setText("Fecha Salida:");
					jLabel4.setBounds(30, 156, 144, 16);
			
					fechaSalida = new JTextField();
					getContentPane().add(fechaSalida);
					fechaSalida.setBounds(209, 156, 199, 23);
					
					aceptar = new JButton();
					getContentPane().add(aceptar);
					aceptar.setText("Aceptar");
					aceptar.setBounds(48, 210, 118, 23);
					aceptar.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent evt) 
						{
							//Edicion e = new Edicion(Integer.parseInt(codigoEdicion.getText()), titulo.getText(), Float.parseFloat(precio.getText()), fechaSalida.getText(), 0);
							//AdmPersistenciaEdicion.getInstancia().update(e);
							JOptionPane.showMessageDialog(null, "Modificado Correctamente");
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
