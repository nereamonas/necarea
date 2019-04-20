package Klaseak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class Pertsona {
	//atributuak
	private ListaPelikula ikusitakoPelikulak;
	//HashMap con las baloraciones
	private HashMap<Integer, Float> HM;
	private int id;
	private int pasahitza;
	
	
			
	//eraikitzailea
			
	public Pertsona(int id) {
		this.id=id;  
		this.ikusitakoPelikulak= new ListaPelikula();	
		HM= new HashMap<Integer,Float>();
		this.pasahitza=id;
	}
	
	
	public void grafoaraBalorazioaGehitu(int peliId, float balorazioa) {
		HM.put(peliId, balorazioa);   
	}


	public void pelikulaGehitu(Pelikula p) {
		this.ikusitakoPelikulak.gehituPelikula(p);
	}
	
	
	
	//Junit-etarako
	
	public int zenbatPelikulaIkusi() {
		return this.ikusitakoPelikulak.luzera();
	}
	
	public void ikusitakoakErreseteatu() {
		this.ikusitakoPelikulak.erreseteatu();
	}
	
	public void balorazioakInprimatu() {
		for(int key : HM.keySet()) {
			System.out.println(key + ": " + HM.get(key));
		}
		
		
		//System.out.println(HM.keySet().toString() + HM.values());
	}
	
	public boolean idBerdinaDu(int pId) {
		return pId==this.id;
	}
	
	public void idInprimatu() {
		System.out.println(this.id);
	}
	
	public int getId() {
		return this.id;
	}
	//ListaEtiketa proba batentzat
	public void printPelikulaBatenEtiketak(int pId) {
		Pelikula p=ikusitakoPelikulak.pelikulaBilatuIdz(pId);
		if(p==null) {
			System.out.println("Ez du pelikula hori ikusi");
		}else {
		p.inprimatuEtiketak();
	
		}
	}
	
	public void printIkusitakoPelikulak() {
		ikusitakoPelikulak.inprimatuPelikulak();
	} 
	
	
	public String datuakHartu() {
		return (this.id+" id-a duen pertsona");
	}
	
	public String datuakHartu(int p) {
		int id=this.ikusitakoPelikulak.posiziokoPelikulakoIda(p);
		return ("Ikusitako "+p+" pelikula ondorengoa da: " + this.ikusitakoPelikulak.datuakHartu(p)+" eta emandako balorazioa honakoa izan da:" + this.HM.get(id) );
	}
	
	public int luzera() {
		return this.ikusitakoPelikulak.luzera();
	}
	
	public int pelikularenId(int pos) {
		return this.ikusitakoPelikulak.posiziokoPelikulakoIda(pos);
	}

	public float posiziokoPelikularenBalorazioa(int pos) {
		int id=this.ikusitakoPelikulak.posiziokoPelikulakoIda(pos);
		return this.HM.get(id);
	}
	
	public float idHorrenPelikularenBalorazioa(int id) {
		return this.HM.get(id);
	}
	
	public boolean pasahitzaKonprobatu(int pas) {
		return (this.pasahitza==pas);
	}
	
	public Vector bektoreIkusitakoPelikulak() throws IOException {
		Vector elementuak = new Vector();
		for(int i=0; i<this.ikusitakoPelikulak.luzera(); i++) {
			String s=this.ikusitakoPelikulak.posiziokoPelikularenIzena(i);
			elementuak.addElement(s);
		}
		
		return elementuak;
	}
	
	public boolean bilatuPelikula(String peli) {
		boolean emaitza=false;
		if(this.ikusitakoPelikulak.bilatuPelikularenPosizioa(peli)!=-1) {
			emaitza=true;
		}
		return emaitza;
		
	}
	
	public void pasahitzaAldatu(int p) {
		this.pasahitza=p;
	}
	
	public Vector bektoreIkusiEzDituenPelikulak() {
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		Vector elementuak = new Vector();
		for(int i=0; i<np.luzera(); i++) {
			String s=np.posiziokoPelikularenIzena(i);
			if(this.ikusitakoPelikulak.bilatuPelikulaIzenaz(s)==null) {
				elementuak.addElement(s);
			}
		}
		return elementuak;
	}
	
	
}