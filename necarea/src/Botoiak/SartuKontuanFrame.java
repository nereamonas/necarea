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

public class SartuKontuanFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		Necarea necarea=Necarea.getNecarea();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		panel.add(lblErabiltzailea);
		
		//------------------------
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);


		//------------------------
		
		
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		panel.add(lblPasahitza);

		//------------------------
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		//------------------------
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSartu);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblSaioaHasi = new JLabel("Saioa hasi");
		lblSaioaHasi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSaioaHasi, BorderLayout.NORTH);
		
		
		//---------------
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Erbailtzailea hartu 
				String hartuErabiltzaile=textField_1.getText().trim();
				int erabiltzailea=-1;
				if (hartuErabiltzaile=="") {
					label.setText("Ez duzu erabiltzailea sartu");
					textField_1.setBackground(Color.RED);
				}else {
					erabiltzailea=Integer.parseInt(hartuErabiltzaile);
				}
				
				
				//Pasahitza hartu:
				String hartuPasahitza=textField.getText().trim();
				
				int pasahitza=-1;
				if (textField==null) {
					label.setText("Ez duzu pasahitza sartu");
					textField.setBackground(Color.RED);
				}else {
					pasahitza=Integer.parseInt(hartuPasahitza);
				}
				
				boolean dago=necarea.pertsonaBilatu(erabiltzailea);
				
				
				
				
				
				if (dago) {
					if(necarea.pasahitzaKonprobatu(erabiltzailea,pasahitza)) {
						WebFrame web=null;
						try {
							web = new WebFrame(erabiltzailea);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						web.setVisible(true);
						dispose();
						//habria que meterle un wait 3 segundos. y saltar a la pagina de que entra el usuario
					}else {
						label.setText("Pasahitza ez da egokia, berriro sahiatu");
						textField_1.setBackground(Color.RED);
						textField.setBackground(Color.RED);
						
					}
				}else {
					label.setText("Ez da erabiltzailea existitzen");
					JButton btnCrear = new JButton("Erabiltzailea sortu nahi duzu?");
					panel.add(btnCrear);
					btnCrear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							SortuKontuaFrame b=new SortuKontuaFrame();
							b.setVisible(true);
							dispose();
						}
					});
				}
				
				
			}
		
		});
		
		
	
	}

}
