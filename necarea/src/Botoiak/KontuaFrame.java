 package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Cursor;

public class KontuaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int erabiltzaileId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontuaFrame frame = new KontuaFrame(erabiltzaileId);
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
	public KontuaFrame(int erabiltzaileId) throws IOException {
		Necarea necarea=Necarea.getNecarea();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblErabiltzaile = new JLabel("Erabiltzaile:"+erabiltzaileId);
		panel.add(lblErabiltzaile);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblIkusitakoPelikulak = new JLabel("Ikusitako pelikulak:");
		panel_1.add(lblIkusitakoPelikulak);
		
		Vector ikusiPeli = necarea.ikusitakoPelikulak(erabiltzaileId);
		
		
		JList list = new JList(ikusiPeli);
		panel_1.add(list);
		contentPane.add(new JScrollPane(list),null);
		pack(); 
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblGehienGuztatukoZaizkion = new JLabel("Gehien guztatuko zaizkion 10 pelikulak:");
		panel_2.add(lblGehienGuztatukoZaizkion);
		
		JList list_1 = new JList();
		panel_2.add(list_1);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JButton btnSartuPelikulan = new JButton("Sartu Pelikulan");
		btnSartuPelikulan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(btnSartuPelikulan);
		
		btnSartuPelikulan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()!=-1) {
					PelikulaFrame peli=new PelikulaFrame((String) list.getSelectedValue(), erabiltzaileId);
					peli.setVisible(true);
					dispose();
				}
			}
		});
		
		JButton btnAtzeraJoan = new JButton("Atzera joan");
		btnAtzeraJoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(btnAtzeraJoan);
		
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
