package Klaseak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import Fitxategiak.Fitxategi_CSV;
 
public class EtiketaGuztiak {
	//atributuak 
	private ArrayList<String> lista;
	private static EtiketaGuztiak nireEtiketaGuztiak=null;
	private HashMap<String,Integer> HM;
	private HashMap<String,Integer> HMKant;
	
			 
	//eraikitzailea
			
	private EtiketaGuztiak() {
		this.lista=new ArrayList<String>();		
		this.HM= new HashMap<String, Integer>();
		this.HMKant= new HashMap<String, Integer>();
	}
	
	public static synchronized EtiketaGuztiak getEtiketaGuztiak() {
		if (EtiketaGuztiak.nireEtiketaGuztiak==null) {
			EtiketaGuztiak.nireEtiketaGuztiak= new  EtiketaGuztiak();
		}    
		return EtiketaGuztiak.nireEtiketaGuztiak;
	}
	
	public void grafoaraIzenaGehitu(int p, String izena) {
		HM.put(izena,p);   
	}
	
	public void gehituEtiketa(String e) {
		if(!bilatuEtiketaIzena(e)) {
			lista.add(e);
			
		}
	}
	private Iterator<String> getIteradorea() {
		return this.lista.iterator();
	}
	
	public boolean bilatuEtiketaIzena(String e) {
		boolean aurkitua=false;
		/*Iterator <String> itr=this.getIteradorea();
		String sBat=null;

		while (itr.hasNext()&& !aurkitua) {
			sBat=itr.next();
			if (sBat.compareTo(e)==0) {
				aurkitua=true;
			}
		}*/
		//int pos=HM.get(e);
		if (HM.get(e)!=null) {
			aurkitua=true;
		}
		return aurkitua;
		
		//o se puede hacer con el hashMaph con contains
	}
	
	public void inprimatuEtiketaIzenak() {
		Iterator <String> itr=this.getIteradorea(); 
		String s=null;
		while (itr.hasNext()) {
			s=itr.next();
			System.out.println(s);
	}
		
	}
	
	public int luzera() {
		return lista.size();
}
	public void erreseteatu() {
		lista.clear();		
	}
	
	public String datuakHartu(int p) {
		return this.lista.get(p);
	}
	
	public Vector  bektoreEtiketak() throws IOException {
		Fitxategi_CSV f= new Fitxategi_CSV();
		
		EtiketaGuztiak eg= EtiketaGuztiak.getEtiketaGuztiak();
		f.kargatuTags();
		
		Vector elementuak = new Vector();
		for(int i=0; i<eg.luzera(); i++) {
			String s=eg.datuakHartu(i);
			elementuak.addElement(s);
		}
		
		return elementuak;
	}
	
	public int EtiketarenPosizioa(String p){
		return this.HM.get(p);
	}
	
	
	public void EtiketaErrepikatuDa(String etiketa) {
		
		if(this.HM.containsKey(etiketa)){
			int kant=this.HM.get(etiketa);
			this.HM.put(etiketa, kant);
		}
	}
	
	public int kantitatea(String p) {
		return this.HMKant.get(p);
	}
	
	public String posiziokoEtiketaIzena(int i) {
		return this.lista.get(i);
	}
	
}