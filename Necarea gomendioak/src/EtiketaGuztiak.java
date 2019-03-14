import java.util.ArrayList;

public class EtiketaGuztiak {
	//atributuak 
	private ListaEtiketa listaEtiketa;
	private static EtiketaGuztiak nireEtiketaGuztiak=null;
	
	
			 
	//eraikitzailea
			
	private EtiketaGuztiak() {
		this.listaEtiketa=new ListaEtiketa();		
	}
	
	public static synchronized EtiketaGuztiak getEtiketaGuztiak() {
		if (EtiketaGuztiak.nireEtiketaGuztiak==null) {
			EtiketaGuztiak.nireEtiketaGuztiak= new  EtiketaGuztiak();
		}    
		return EtiketaGuztiak.nireEtiketaGuztiak;
	}
	
	public Etiketa etiketaBilatu(Etiketa e) {
		Etiketa aurkitu=null;
		
		//buscar si esta esa etiketa y si esta devolverla para hacerle +1;
		
		return aurkitu;
	}
	
	public void gehituEtiketa(Etiketa e) {
		listaEtiketa.gehituEtiketa(e);
	}
	
}
