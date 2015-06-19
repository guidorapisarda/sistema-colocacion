package view;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import controller.EdicionController;

public class AltaEdicion extends javax.swing.JFrame {
		
	private JLabel header;
	private JLabel LabelCodigo;
	private JLabel LabelTitulo;
	private JLabel LabelPrecio;
	private JLabel signoPesos;
	private JLabel LabelFechaSalida;
	
	private JComboBox codigoPublicacion;
	private JTextField titulo;
	private JTextField precio;
	private JTextField fechaSalida;
	
	private JButton cancelar;
	private JButton aceptar;
	
	java.util.Date fecha = new Date();
	
	public AltaEdicion() {
		super();
		initGUI();
		setSize(300, 350);
	}
		
	private void initGUI() {
			
		getContentPane().setLayout(null);
		
		header = new JLabel();
		getContentPane().add(header);
		header.setText("Alta Edicion");
		header.setBounds(15, 15, 150, 16);
		
		LabelCodigo = new JLabel();
		getContentPane().add(LabelCodigo);
		LabelCodigo.setText("Codigo");
		LabelCodigo.setBounds(15, 50, 170, 16);
		
		ArrayList<String> publicaciones = EdicionController.fillComboPublicaciones();
		Object[] pub = publicaciones.toArray();
		codigoPublicacion = new JComboBox(pub);
		getContentPane().add(codigoPublicacion);
		codigoPublicacion.setBounds(12, 70, 270, 30);

		LabelTitulo = new JLabel();
		getContentPane().add(LabelTitulo);
		LabelTitulo.setText("Titulo");
		LabelTitulo.setBounds(15, 100, 144, 16);
	
		titulo = new JTextField();
		getContentPane().add(titulo);
		titulo.setBounds(12, 120, 270, 23);
		
		LabelFechaSalida = new JLabel();
		getContentPane().add(LabelFechaSalida);
		LabelFechaSalida.setText("Fecha de salida");
		LabelFechaSalida.setBounds(15, 150, 144, 16);

		fechaSalida = new JTextField();
		getContentPane().add(fechaSalida);
		fechaSalida.setText(fecha.toString());
		fechaSalida.setBounds(12, 170, 270, 30);

		LabelPrecio = new JLabel();
		getContentPane().add(LabelPrecio);
		LabelPrecio.setText("Precio");
		LabelPrecio.setBounds(15, 200, 131, 16);
		
		signoPesos = new JLabel();
		getContentPane().add(signoPesos);
		signoPesos.setText("$");
		signoPesos.setBounds(17, 222, 131, 16);
		
		precio = new JTextField();
		getContentPane().add(precio);
		precio.setBounds(30, 220, 252, 23);
		
		aceptar = new JButton();
		getContentPane().add(aceptar);
		aceptar.setText("Aceptar");
		aceptar.setBounds(150, 260, 125, 40);
		aceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				String codPub = codigoPublicacion.getSelectedItem().toString();
				String[] parts = codPub.split(" ");
				String cod = parts[0];
				EdicionController.AltaEdicion(Integer.parseInt(cod), titulo.getText(), Float.parseFloat(precio.getText()), fechaSalida.getText());
				JOptionPane.showMessageDialog(null, "La edición fue creada con éxito.");
			}
		});
		
		cancelar = new JButton();
		getContentPane().add(cancelar);
		cancelar.setText("Cancelar");
		cancelar.setBounds(25, 260, 125, 40);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
	}
}




