package view;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import controller.EdicionController;
import controller.Sistema;

public class NuevaColocacion extends javax.swing.JFrame {
	
	private JLabel header;
	private JLabel LabelCodigo;
	private JLabel LabelTitulo;
	private JLabel LabelPrecio;
	private JLabel signoPesos;
	private JLabel LabelFechaSalida;
	private JLabel LabelTipo;
	private JLabel LabelPublicacion;
	private JLabel titulo;
	private JLabel precio;
	private JLabel publicacion;
	private JLabel tipo;
	private JLabel vendedor;
	private JLabel vendedorNombre;
	private JLabel fecha1;
	private JLabel fecha2;
	private JLabel fecha3;
	private JLabel fechaActual;
	private JLabel carga1;
	private JLabel devolucion1;
	private JLabel carga2;
	private JLabel devolucion2;
	private JLabel carga3;
	private JLabel devolucion3;
	
	private JTextField nuevaCarga;
	
	private JComboBox<String> codigoEdicion;
	
	private JButton buscar;
	private JButton cancelar;
	private JButton aceptar;
	
	public NuevaColocacion() {
		super();
		initGUI();
		setSize(700, 400);
	}
	
	private void initGUI() {
		
		getContentPane().setLayout(null);
		
		header = new JLabel();
		getContentPane().add(header);
		header.setText("Nueva Colocacion");
		header.setBounds(15, 22, 150, 16);
		
		ArrayList<String> ediciones = Sistema.fillComboEdiciones();
		Object[] edic = ediciones.toArray();
		codigoEdicion = new JComboBox(edic);
		getContentPane().add(codigoEdicion);
		codigoEdicion.setBounds(170, 15, 250, 30);
		
		buscar = new JButton();
		getContentPane().add(buscar);
		buscar.setText("Buscar");
		buscar.setBounds(425, 15, 75, 30);
		buscar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				
			}
		});
		
		vendedor = new JLabel();
		getContentPane().add(vendedor);
		vendedor.setText("Vendedor");
		vendedor.setBounds(15, 70, 150, 16);
		
		fecha1 = new JLabel();
		getContentPane().add(fecha1);
		fecha1.setText("Fecha 1");
		fecha1.setBounds(300, 70, 150, 16);
		
		fecha2 = new JLabel();
		getContentPane().add(fecha2);
		fecha2.setText("Fecha 2");
		fecha2.setBounds(600, 70, 150, 16);
		
		fecha3 = new JLabel();
		getContentPane().add(fecha3);
		fecha3.setText("Fecha 3");
		fecha3.setBounds(900, 70, 150, 16);
		
		fechaActual = new JLabel();
		getContentPane().add(fechaActual);
		fechaActual.setText("Actual");
		fechaActual.setBounds(1200, 70, 150, 16);
		
		vendedorNombre = new JLabel();
		getContentPane().add(fechaActual);
		vendedorNombre.setText("Nombre");
		vendedorNombre.setBounds(1200, 70, 150, 16);
		
		fechaActual = new JLabel();
		getContentPane().add(fechaActual);
		fechaActual.setText("Actual");
		fechaActual.setBounds(1200, 70, 150, 16);
		
		carga1 = new JLabel();
		getContentPane().add(carga1);
		carga1.setText("Carga");
		carga1.setBounds(250, 100, 100, 16);
		
		devolucion1 = new JLabel();
		getContentPane().add(devolucion1);
		devolucion1.setText("Devolucion");
		devolucion1.setBounds(350, 100, 100, 16);
		
		carga2 = new JLabel();
		getContentPane().add(carga2);
		carga2.setText("Carga");
		carga2.setBounds(550, 100, 100, 16);
		
		devolucion2 = new JLabel();
		getContentPane().add(devolucion2);
		devolucion2.setText("Devolucion");
		devolucion2.setBounds(650, 100, 100, 16);
		
		carga3 = new JLabel();
		getContentPane().add(carga3);
		carga3.setText("Carga");
		carga3.setBounds(850, 100, 100, 16);
		
		devolucion3 = new JLabel();
		getContentPane().add(devolucion3);
		devolucion3.setText("Devolucion");
		devolucion3.setBounds(950, 100, 150, 16);
		
		aceptar = new JButton();
		getContentPane().add(aceptar);
		aceptar.setText("Aceptar");
		aceptar.setBounds(150, 300, 125, 40);
		aceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				JOptionPane.showMessageDialog(null, "Agregado Correctamente");
			}
		});
		
		cancelar = new JButton();
		getContentPane().add(cancelar);
		cancelar.setText("Cancelar");
		cancelar.setBounds(25, 300, 125, 40);
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
	}
}
