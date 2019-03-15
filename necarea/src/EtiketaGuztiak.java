import java.util.ArrayList;

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
	
	public boolean bilatuEtiketaIzena(String e) {
		boolean aurkitua=false;
		
		return aurkitua;
	}
	
}
