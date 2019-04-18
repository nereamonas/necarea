package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Component;

public class SarreraFrame extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SarreraFrame frame = new SarreraFrame();
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
	public SarreraFrame() throws FileNotFoundException {
		setTitle("Necarea");
		
		Necarea necarea=Necarea.getNecarea();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
		JLabel lblNecareaPelikulak = new JLabel("NECAREA PELIKULAK");
		lblNecareaPelikulak.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		contentPane.add(lblNecareaPelikulak, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnSaioaHasi = new JButton("Saioa hasi");
		btnSaioaHasi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnSaioaHasi);
		btnSaioaHasi.setBackground(new Color(135, 206, 250));
		btnSaioaHasi.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		//Saioa hasi-ri ematean:
		btnSaioaHasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SartuKontuanFrame sartuKontuan = new SartuKontuanFrame();
				sartuKontuan.setVisible(true);
				dispose();
			}
		});
		
		JButton btnKontuaSortu = new JButton("Kontua sortu");
		btnKontuaSortu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnKontuaSortu);
		btnKontuaSortu.setBackground(new Color(135, 206, 250));
		btnKontuaSortu.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		//Kontua sortu-ri ematean:
		btnKontuaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SortuKontuaFrame sortuKontu =  new SortuKontuaFrame();

				sortuKontu.setVisible(true);
				dispose();
			}
		});
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}