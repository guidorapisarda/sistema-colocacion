package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
import javax.swing.JTextField;

import persistencia.AdmPersistenciaEdicion;


//import Controlador.ControladorRRHH;;


public class BajaEdicion extends javax.swing.JFrame 
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private JLabel jLabel1;
		
		private JTextField codigoEdicion;
		
		private JButton cancelar;
		private JButton aceptar;
		
		private static BajaEdicion instancia;
		
		public static BajaEdicion getInstancia()
		{
			if (instancia == null)
				instancia = new BajaEdicion();
			return instancia;
		}
		
		//private ControladorRRHH controlador;

		public BajaEdicion(){
			super();
			initGUI();
			setSize(450, 200);
			//this.controlador=controlador;
		}
		
		private void initGUI() 
		{
			
				getContentPane().setLayout(null);
				
				
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Codigo Edicion:");
				jLabel1.setBounds(30, 36, 144, 16);
		
				codigoEdicion = new JTextField();
				getContentPane().add(codigoEdicion);
				codigoEdicion.setBounds(179, 36, 199, 23);

				
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(48, 100, 118, 23);
				aceptar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
						AdmPersistenciaEdicion.getInstancia().delete(Integer.parseInt(codigoEdicion.getText()));
						JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
					}
				});
				
				cancelar = new JButton();
				getContentPane().add(cancelar);
				cancelar.setText("Cancelar");
				cancelar.setBounds(224, 100, 118, 23);
				cancelar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
					dispose();
					}
				});
				
				
			} 
		
			
		}





