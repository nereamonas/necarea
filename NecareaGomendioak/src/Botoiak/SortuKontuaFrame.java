package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;
import java.awt.Color;
import java.awt.Cursor;

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
		Necarea necarea=Necarea.getNecarea();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblKontuaSortu = new JLabel("Kontua sortu");
		lblKontuaSortu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblKontuaSortu, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		panel.add(lblErabiltzailea);
		
		JTextField textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSartu);
		
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAtzeraJoan = new JButton("Atzera joan");
		btnAtzeraJoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnAtzeraJoan);
		
		
		//Sartu-ri ematean:
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String hartuErabiltzaile=textField_1.getText().trim();
				int erabiltzailea=Integer.parseInt(hartuErabiltzaile);
				
				boolean dago=necarea.pertsonaBilatu(erabiltzailea);
				
				if (dago) {
						label.setText("Erabiltzaile hori hartuta dago jada, beste bat aukeratu");
						
				}else {
					necarea.erabiltzaileaGehitu(erabiltzailea);
					label.setText("Zure erabiltzailea sortu da. Defektuzko pasahitza erabiltzaile zenbakia izango da.");
					JButton btnSartu = new JButton("Saioa hasi");
					panel.add(btnSartu);
					btnSartu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							SartuKontuanFrame b= new SartuKontuanFrame();
							b.setVisible(true);
							dispose();
						}
					});
				}
			}
		});
		
		btnAtzeraJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SarreraFrame b=null;
				try {
					b = new SarreraFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b.setVisible(true);
				dispose();
				
			}
		});
	}
}