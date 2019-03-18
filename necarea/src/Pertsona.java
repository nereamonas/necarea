import java.util.ArrayList;
import java.util.HashMap;

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
}
