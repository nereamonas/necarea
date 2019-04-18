package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Cursor;

public class PelikulaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String peli, int erabiltzaileId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PelikulaFrame frame = new PelikulaFrame(peli, erabiltzaileId);
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
	public PelikulaFrame(String peli, int erabiltzaileId) {
		Necarea necarea=Necarea.getNecarea();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblPelikula = new JLabel("Pelikula: "+peli);
		panel.add(lblPelikula);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		String s=necarea.pelikularenDatuakHartu(peli);
		JLabel lblDatuak = new JLabel(s);
		panel_1.add(lblDatuak);
		
		
		Boolean ikusiDu=necarea.pelikulaIkusiDu(erabiltzaileId,peli);
		JLabel label;
		if(ikusiDu) {
			label = new JLabel("Pelikula hau ikusi duzu");
		}else {
			label = new JLabel("Ez duzu pelikula hau ikusi");
		}
		panel_1.add(label);
		
		JButton btnAtzeraJoan = new JButton("Atzera joan");
		btnAtzeraJoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnAtzeraJoan, BorderLayout.SOUTH);
		
		btnAtzeraJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WebFrame b=null;
				try {
					b = new WebFrame(erabiltzaileId);
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
