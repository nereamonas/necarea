package Botoiak;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Klaseak.NecareaPelikulak;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZPelikulakFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZPelikulakFrame frame = new ZPelikulakFrame();
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
	public ZPelikulakFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		

		
		Vector elementuak= NecareaPelikulak.getNecareaPelikulak().bektorePelikulak();
		JList list=new JList(elementuak);
		contentPane.add(list, BorderLayout.WEST);
		
		JLabel lblHauekDiraNecarea = new JLabel("Hauek dira Necarea programak erabilgarri dituen pelikula guztiak:");
		lblHauekDiraNecarea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblHauekDiraNecarea, BorderLayout.NORTH);
		
		JButton btnHasierakoMenuraBueltatu = new JButton("Hasierako menura itzuli");
		btnHasierakoMenuraBueltatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZMainBotoiak b=new ZMainBotoiak();
				b.setVisible(true);
				
			}
		});
		btnHasierakoMenuraBueltatu.setBackground(Color.MAGENTA);
		contentPane.add(btnHasierakoMenuraBueltatu, BorderLayout.SOUTH);
		
		
		//jaisteko guztiak ikusteko
		contentPane.add(new JScrollPane(list),null);
		pack(); 
		
	}

}
