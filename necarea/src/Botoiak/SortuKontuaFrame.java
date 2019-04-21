package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class SortuKontuaFrame extends JFrame {

	private JPanel contentPane;
     
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortuKontuaFrame frame = new SortuKontuaFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortuKontuaFrame() {
		setBackground(new Color(0, 0, 255));
		setTitle("Kontua sortu");
		Necarea necarea=Necarea.getNecarea();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 254);
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
		
		JTextField textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSartu.setBackground(new Color(135, 206, 250));
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSartu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		panel_2.add(label_1);
		label_1.setForeground(Color.RED);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton button = new JButton("Kontua daukat. Saioa hasi");
		button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		button.setBackground(new Color(135, 206, 250));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblKontuaSortu = new JLabel("Kontua sortu");
		panel_3.add(lblKontuaSortu);
		lblKontuaSortu.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		
		
		//Sartu-ri ematean:
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setBackground(Color.WHITE);
				JPanel panel_2 = new JPanel();
				label_1.setText("");
				
				//Erabiltzailea hartu
				String hartuErabiltzaile=textField_1.getText().trim();
				int erabiltzailea=-1;
				if (textField_1.getText().length()==0) {
					label_1.setText("Ez duzu erabiltzailea sartu");
					textField_1.setBackground(Color.RED);
				}else{
					try {
						erabiltzailea=Integer.parseInt(hartuErabiltzaile);
					}catch(NumberFormatException nfe) {
					}
					
					if(erabiltzailea==-1) {
						label_1.setText("Zenbaki bat sartu behar duzu, ezin dira letrarik agertu");
						textField_1.setBackground(Color.RED);
					}else {
				
				boolean dago=necarea.pertsonaBilatu(erabiltzailea);
				
				
				//Dena ondo dago, erabiltzailea dagoen begiratu eta bestela sortu
				if (dago) {
						label_1.setText("Erabiltzaile hori hartuta dago jada, beste bat aukeratu");
						
				}else {
					necarea.erabiltzaileaGehitu(erabiltzailea);
					label_1.setText("Zure erabiltzailea sortu da. Defektuzko pasahitza erabiltzaile zenbakia izango da.");
					JButton btnSartu2 = new JButton("Saioa hasi");
					panel.add(btnSartu2);
					btnSartu2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
					btnSartu2.setBackground(new Color(135, 206, 250));
					btnSartu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnSartu2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							SartuKontuanFrame b= new SartuKontuanFrame();
							b.setVisible(true);
							dispose();
						}
					});
				}
			}
			}
			}
		});
			
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SartuKontuanFrame b=new SartuKontuanFrame();
				b.setVisible(true);
				dispose();	
			}
		});
		
		
	}
}