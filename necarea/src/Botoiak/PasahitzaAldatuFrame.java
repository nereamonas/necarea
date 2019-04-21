package Botoiak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class PasahitzaAldatuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int erabiltzaile, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasahitzaAldatuFrame frame = new PasahitzaAldatuFrame(erabiltzaile,p);
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
	public PasahitzaAldatuFrame(int erabiltzaile, int p) {
		Necarea necarea=Necarea.getNecarea();
		
		setTitle("Pasahitza aldatu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblZurePasahitza = new JLabel("Zure pasahitza:");
		lblZurePasahitza.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblPasahitzBerria = new JLabel("Pasahitz berria:");
		lblPasahitzBerria.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblErrepikatuPasahitzBerria = new JLabel("Errepikatu pasahitz berria:");
		lblErrepikatuPasahitzBerria.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	
		btnAldatu.setBackground(new Color(135, 206, 250));
		btnAldatu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblPasahitzezegokia = new JLabel("");
		lblPasahitzezegokia.setForeground(Color.RED);
		
		JLabel lblSaioaAmaitukoDa = new JLabel("Saioa amaituko da");
		lblSaioaAmaitukoDa.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		
		JButton btnEzDutPasahitza = new JButton("Ez dut pasahitza aldatu nahi");
		btnEzDutPasahitza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEzDutPasahitza.setBackground(new Color(135, 206, 250));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblZurePasahitza)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblErrepikatuPasahitzBerria)
									.addGap(18)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPasahitzBerria)
									.addGap(18)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(161)
							.addComponent(btnAldatu)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSaioaAmaitukoDa))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(152)
							.addComponent(lblPasahitzezegokia)))
					.addContainerGap(105, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(247, Short.MAX_VALUE)
					.addComponent(btnEzDutPasahitza)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(btnEzDutPasahitza)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZurePasahitza)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasahitzBerria)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblErrepikatuPasahitzBerria)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAldatu)
						.addComponent(lblSaioaAmaitukoDa))
					.addGap(18)
					.addComponent(lblPasahitzezegokia)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//Botoian sakatzean:
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setBackground(Color.WHITE);
				textField_1.setBackground(Color.WHITE);
				textField_2.setBackground(Color.WHITE);
				lblPasahitzezegokia.setText("");
				
				//pasahitza berearekin bat dator
				String pp=textField.getText();
				int ppp=-1;
				try {
					ppp=Integer.parseInt(pp);
				}catch(NumberFormatException nfe) {
				}if(ppp==-1) {
					lblPasahitzezegokia.setText("Zenbaki bat izan behar da");
					textField.setBackground(Color.RED);
				}else {
				
				
				if (p!=ppp) {
					lblPasahitzezegokia.setText("Sartu duzun pasahitaz ez da egokia");
					textField.setBackground(Color.RED);
				}else {
					String p1=textField_1.getText();
					String p2=textField_2.getText();
					
					int pp1=-1;
					int pp2=-2;
					try {
						pp1=Integer.parseInt(p1);
					}catch(NumberFormatException nfe) {
					}
					if(pp1==-1) {
						lblPasahitzezegokia.setText("Zenbaki bat izan behar da");
						textField_1.setBackground(Color.RED);
					}else {
						try {
							pp2=Integer.parseInt(p2);
						}catch(NumberFormatException nfe) {
						}
						if(pp2==-2) {
							lblPasahitzezegokia.setText("Zenbaki bat izan behar da");
							textField_2.setBackground(Color.RED);
						}else {
							//biak berdinak izan behar
							if(pp1==pp2) {
								necarea.pasahitzaAldatu(erabiltzaile,pp1);
								SarreraFrame sarrera= new SarreraFrame();
								sarrera.setVisible(true);
								dispose();
							}else {
								lblPasahitzezegokia.setText("Pasahitz berriak ez datozte bat");
								textField_2.setBackground(Color.RED);
								textField_1.setBackground(Color.RED);
							}
						}
					}
				}
				
				}
			}
		});
		
		btnEzDutPasahitza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformazioaFrame infor= new InformazioaFrame(erabiltzaile,p);
				infor.setVisible(true);
				dispose();
			}
		});
		
		
	}


}
