package Klaseak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import Fitxategiak.Fitxategi_CSV;
 
public class NecareaPelikulak {
	//atributuak
	private ListaPelikula listaPeli;
	private static NecareaPelikulak nireNecareaPelikulak=null;
	private HashMap<Integer, Integer> id_pos; //creo q hay q borrar
	private HashMap<String, Integer> izen_pos;
			
	 //eraikitzailea
			
	private NecareaPelikulak() {
		this.listaPeli=new ListaPelikula();	
		this.id_pos= new HashMap<Integer,Integer>();
		this.izen_pos= new HashMap<String,Integer>();
	}
	    
	public static synchronized NecareaPelikulak getNecareaPelikulak() {
		if (NecareaPelikulak.nireNecareaPelikulak==null) {
			NecareaPelikulak.nireNecareaPelikulak= new  NecareaPelikulak();
		}
		return NecareaPelikulak.nireNecareaPelikulak;
	}
	
	public void gehituPelikula(Pelikula p) {
		this.id_pos.put(p.getId(), this.luzera());
		this.izen_pos.put(p.getIzena(), this.luzera());
		this.listaPeli.gehituPelikula(p);
	}
	
	public int luzera() {
		return this.listaPeli.luzera();
	}
	
	public Pelikula pelikulaBilatuIdz(int id) {
		return this.listaPeli.pelikulaBilatuIdz(id);
	}
	
	public void inprimatuPelikulak() {
		this.listaPeli.inprimatuPelikulak();
	}
	
	public void erreseteatu() {
		this.listaPeli.erreseteatu();
	}
	

	public ListaEtiketa posiziokoPelikularenListaEtiketa(int i) {
		return this.listaPeli.posiziokoPelikularenListaEtiketa(i);
	}
	
	
	public String posiziokoPelikularenIzena(int i) {
		return this.listaPeli.posiziokoPelikularenIzena(i);
	}
	
	public int bilatuPelikularenPosizioa(String p) {
		//return this.listaPeli.bilatuPelikularenPosizioa(p);
		return this.izen_pos.get(p);
	}
	
	public int zeinPosiziotanDago(int id) {
		return id_pos.get(id);
		
	}
	
	  
	
	//Botoiak egiteko erabiliko dira
	public String datuakHartu(int p) {
		return this.listaPeli.datuakHartu(p);
	}

	public Vector bektorePelikulak() throws IOException {

		Vector elementuak = new Vector();
		for(int i=0; i<this.listaPeli.luzera(); i++) {
			String s=this.listaPeli.datuakHartu(i);
			elementuak.addElement(s);
		}
		
		return elementuak;
	}
	
	public Pelikula bilatuPelikulaIzenaz(String peli) {
		return this.listaPeli.bilatuPelikulaIzenaz(peli);
	}
	
	
}