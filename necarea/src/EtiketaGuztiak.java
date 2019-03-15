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
		lista.add(e);
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
			if (sBat.equals(e)) {
				aurkitua=true;
			}
		}
		return aurkitua;
	}
	
}
