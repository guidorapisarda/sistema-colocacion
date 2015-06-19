package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
import javax.swing.JTextField;

import persistencia.AdmPersistenciaColocacion;
import persistencia.AdmPersistenciaEdicion;
import persistencia.AdmPersistenciaVendedor;
import model.Colocacion;
import model.SistemaColocacion;


//import Controlador.ControladorRRHH;;


public class ColocarEdicion extends javax.swing.JFrame 
	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	java.util.Date fecha = new Date();
	
		private JLabel jLabel1;
		private JLabel jLabel2;
		private JLabel jLabel3;
		
		private JTextField codigoEdicion;
		private JTextField cantidad;
		private JTextField fechaColoc;
		
		
		private JButton cancelar;
		private JButton aceptar;
		
		//private JComboBox estrategias;
		String[] strategies = {"Agotados", "Excedente", "Zona"};
	
		
		//private ControladorRRHH controlador;

		public ColocarEdicion(){
			super();
			initGUI();
			setSize(450, 280);
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

				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Cantidad:");
				jLabel2.setBounds(30, 76, 144, 16);
			
				cantidad = new JTextField();
				getContentPane().add(cantidad);
				cantidad.setBounds(179, 76, 199, 23);
		
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Fecha de Colocacion: ");
				jLabel3.setBounds(30, 116, 144, 16);
			
				fechaColoc = new JTextField();
				getContentPane().add(fechaColoc);
				fechaColoc.setBounds(179, 116, 199, 23);
				
				JLabel jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Estrategia: ");
				jLabel4.setBounds(30, 166, 144, 16);
			
				JComboBox estrategias = new JComboBox(strategies);
				getContentPane().add(estrategias);
				estrategias.setBounds(179, 166, 199, 23);
				
				aceptar = new JButton();
				getContentPane().add(aceptar);
				aceptar.setText("Aceptar");
				aceptar.setBounds(48, 210, 178, 23);
				aceptar.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
					Colocacion c = new Colocacion(Integer.parseInt(codigoEdicion.getText()), null, fechaColoc.getText(), Integer.parseInt(cantidad.getText()));
					int codPub = AdmPersistenciaEdicion.getInstancia().getCodPublicacion(Integer.parseInt(codigoEdicion.getText()));
					Vector<Object> idColocaciones = AdmPersistenciaColocacion.getInstancia().select3Colocaciones(codPub);
					Vector<Integer> idVendedores = AdmPersistenciaVendedor.getInstancia().buscarVendedor(idColocaciones);
					
					SistemaColocacion.getInstancia().agregarColocacion(c);
					SistemaColocacion.getInstancia().nuevaColocacion(Integer.parseInt(codigoEdicion.getText()), Integer.parseInt(cantidad.getText()), fechaColoc.getText(), null);
					JOptionPane.showMessageDialog(null, "Colocado Correctamente");
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
