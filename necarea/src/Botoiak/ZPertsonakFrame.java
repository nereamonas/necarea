package Botoiak;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ZPertsonakFrame extends JFrame { 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZPertsonakFrame frame = new ZPertsonakFrame();
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
	public ZPertsonakFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnErregistratutakoPertsonaGuztiak = new JButton("Erregistratutako pertsona guztiak erakutsi");
		btnErregistratutakoPertsonaGuztiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZErregistratutakoPertsonaGuztiakFrame epgf;
				try {
					epgf = new ZErregistratutakoPertsonaGuztiakFrame();
					epgf.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnErregistratutakoPertsonaGuztiak);
		btnErregistratutakoPertsonaGuztiak.setFont(new Font("MS Gothic", Font.BOLD, 14));
		btnErregistratutakoPertsonaGuztiak.setBackground(Color.PINK);
		
		JButton btnPertsonarenInformazioa = new JButton("1 pertsonaren informazioa erakutsi");
		btnPertsonarenInformazioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZPertsonarenInformazioaFrame pif;
				try {
					pif = new ZPertsonarenInformazioaFrame();
					pif.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnPertsonarenInformazioa);
		btnPertsonarenInformazioa.setFont(new Font("MS Gothic", Font.BOLD, 14));
		btnPertsonarenInformazioa.setBackground(Color.PINK);
	}

}
