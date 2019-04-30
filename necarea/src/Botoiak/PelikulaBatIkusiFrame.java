package Botoiak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import Klaseak.Necarea;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PelikulaBatIkusiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int erabiltzaileId, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PelikulaBatIkusiFrame frame = new PelikulaBatIkusiFrame(erabiltzaileId,p);
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
	public PelikulaBatIkusiFrame(int erabiltzaileId,int p) {
		Necarea necarea=Necarea.getNecarea();
		
		setBackground(new Color(245, 255, 250));
		setTitle("Pelikula abt ikusi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenua = new JMenu("Menua");
		mnMenua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		menuBar.add(mnMenua);
		
		JMenu mnNireKontua = new JMenu("Nire kontua");
		mnNireKontua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mnNireKontua);
		
		JMenuItem mntmInformazioa = new JMenuItem("Informazioa");
		mntmInformazioa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmInformazioa);
		
		JMenuItem mntmIkusiDitudanPelikulak = new JMenuItem("Ikusi ditudan pelikulak");
		mntmIkusiDitudanPelikulak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNireKontua.add(mntmIkusiDitudanPelikulak);
		
		JMenu mnKatalogoa = new JMenu("Katalogoa");
		mnKatalogoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mnKatalogoa);
		
		JMenuItem mntmPelikulaGuztiak = new JMenuItem("Pelikula guztiak");
		mntmPelikulaGuztiak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnKatalogoa.add(mntmPelikulaGuztiak);
		
		
		JMenuItem mntmPelikulaBatIkusi = new JMenuItem("Pelikula bat ikusi");
		mntmPelikulaBatIkusi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmPelikulaBatIkusi);
		
		JMenu mnBalorazioakLortu = new JMenu("Balorazioak lortu");
		mnBalorazioakLortu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mnBalorazioakLortu);
		
		JMenuItem mntmPelikulaBatBaloratu = new JMenuItem("Pelikula bat baloratu");
		mntmPelikulaBatBaloratu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnBalorazioakLortu.add(mntmPelikulaBatBaloratu);
		
		JMenuItem mntmGehienGustatukoZaizkidan = new JMenuItem("Gehien gustatuko zaizkidan 10 pelikulak");
		mntmGehienGustatukoZaizkidan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnBalorazioakLortu.add(mntmGehienGustatukoZaizkidan);
		
		JSeparator separator = new JSeparator();
		mnMenua.add(separator);
		
		JMenuItem mntmMenuPrintzipaleraItzuli = new JMenuItem("Menu printzipalera itzuli");
		mntmMenuPrintzipaleraItzuli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmMenuPrintzipaleraItzuli);
		
		JSeparator separator_1 = new JSeparator();
		mnMenua.add(separator_1);
		
		JMenuItem mntmSaioaItxi = new JMenuItem("Saioa itxi");
		mntmSaioaItxi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenua.add(mntmSaioaItxi);
		
		JMenuItem mntmH = new JMenuItem("");
		mntmH.setBackground(new Color(245, 255, 250));
		mntmH.setIcon(new ImageIcon("src/logo_txikia2.png"));
		menuBar.add(mntmH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblPelikulaBatIkusi = new JLabel("Pelikula bat ikusi:");
		lblPelikulaBatIkusi.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		panel.add(lblPelikulaBatIkusi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblIkusiEzDituzun = new JLabel("Ikusi ez dituzun pelikulak:");
		lblIkusiEzDituzun.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnPelikulaHauIkusi = new JButton("Pelikula hau ikusi nahi dut");
		btnPelikulaHauIkusi.setBackground(new Color(135, 206, 250));
		btnPelikulaHauIkusi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPelikulaHauIkusi.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JButton btnBaloratu = new JButton("Baloratu");
		btnBaloratu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBaloratu.setBackground(new Color(135, 206, 250));
		btnBaloratu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnBaloratu.setVisible(false);
		
		JLabel lblZeIrudituZaizu = new JLabel("Ze iruditu zaizu pelikula?");
		lblZeIrudituZaizu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblZeIrudituZaizu.setVisible(false);
		
		JLabel lblBalorazioaEman = new JLabel("Balorazioa eman:");
		lblBalorazioaEman.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblBalorazioaEman.setVisible(false);
		
		JLabel lblEtiketaBatGehitu = new JLabel("Etiketa bat gehitu:");
		lblEtiketaBatGehitu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblEtiketaBatGehitu.setVisible(false);
		
		JSlider slider = new JSlider(1,5);
		slider.setBackground(new Color(245, 255, 250));
		slider.setVisible(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setVisible(false);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setBackground(new Color(135, 206, 250));
		btnGehitu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnGehitu.setVisible(false);
		
		JButton btnBestePelikulaBat = new JButton("Beste pelikula bat ikusi");
		btnBestePelikulaBat.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnBestePelikulaBat.setBackground(new Color(135, 206, 250));
		btnBestePelikulaBat.setVisible(false);
		
		JLabel label = new JLabel("");
		label.setVisible(false);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(18)
								.addComponent(btnPelikulaHauIkusi)
								.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(lblEtiketaBatGehitu)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblBalorazioaEman))
										.addGap(45))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBaloratu)
										.addGap(70))))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(35)
								.addComponent(lblZeIrudituZaizu)
								.addContainerGap(279, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGehitu)
							.addGap(58))))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(45)
					.addComponent(lblIkusiEzDituzun)
					.addContainerGap(483, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(248, Short.MAX_VALUE)
					.addComponent(btnBestePelikulaBat)
					.addGap(266))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(44)
					.addComponent(btnPelikulaHauIkusi)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(lblZeIrudituZaizu)
					.addGap(61)
					.addComponent(btnBestePelikulaBat))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIkusiEzDituzun)
						.addComponent(lblBalorazioaEman))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBaloratu)
								.addComponent(label))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEtiketaBatGehitu)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGehitu))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		Vector elem=necarea.ikusiEzDituenPelikulak(erabiltzaileId);
		JList list = new JList(elem);
		list.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		scrollPane.setViewportView(list);
		panel_1.setLayout(gl_panel_1);
		
		
		//Saioa itxi
		mntmSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaioaItxiNahiFrame saioaItxi= new SaioaItxiNahiFrame(erabiltzaileId,p);
				saioaItxi.setVisible(true);
				dispose();
			}
		});
		
		//menu printzipalera itzuli
		mntmMenuPrintzipaleraItzuli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WebFrame web= new WebFrame(erabiltzaileId,p);
				web.setVisible(true);
				dispose();
			}
		});
		
		//Erabiltzailearen informazioa
		mntmInformazioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InformazioaFrame informazioa=new InformazioaFrame(erabiltzaileId,p);
				informazioa.setVisible(true);
				dispose();
			}
		});
		
		
		//Ikusi dituen pelikulak
		mntmIkusiDitudanPelikulak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IkusitakoPelikulakFrame ikusitakoPelikulak=null;
				try {
					ikusitakoPelikulak = new IkusitakoPelikulakFrame(erabiltzaileId,p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ikusitakoPelikulak.setVisible(true);
				dispose();
			}
		});
		
		//PelikulaIkusi
		mntmPelikulaBatIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PelikulaBatIkusiFrame pelikulaIkusi=new PelikulaBatIkusiFrame(erabiltzaileId,p);
				pelikulaIkusi.setVisible(true);
				dispose();
			}
		});
		
		//Pelikula bat baloratu
		mntmPelikulaBatBaloratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PelikulaBatBaloratuFrame pelikulaBatBaloratu=null;
				try {
					pelikulaBatBaloratu = new PelikulaBatBaloratuFrame(erabiltzaileId,p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pelikulaBatBaloratu.setVisible(true);
				dispose();
			}
		});
		
		//10 pelikulak baloratu
		mntmGehienGustatukoZaizkidan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HobeBaloratutakoPelikulakFrame hobeBaloratutakoPelikulak=new HobeBaloratutakoPelikulakFrame(erabiltzaileId,p);
				hobeBaloratutakoPelikulak.setVisible(true);
				dispose();
			}
		});
		
		//pelikula guztiak
		mntmPelikulaGuztiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PelikulaGuztiakFrame pelikulak=null;
				try {
					pelikulak = new PelikulaGuztiakFrame(erabiltzaileId,p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pelikulak.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		btnPelikulaHauIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex()!=-1) {
					
					
					//aquiii
					lblBalorazioaEman.setVisible(true);
					slider.setVisible(true);
					btnBaloratu.setVisible(true); 
					lblZeIrudituZaizu.setVisible(true);
					lblEtiketaBatGehitu.setVisible(true);
					textField.setVisible(true);
					btnGehitu.setVisible(true);
					btnBestePelikulaBat.setVisible(true);
					btnGehitu.setVisible(true);
					
					
					btnBaloratu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							float n=(float)slider.getValue();
							necarea.pelikulaGehitu((String) list.getSelectedValue(),erabiltzaileId);
							try {
								necarea.balorazioaGehitu(erabiltzaileId, (String) list.getSelectedValue(), n);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Vector elem=necarea.ikusiEzDituenPelikulak(erabiltzaileId);
							JList list = new JList(elem);
							list.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
							scrollPane.setViewportView(list);
							btnBaloratu.setVisible(false);
							label.setVisible(true);
							label.setText("Pelikula hau jada baloratu duzu");
							
						}
					});
					
					btnGehitu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String etiketaBerria=textField.getText().trim();
							try {
								necarea.gehituEtiketa(etiketaBerria, (String) list.getSelectedValue());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							textField.setText("");
						}
					});
					
					btnBestePelikulaBat.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							PelikulaBatIkusiFrame pp= new PelikulaBatIkusiFrame(erabiltzaileId,p);
							pp.setVisible(true);
							dispose();
						}
					});
				}
				
			}
		});
		
	
		
		
		
		
	}
}