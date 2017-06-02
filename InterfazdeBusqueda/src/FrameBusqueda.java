import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameBusqueda {

	private JFrame frame2;
	private JTextField txtnombre;
	private JTextField txtsalario;
	private JTextField txtpuesto;
	private JTextField txtdesde;
	private JTextField txthasta;
	private JLabel lblBusquedadeempleados;
	private JLabel lblBuscarPor;
	private JLabel lblnombre;
	private JButton btnpuesto;
	private JLabel lblsalario;
	private JButton btnsalario;
	private JLabel lblpuesto;
	private JLabel lblantiguedad;
	private JLabel lbldesde;
	private JLabel lblHasta;

	private LinkedList<Empleado> empleados;
	private JRadioButton radiosalario;
	private JRadioButton radiopuesto;
	private JRadioButton radioantiguedad;
	private JButton btnnombre;
	private JButton btnantiguedad;
	private JRadioButton radionombre;

	private JLabel lblnombre2;
	private JLabel lblsalario2;
	private JLabel lblpuesto2;
	private JLabel lblantiguedad2;
	private JLabel lblnombre3;
	private JLabel lblsalario3;
	private JLabel lblpuesto3;
	private JLabel lblantiguedad3;
	private ListIterator<Empleado> it;
	private JButton next;
	private JButton prev;
	private LinkedList<Empleado> amigos;

	public FrameBusqueda() {

		frame2 = new JFrame();
		frame2.getContentPane().setBackground(UIManager.getColor("CheckBox.select"));
		txtnombre = new JTextField();
		txtsalario = new JTextField();
		txtpuesto = new JTextField();
		txtdesde = new JTextField();
		txthasta = new JTextField();
		lblBusquedadeempleados = new JLabel("BUSQUEDA DE EMPLEADOS");

		lblBuscarPor = new JLabel("Buscar por:");
		lblnombre = new JLabel("Introduzca el nombre:");
		btnpuesto = new JButton("Buscar");
		lblsalario = new JLabel("Introduzca el salario:");
		btnsalario = new JButton("Buscar");
		lblpuesto = new JLabel("Seleccione el puesto:");
		lblantiguedad = new JLabel("Seleccione antiguedad:");
		lbldesde = new JLabel("desde");
		lblHasta = new JLabel("hasta");

		radiosalario = new JRadioButton("Salario");

		radiopuesto = new JRadioButton("Puesto");
		radioantiguedad = new JRadioButton("Antiguedad");
		btnnombre = new JButton("Buscar");
		btnantiguedad = new JButton("Buscar");
		radionombre = new JRadioButton("Nombre");
		empleados = new LinkedList<Empleado>();
		lblnombre2 = new JLabel("NOMBRE");
		lblsalario2 = new JLabel("SALARIO");
		lblpuesto2 = new JLabel("PUESTO");
		lblantiguedad2 = new JLabel("ANTIGUEDAD");
		lblnombre3 = new JLabel("");
		lblnombre3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblsalario3 = new JLabel("");
		lblsalario3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblpuesto3 = new JLabel("");
		lblpuesto3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblantiguedad3 = new JLabel("");
		lblantiguedad3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		amigos = new LinkedList<Empleado>();
		
		next = new JButton("NEXT");
		prev = new JButton("PREV");
		

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		propiedades();
		creacionempleados();
		eventos();
	}

	public JFrame getFrame2() {

		return frame2;
	}

	private void propiedades() {

		frame2.setBounds(100, 100, 726, 506);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 12));
		frame2.getContentPane().setLayout(null);

		frame2.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 12));
		frame2.getContentPane().setLayout(null);

		lblBusquedadeempleados.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBusquedadeempleados.setBounds(99, 24, 221, 14);
		frame2.getContentPane().add(lblBusquedadeempleados);

		lblBuscarPor.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		lblBuscarPor.setBounds(10, 63, 71, 14);
		frame2.getContentPane().add(lblBuscarPor);

		txtnombre.setVisible(false);
		txtnombre.setBounds(116, 132, 86, 20);
		frame2.getContentPane().add(txtnombre);

		txtnombre.setColumns(10);
		lblnombre.setVisible(false);
		lblnombre.setFont(new Font("Footlight MT Light", Font.ITALIC, 12));
		lblnombre.setBounds(103, 107, 119, 14);
		frame2.getContentPane().add(lblnombre);

		lblsalario.setVisible(false);
		lblsalario.setFont(new Font("Footlight MT Light", Font.ITALIC, 12));
		lblsalario.setBounds(242, 107, 118, 14);
		frame2.getContentPane().add(lblsalario);

		txtsalario.setVisible(false);
		txtsalario.setBounds(253, 132, 86, 20);
		frame2.getContentPane().add(txtsalario);
		txtsalario.setColumns(10);

		btnsalario.setVisible(false);
		btnsalario.setBounds(266, 176, 67, 21);
		frame2.getContentPane().add(btnsalario);

		lblpuesto.setVisible(false);
		lblpuesto.setFont(new Font("Footlight MT Light", Font.ITALIC, 12));
		lblpuesto.setBounds(384, 107, 107, 14);
		frame2.getContentPane().add(lblpuesto);

		txtpuesto.setVisible(false);
		txtpuesto.setBounds(394, 132, 85, 20);
		frame2.getContentPane().add(txtpuesto);
		txtpuesto.setColumns(10);

		btnpuesto.setVisible(false);
		btnpuesto.setBounds(407, 175, 65, 22);
		frame2.getContentPane().add(btnpuesto);

		lblantiguedad.setVisible(false);
		;
		lblantiguedad.setFont(new Font("Footlight MT Light", Font.ITALIC, 11));
		lblantiguedad.setBounds(546, 107, 128, 14);
		frame2.getContentPane().add(lblantiguedad);

		txtdesde.setVisible(false);
		txtdesde.setBounds(570, 132, 86, 20);
		frame2.getContentPane().add(txtdesde);
		txtdesde.setColumns(10);

		txthasta.setVisible(false);
		txthasta.setBounds(570, 155, 86, 20);
		frame2.getContentPane().add(txthasta);
		txthasta.setColumns(10);

		lbldesde.setVisible(false);
		lbldesde.setFont(new Font("Footlight MT Light", Font.ITALIC, 12));
		lbldesde.setBounds(527, 136, 46, 14);
		frame2.getContentPane().add(lbldesde);

		lblHasta.setVisible(false);
		lblHasta.setFont(new Font("Footlight MT Light", Font.ITALIC, 12));
		lblHasta.setBounds(527, 159, 46, 14);
		frame2.getContentPane().add(lblHasta);

		radiosalario.setBounds(253, 77, 109, 23);
		frame2.getContentPane().add(radiosalario);

		radiopuesto.setBounds(393, 81, 86, 14);
		frame2.getContentPane().add(radiopuesto);

		radioantiguedad.setBounds(552, 77, 109, 23);
		frame2.getContentPane().add(radioantiguedad);

		btnnombre.setVisible(false);
		btnnombre.setBounds(127, 176, 67, 21);
		frame2.getContentPane().add(btnnombre);

		btnantiguedad.setVisible(false);
		btnantiguedad.setBounds(580, 186, 67, 23);
		frame2.getContentPane().add(btnantiguedad);

		radionombre.setBounds(99, 77, 141, 23);
		frame2.getContentPane().add(radionombre);

		lblnombre2.setBounds(141, 249, 61, 16);
		frame2.getContentPane().add(lblnombre2);
		lblnombre2.setVisible(false);

		lblsalario2.setVisible(false);
		lblsalario2.setBounds(266, 249, 61, 16);
		frame2.getContentPane().add(lblsalario2);

		lblpuesto2.setVisible(false);
		lblpuesto2.setBounds(411, 249, 61, 16);
		frame2.getContentPane().add(lblpuesto2);

		lblantiguedad2.setVisible(false);
		lblantiguedad2.setBounds(561, 249, 86, 16);
		frame2.getContentPane().add(lblantiguedad2);

		lblnombre3.setVisible(false);
		lblnombre3.setBounds(141, 304, 61, 16);
		frame2.getContentPane().add(lblnombre3);

		lblsalario3.setVisible(false);
		lblsalario3.setBounds(266, 304, 61, 16);
		frame2.getContentPane().add(lblsalario3);

		lblpuesto3.setVisible(false);
		lblpuesto3.setBounds(394, 304, 107, 16);
		frame2.getContentPane().add(lblpuesto3);

		lblantiguedad3.setVisible(false);
		lblantiguedad3.setBounds(571, 304, 85, 16);
		frame2.getContentPane().add(lblantiguedad3);

		next.setBounds(56, 244, 59, 29);
		frame2.getContentPane().add(next);
		next.setVisible(false);

		prev.setVisible(false);
		prev.setBounds(10, 244, 59, 29);
		frame2.getContentPane().add(prev);
		
	
		

		

	}

	private void eventos() {
		
		radionombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (radionombre.isSelected()) {

					lblnombre.setVisible(true);
					txtnombre.setVisible(true);
					btnnombre.setVisible(true);
					radiosalario.setVisible(false);
					radioantiguedad.setVisible(false);
					radiopuesto.setVisible(false);
				} else {

					lblnombre.setVisible(false);
					txtnombre.setVisible(false);
					btnnombre.setVisible(false);
					radiosalario.setVisible(true);
					radioantiguedad.setVisible(true);
					radiopuesto.setVisible(true);
					next.setVisible(false);
					prev.setVisible(false);
					lblnombre2.setVisible(false);
					lblsalario2.setVisible(false);
					lblpuesto2.setVisible(false);
					lblantiguedad2.setVisible(false);

				}

			}
		});
		radioantiguedad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (radioantiguedad.isSelected()) {

					lblantiguedad.setVisible(true);
					lbldesde.setVisible(true);
					lblHasta.setVisible(true);
					btnantiguedad.setVisible(true);
					txtdesde.setVisible(true);
					txthasta.setVisible(true);
					radiosalario.setVisible(false);
					radionombre.setVisible(false);
					radiopuesto.setVisible(false);
				} else {

					lblantiguedad.setVisible(false);
					lbldesde.setVisible(false);
					lblHasta.setVisible(false);
					txtdesde.setVisible(false);
					txthasta.setVisible(false);
					btnantiguedad.setVisible(false);
					radiosalario.setVisible(true);
					radionombre.setVisible(true);
					radiopuesto.setVisible(true);
					next.setVisible(false);
					prev.setVisible(false);
					lblnombre2.setVisible(false);
					lblsalario2.setVisible(false);
					lblpuesto2.setVisible(false);
					lblantiguedad2.setVisible(false);

				}

			}
		});
		radiosalario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (radiosalario.isSelected()) {

					lblsalario.setVisible(true);
					txtsalario.setVisible(true);
					btnsalario.setVisible(true);
					radioantiguedad.setVisible(false);
					radionombre.setVisible(false);
					radiopuesto.setVisible(false);
				} else {

					lblsalario.setVisible(false);
					txtsalario.setVisible(false);
					btnsalario.setVisible(false);
					radioantiguedad.setVisible(true);
					radionombre.setVisible(true);
					radiopuesto.setVisible(true);
					next.setVisible(false);
					prev.setVisible(false);
					lblnombre2.setVisible(false);
					lblsalario2.setVisible(false);
					lblpuesto2.setVisible(false);
					lblantiguedad2.setVisible(false);

				}
			}
		});
		radiopuesto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (radiopuesto.isSelected()) {

					radioantiguedad.setVisible(false);
					radionombre.setVisible(false);
					radiosalario.setVisible(false);
					lblpuesto.setVisible(true);
					txtpuesto.setVisible(true);
					btnpuesto.setVisible(true);
				} else {

					lblpuesto.setVisible(false);
					txtpuesto.setVisible(false);
					btnpuesto.setVisible(false);
					radioantiguedad.setVisible(true);
					radionombre.setVisible(true);
					radiosalario.setVisible(true);
					next.setVisible(false);
					prev.setVisible(false);
					lblnombre2.setVisible(false);
					lblsalario2.setVisible(false);
					lblpuesto2.setVisible(false);
					lblantiguedad2.setVisible(false);

				}
			}

		});
		btnpuesto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for (Empleado x : empleados) {

					if (x.getPuesto().equals(txtpuesto.getText())) {

						lblnombre2.setVisible(true);
						lblsalario2.setVisible(true);
						lblpuesto2.setVisible(true);
						lblantiguedad2.setVisible(true);
						lblnombre3.setVisible(true);
						lblsalario3.setVisible(true);
						lblpuesto3.setVisible(true);
						lblantiguedad3.setVisible(true);
						next.setVisible(true);
						prev.setVisible(true);

						amigos.add(x);
						it = amigos.listIterator();
					}

				}
				if (amigos.size() == 0) {
					JOptionPane.showMessageDialog(frame2, "No tenemos ningun empleado con ese puesto");

				}

			}
		});

		btnsalario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for (Empleado x : empleados) {

					if (String.valueOf(x.getSalario()).equals(String.valueOf(txtsalario.getText()))) {

						lblnombre2.setVisible(true);
						lblsalario2.setVisible(true);
						lblpuesto2.setVisible(true);
						lblantiguedad2.setVisible(true);
						lblnombre3.setVisible(true);
						lblsalario3.setVisible(true);
						lblpuesto3.setVisible(true);
						lblantiguedad3.setVisible(true);
						next.setVisible(true);
						prev.setVisible(true);

						amigos.add(x);
						it = amigos.listIterator();
					}
				}
				if (amigos.size() == 0) {
					JOptionPane.showMessageDialog(frame2, "No tenemos ningun empleado con ese salario");

				}
			}
		});
		btnnombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for (Empleado x : empleados) {

					
					
					if (x.getNombre().equals(txtnombre.getText())) {

						lblnombre2.setVisible(true);
						lblsalario2.setVisible(true);
						lblpuesto2.setVisible(true);
						lblantiguedad2.setVisible(true);
						lblnombre3.setVisible(true);
						lblsalario3.setVisible(true);
						lblpuesto3.setVisible(true);
						lblantiguedad3.setVisible(true);
						next.setVisible(true);
						prev.setVisible(true);

						
						amigos.add(x);
						it = amigos.listIterator();
						
						

						lblnombre3.setText(amigos.get(0).getNombre());
						lblsalario3.setText(amigos.get(0).getPuesto());
						lblpuesto3.setText(amigos.get(0).getPuesto());
						lblantiguedad.setText(String.valueOf(amigos.get(0).getAntiguedad()));
					}

				}
				if (amigos.size() == 0) {
					JOptionPane.showMessageDialog(frame2, "No tenemos ningun empleado con ese nombre");

				}

			}
		});
		btnantiguedad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int tiempo = 0;
				int tiempo2 = 0;
				try {
					tiempo = Integer.parseInt(txtdesde.getText());
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(frame2, "Debe introducir el numero de años de experiencia");
				}
				try {
					tiempo2 = Integer.parseInt(txthasta.getText());
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(frame2, "Debe introducir el numero de años de experiencia");
				}

				for (Empleado x : empleados) {

					if (x.getAntiguedad() >= tiempo && x.getAntiguedad() <= tiempo2) {

						lblnombre2.setVisible(true);
						lblsalario2.setVisible(true);
						lblpuesto2.setVisible(true);
						lblantiguedad2.setVisible(true);
						lblnombre3.setVisible(true);
						lblsalario3.setVisible(true);
						lblpuesto3.setVisible(true);
						lblantiguedad3.setVisible(true);
						next.setVisible(true);
						prev.setVisible(true);

						amigos.add(x);
						it = amigos.listIterator();
					}
					
				}
				if (amigos.size() == 0) {
					JOptionPane.showMessageDialog(frame2, "No tenemos a nadie con esa experiencia");

				}

			}
		});
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (it.hasNext()){

					Empleado amiguiño = it.next();
					lblnombre3.setText(amiguiño.getNombre());
					lblsalario3.setText(String.valueOf(amiguiño.getSalario()));	
					lblantiguedad3.setText(String.valueOf(amiguiño.getAntiguedad()));
					lblpuesto3.setText(amiguiño.getPuesto());
					

				} else {

					JOptionPane.showMessageDialog(frame2, "No disponemos de mas empleados");
				}
			}
		});
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(it.hasPrevious()){
					
					Empleado x=it.previous();
					
				
					lblnombre3.setText(x.getNombre());
					lblsalario3.setText(String.valueOf(x.getSalario()));
					lblantiguedad3.setText(String.valueOf(x.getAntiguedad()));
					lblpuesto3.setText(x.getPuesto());
					

				} else {

					JOptionPane.showMessageDialog(frame2, "No disponemos de menos empleados");
				}
					
				}
			
		});
	}

	private void creacionempleados() {

		empleados.add(new Empleado("pepe", 1580, 5, "contable"));
		empleados.add(new Empleado("panolo", 2200.90f, 6, "programador"));
		empleados.add(new Empleado("paco", 1000f, 1, "RRHH"));
		empleados.add(new Empleado("filomeno", 1480.50f, 2, "contable"));
		empleados.add(new Empleado("brais", 1380.90f, 3, "programador"));
		empleados.add(new Empleado("jose", 1200.20f, 8, "programador"));
		empleados.add(new Empleado("cristina", 1570, 5, "RRHH"));
		empleados.add(new Empleado("alberto", 2230.90f, 6, "programador"));
		empleados.add(new Empleado("Paco", 1000f, 1, "RRHH"));
		empleados.add(new Empleado("filomeno", 1480.50f, 2, "contable"));
		empleados.add(new Empleado("brais", 1380.90f, 3, "programador"));
		empleados.add(new Empleado("Pepe", 1200.20f, 8, "programador"));
		empleados.add(new Empleado("pepe", 150, 5, "contable"));
		empleados.add(new Empleado("panolo", 2200.90f, 6, "programador"));
		empleados.add(new Empleado("paco", 1004440f, 1, "RRHH"));
		empleados.add(new Empleado("filomeno", 3456.50f, 2, "contable"));
		empleados.add(new Empleado("brais", 1380.90f, 3, "RRHH"));
		empleados.add(new Empleado("jose", 1200.20f, 8, "contable"));
		empleados.add(new Empleado("cristina", 1570, 5, "RRHH"));
		empleados.add(new Empleado("alberto", 2230.90f, 6, "programador"));
		empleados.add(new Empleado("paco", 1500f, 1, "RRHH"));
		empleados.add(new Empleado("filomeno", 1480.50f, 2, "contable"));
		empleados.add(new Empleado("brais", 1380.90f, 3, "programador"));
		empleados.add(new Empleado("Pepe", 1200.20f, 8, "programador"));
		
		
		

	}
}
