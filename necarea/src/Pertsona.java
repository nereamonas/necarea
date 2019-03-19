import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Pertsona {
	//atributuak
	private ListaPelikula ikusitakoPelikulak;
	//HashMap con las baloraciones
	private HashMap<Integer, Float> HM;
	private int id;
	
	
			 
	//eraikitzailea
			
	public Pertsona(int id) {
		this.id=id;  
		this.ikusitakoPelikulak= new ListaPelikula();	
		HM= new HashMap<Integer,Float>();
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
}