package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;

public class SaioaItxiNahiFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int erabiltzaileId,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaioaItxiNahiFrame frame = new SaioaItxiNahiFrame(erabiltzaileId,p);
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
	public SaioaItxiNahiFrame(int erabiltzaileId,int p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 179);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ButtonGroup grupo= new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblSeguruZaudeSaioa = new JLabel("Seguru zaude saioa itxi nahi duzula??");
		lblSeguruZaudeSaioa.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		panel.add(lblSeguruZaudeSaioa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JRadioButton rdbtnBai = new JRadioButton("Bai");
		rdbtnBai.setBackground(new Color(245, 255, 250));
		panel_1.add(rdbtnBai);
		
		JRadioButton rdbtnEz = new JRadioButton("Ez");
		rdbtnEz.setBackground(new Color(245, 255, 250));
		panel_1.add(rdbtnEz);
		
		grupo.add(rdbtnBai);
		grupo.add(rdbtnEz);
		
		JButton btnSartu = new JButton("Seguru nago");
		btnSartu.setBackground(new Color(135, 206, 250));
		panel_1.add(btnSartu);
		
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnBai.isSelected()) {
					SarreraFrame sarrera= new SarreraFrame();
					sarrera.setVisible(true);
					dispose();
				}else {
					if(rdbtnEz.isSelected()) {
						WebFrame web= new WebFrame(erabiltzaileId,p);

						web.setVisible(true);
						dispose();
					}
				}
			}	
	});
	}

}
