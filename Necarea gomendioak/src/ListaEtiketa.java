import java.util.ArrayList;

public class ListaEtiketa {

	//atributuak
	private ArrayList<Etiketa> listaEtiketa;
	  
	
			
	//eraikitzailea
		    	
	public ListaEtiketa() {
		this.listaEtiketa=new ArrayList<Etiketa>();		
	}
	
	public void gehituEtiketa(Etiketa e) {
		this.listaEtiketa.add(e);
	}
	
} 