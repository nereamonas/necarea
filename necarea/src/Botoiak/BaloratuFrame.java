package Botoiak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
import javax.swing.JToolBar;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class BaloratuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int erabiltzaileId,int p, String peli) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaloratuFrame frame = new BaloratuFrame(erabiltzaileId,p,peli);
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
	public BaloratuFrame(int erabiltzaileId,int p, String peli) {
		Necarea necarea=Necarea.getNecarea();
		
		setBackground(new Color(245, 255, 250));
		setTitle("Balorazioa eman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
		mntmH.setIcon(new ImageIcon("C:\\Users\\nerea\\Desktop\\logo_txikia2.png"));
		menuBar.add(mntmH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblBaloratu = new JLabel("Balorazioa eman");
		lblBaloratu.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		panel.add(lblBaloratu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblZeBalorazioaEmango = new JLabel("Ze balorazioa emango zenioke?");
		lblZeBalorazioaEmango.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JSlider slider = new JSlider(1,5);
		slider.setForeground(new Color(245, 255, 250));
		
		JLabel lblMileskerBalorazioaEmateagatik = new JLabel("Milesker balorazioa emateagatik.");
		lblMileskerBalorazioaEmateagatik.setVisible(false);
		
		JButton btnBestePelikulaBat = new JButton("Beste pelikula bat ikusi");
		btnBestePelikulaBat.setBackground(new Color(135, 206, 250));
		btnBestePelikulaBat.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnBestePelikulaBat.setVisible(false);
		
		JButton btnBalorazioaEman = new JButton("Baloratu");
		btnBalorazioaEman.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnBalorazioaEman.setBackground(new Color(135, 206, 250));
		btnBalorazioaEman.setVisible(false);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(23)
							.addComponent(lblZeBalorazioaEmango)
							.addGap(26)
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(131)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMileskerBalorazioaEmateagatik)
								.addComponent(btnBestePelikulaBat)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnBalorazioaEman, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(28)))))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblZeBalorazioaEmango)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btnBalorazioaEman, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMileskerBalorazioaEmateagatik)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBestePelikulaBat)
					.addGap(24))
		);
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
		
		slider.addChangeListener(new ChangeListener() {
			   public void stateChanged(ChangeEvent arg0) {
				   float n=slider.getValue();
				   btnBalorazioaEman.setVisible(true);
				   btnBalorazioaEman.addActionListener(new ActionListener() { 
						public void actionPerformed(ActionEvent e) {
							lblMileskerBalorazioaEmateagatik.setVisible(true);
							btnBestePelikulaBat.setVisible(true);
							necarea.balorazioaGehitu(erabiltzaileId,peli,n);
							
							btnBestePelikulaBat.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									PelikulaBatIkusiFrame bestebatikusi= new PelikulaBatIkusiFrame(erabiltzaileId,p);
									bestebatikusi.setVisible(true);
									dispose();
								}
							});
						}
				   });
			   }
		});
		

	}
}
