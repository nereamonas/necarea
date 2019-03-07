import java.util.ArrayList;

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
	
}
