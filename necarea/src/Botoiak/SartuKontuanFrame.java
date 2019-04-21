package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.border.BevelBorder;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;

public class SartuKontuanFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField pwdLll;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SartuKontuanFrame frame = new SartuKontuanFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public SartuKontuanFrame(){
		setTitle("Saioa hasi");
		Necarea necarea=Necarea.getNecarea();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 229);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		panel.add(lblErabiltzailea);
		
		//------------------------
		
		textField_1 = new JTextField();
		
		panel.add(textField_1);
		textField_1.setColumns(10);


		//------------------------
		
		
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		panel.add(lblPasahitza);
		
		//--------------------------
		
		pwdLll = new JPasswordField();
		pwdLll.setColumns(10);
		panel.add(pwdLll);

		//------------------------
	
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator);

		//------------------------
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSartu.setBackground(new Color(135, 206, 250));
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSartu);
		
		JLabel label = new JLabel("");
		panel.add(label);
		label.setForeground(Color.RED);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnEzDutKonturik = new JButton("Ez dut konturik.  Kontua sortu");
		btnEzDutKonturik.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnEzDutKonturik.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEzDutKonturik.setBackground(new Color(135, 206, 250));
		panel_2.add(btnEzDutKonturik);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblSaioaHasi = new JLabel("Saioa hasi");
		panel_3.add(lblSaioaHasi);
		lblSaioaHasi.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		
		
		//---------------
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setBackground(Color.WHITE);
				pwdLll.setBackground(Color.WHITE);
				label.setText("");
				JPanel panel_1 = new JPanel();
				
				//Erbailtzailea hartu 
				String hartuErabiltzaile=textField_1.getText().trim();
				int erabiltzailea=-1;
				if (textField_1.getText().length()==0) {
					label.setText("Ez duzu erabiltzailea sartu");
					textField_1.setBackground(Color.RED);
				}else {
					try {
						erabiltzailea=Integer.parseInt(hartuErabiltzaile);
					}catch(NumberFormatException nfe) {
					}
					if(erabiltzailea==-1) {
						label.setText("Zenbaki bat sartu behar duzu, ezin dira letrarik agertu");
						textField_1.setBackground(Color.RED);
					}else {
				
				
				
					//Pasahitza hartu:
					String hartuPasahitza=pwdLll.getText().trim();
				
					int pasahitza=-1;
					if (pwdLll.getText().length()==0) {
						label.setText("Ez duzu pasahitza sartu");
						pwdLll.setBackground(Color.RED);
					}else {
						
						try {
							pasahitza=Integer.parseInt(hartuPasahitza);
						}catch(NumberFormatException nfe) {
							
						}
						if(pasahitza==-1) {
							label.setText("Zenbaki bat sartu behar duzu, ezin dira letrarik agertu");
							pwdLll.setBackground(Color.RED);
						}else {
						
				
				    //2ak ondo sartu dira.
						boolean dago=necarea.pertsonaBilatu(erabiltzailea);
						if (dago) {
							if(necarea.pasahitzaKonprobatu(erabiltzailea,pasahitza)) {
								WebFrame web= new WebFrame(erabiltzailea,pasahitza);

								web.setVisible(true);
								dispose();
								//habria que meterle un wait 3 segundos. y saltar a la pagina de que entra el usuario
							}else {
								label.setText("Pasahitza ez da egokia, berriro sahiatu");
								textField_1.setBackground(Color.RED);
								pwdLll.setBackground(Color.RED);
							}
						}else {
							label.setText("Ez da erabiltzailea existitzen");
							JButton btnCrear = new JButton("Erabiltzailea sortu nahi duzu?");
							panel_1.add(btnCrear);
							btnCrear.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									SortuKontuaFrame b=new SortuKontuaFrame();
									b.setVisible(true);
									dispose();
								}
					});
				}
				}
					}
					}
				
				}
			}
		
		});
		
		//-------------
		btnEzDutKonturik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SortuKontuaFrame sortu= new SortuKontuaFrame();
				sortu.setVisible(true);
				dispose();
		
			}
		});
		
	
	}

}
