import java.util.ArrayList;
import java.util.Iterator;

public class ListaPertsona {
//i
	//atributuak
	private ArrayList<Pertsona> listaPertsona;
	private static ListaPertsona nireListaPertsona=null;
	
	 
			
	//eraikitzailea
			
	private ListaPertsona() {
		this.listaPertsona=new ArrayList<Pertsona>();		
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
}
