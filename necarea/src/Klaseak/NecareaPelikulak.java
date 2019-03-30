package Klaseak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import Fitxategiak.Fitxategi_CSV;
 
public class NecareaPelikulak {
	//atributuak
	private ListaPelikula listaPeli;
	private static NecareaPelikulak nireNecareaPelikulak=null;
	
	
			
	 //eraikitzailea
			
	private NecareaPelikulak() {
		this.listaPeli=new ListaPelikula();		
	}
	    
	public static synchronized NecareaPelikulak getNecareaPelikulak() {
		if (NecareaPelikulak.nireNecareaPelikulak==null) {
			NecareaPelikulak.nireNecareaPelikulak= new  NecareaPelikulak();
		}
		return NecareaPelikulak.nireNecareaPelikulak;
	}
	
	public void gehituPelikula(Pelikula p) {
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
	
	  
	
	//Botoiak egiteko erabiliko dira
	public String datuakHartu(int p) {
		return this.listaPeli.datuakHartu(p);
	}

	public Vector bektorePelikulak() throws IOException {
		Fitxategi_CSV f= new Fitxategi_CSV();
		NecareaPelikulak lp=NecareaPelikulak.getNecareaPelikulak();
		f.kargatuTitles();
		
		
		Vector elementuak = new Vector();
		for(int i=0; i<lp.luzera(); i++) {
			String s=lp.datuakHartu(i);
			elementuak.addElement(s);
		}
		
		return elementuak;
	}
	
	
}
