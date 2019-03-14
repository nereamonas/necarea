import java.util.ArrayList;
import java.util.Iterator;

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
	
	private Iterator<Etiketa> getIteradorea() {
		return this.listaEtiketa.iterator();
	}
	
	public int luzera() {
		return this.listaEtiketa.size();
	}
	
	//Junit-etarako

	public void erreseteatu(){
		while (this.listaEtiketa.size()!=0) {
				this.listaEtiketa.remove(this.listaEtiketa.size()-1);
			}
	}
	
}