import java.util.ArrayList;
import java.util.Iterator;

public class EtiketaGuztiak {
	//atributuak 
	private ArrayList<String> lista;
	private static EtiketaGuztiak nireEtiketaGuztiak=null;
	
	
			 
	//eraikitzailea
			
	private EtiketaGuztiak() {
		this.lista=new ArrayList<String>();		
	}
	
	public static synchronized EtiketaGuztiak getEtiketaGuztiak() {
		if (EtiketaGuztiak.nireEtiketaGuztiak==null) {
			EtiketaGuztiak.nireEtiketaGuztiak= new  EtiketaGuztiak();
		}    
		return EtiketaGuztiak.nireEtiketaGuztiak;
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
		Iterator <String> itr=this.getIteradorea();
		String sBat=null;

		while (itr.hasNext()&& !aurkitua) {
			sBat=itr.next();
			if (sBat.compareTo(e)==0) {
				aurkitua=true;
			}
		}
		return aurkitua;
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
}
