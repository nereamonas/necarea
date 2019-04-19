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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class HobeBaloratutakoPelikulakFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,int erabiltzaileId,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HobeBaloratutakoPelikulakFrame frame = new HobeBaloratutakoPelikulakFrame(erabiltzaileId,p);
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
	public HobeBaloratutakoPelikulakFrame(int erabiltzaileId,int p) {
		Necarea necarea=Necarea.getNecarea();
		
		setBackground(new Color(245, 255, 250));
		setTitle("Gehien gustatuko zaizkion 10 pelikulak");
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
		
		JMenuItem mntmPelikulaBatenInformazioa = new JMenuItem("Pelikula baten informazioa");
		mntmPelikulaBatenInformazioa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnKatalogoa.add(mntmPelikulaBatenInformazioa);
		
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
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		
		JLabel lblGehienGustatukoZaizkizun = new JLabel("Gehien gustatuko zaizkizun 10 pelikulak:");
		lblGehienGustatukoZaizkizun.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		panel.add(lblGehienGustatukoZaizkizun);
		
		JButton btnLortu = new JButton("Lortu");
		btnLortu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnLortu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(178)
					.addComponent(btnLortu))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLortu)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);
		contentPane.setLayout(gl_contentPane);
		
		
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
		
		
		
		//Lortu botoiari ematean
		btnLortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vector elementuak= necarea.gehienGustatukoZaizkionPelikulak(erabiltzaileId);
					JList list = new JList(elementuak);
					scrollPane.setViewportView(list);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}

}
