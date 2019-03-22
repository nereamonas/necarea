import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ZMainBotoiak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZMainBotoiak frame = new ZMainBotoiak();
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
	public ZMainBotoiak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnPelikula = new JButton("Pelikula");
		btnPelikula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZPelikulakFrame p;
				try {
					p = new ZPelikulakFrame();
					p.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPelikula.setFont(new Font("MS Gothic", Font.BOLD, 14));
		btnPelikula.setBackground(Color.PINK);
		btnPelikula.setForeground(Color.BLACK);
		panel.add(btnPelikula);
		
		JButton btnPertsona = new JButton("Pertsona");
		btnPertsona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZPertsonakFrame pf= new ZPertsonakFrame();
				pf.setVisible(true);
			}
		});
		btnPertsona.setFont(new Font("MS Gothic", Font.BOLD, 14));
		btnPertsona.setBackground(Color.PINK);
		panel.add(btnPertsona);
		
		JButton btnEtiketak = new JButton("Etiketak");
		btnEtiketak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ZEtiketakFrame ef;
				try {
					ef = new ZEtiketakFrame();
					ef.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEtiketak.setFont(new Font("MS Gothic", Font.BOLD, 14));
		btnEtiketak.setBackground(Color.PINK);
		panel.add(btnEtiketak);
		
		JLabel lblNewLabel = new JLabel("Honakoa botoi bati eman iezaiozu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
	}

}
