package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;
import Klaseak.NecareaPelikulak;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Cursor;

public class WebFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args, int erabiltzaileId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebFrame frame = new WebFrame(erabiltzaileId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public WebFrame(int erabiltzaileId) throws IOException {
		Necarea necarea=Necarea.getNecarea();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnErabiltzaileId = new JButton("Erabiltzailea: "+erabiltzaileId);
		btnErabiltzaileId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnErabiltzaileId);
		
		JButton btnSaioaItxi = new JButton("Saioa itxi");
		btnSaioaItxi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSaioaItxi);
		
		JLabel lblKatalogoa = new JLabel("Katalogoa:");
		panel.add(lblKatalogoa);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		Vector elementuak= necarea.bektorePelikulak();
		JList list_1 = new JList(elementuak);
		panel_1.add(list_1);
		//para q se mueva pa abajo y pa arriba
		contentPane.add(new JScrollPane(list_1),null);
		pack(); 
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.add(btnSartu);
		
		//
		System.out.print(list_1.getSelectedIndex());
		//
		
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_1.getSelectedIndex()!=-1) {
					PelikulaFrame peli=new PelikulaFrame((String) list_1.getSelectedValue(), erabiltzaileId);
					peli.setVisible(true);
					dispose();
				}
				
				
			}
		});
		
		btnSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SarreraFrame b=null;
				try {
					b = new SarreraFrame();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b.setVisible(true);
				dispose();
				
			}
		});
		
		btnErabiltzaileId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KontuaFrame b=null;
				try {
					b = new KontuaFrame(erabiltzaileId);
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
