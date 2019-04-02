package Klaseak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import Fitxategiak.Fitxategi_CSV;
 
public class ListaPertsona {
//i
	//atributuak
	private ArrayList<Pertsona> listaPertsona;
	private static ListaPertsona nireListaPertsona=null;
	private HashMap<Integer, Integer> id_pos;
	 
			
	//eraikitzailea
			
	private ListaPertsona() {
		this.listaPertsona=new ArrayList<Pertsona>();	
		this.id_pos= new HashMap<Integer,Integer>();
	}
	
	public static synchronized ListaPertsona getListaPertsona() {
		if (ListaPertsona.nireListaPertsona==null) {
			ListaPertsona.nireListaPertsona= new  ListaPertsona();
		}
		return ListaPertsona.nireListaPertsona;
	}
	
	
	private Iterator<Pertsona> getIteradorea() {
		return this.listaPertsona.iterator();
	}
	
	public void gehituPertsona(Pertsona p) {
		this.id_pos.put(p.getId(), this.luzera());
		this.listaPertsona.add(p);
	}
	
	public Pertsona bilatuPertsonaIdz(int pId) {
		Iterator <Pertsona> itr=this.getIteradorea();
		Pertsona pBat=null;
		boolean aurkitua=false;
		
		while (itr.hasNext()&& !aurkitua) {
			pBat=itr.next();
			if (pBat.idBerdinaDu(pId)) {
				aurkitua=true;
			}
		}
		if (!aurkitua) {
			pBat=null;
		}
		return pBat;
	}
	
	public void inprimatu() {
		Iterator<Pertsona> itr=this.getIteradorea();
		Pertsona p1;
		while(itr.hasNext()) {
			p1=itr.next();
			p1.idInprimatu();
		}
	}
	
	public void erreseteatu() {
		while (this.listaPertsona.size()!=0) {
				this.listaPertsona.remove(this.listaPertsona.size()-1);
			}
	}
	
	public int luzera() {
		return this.listaPertsona.size();
	}
	
	public String datuakHartu(int p) {
		return this.listaPertsona.get(p).datuakHartu();
	}
	
	
	public Pertsona posiziokoPertsona(int p) {
		return this.listaPertsona.get(p); 
	}
	
	public Vector BektorePertsona() throws IOException {
		Fitxategi_CSV f= new Fitxategi_CSV();
		ListaPertsona lp=ListaPertsona.getListaPertsona();
		f.kargatuTitles();
		f.kargatuRatings();
		
		Vector elementuak = new Vector();
		for(int i=0; i<lp.luzera(); i++) {
			String s=lp.datuakHartu(i);
			elementuak.addElement(s);
		}
		
		return elementuak;
	}
	
	public Vector BektorePertsona1() throws IOException {
		Fitxategi_CSV f= new Fitxategi_CSV();
		ListaPertsona lp=ListaPertsona.getListaPertsona();
		f.kargatuTitles();
		f.kargatuRatings();
		
		Pertsona p=lp.posiziokoPertsona(1);
	
		
		Vector elementuak = new Vector();
		for(int i=0; i<p.luzera(); i++) {
			String s=p.datuakHartu(i);
			elementuak.addElement(s);
		}
		return elementuak;
	}
	
	public int zeinPosiziotanDago(int id) {
		return id_pos.get(id);
	}
}
