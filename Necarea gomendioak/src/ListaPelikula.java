import java.util.ArrayList;

public class ListaPelikula {
	//atributuak
	private ArrayList<Pelikula> listaPelikula;
	private static ListaPelikula nireListaPelikula=null;
	
	
			
//eraikitzailea
			
	private ListaPelikula() {
		this.listaPelikula=new ArrayList<Pelikula>();		
	}
	
	public static synchronized ListaPelikula getListaPertsona() {
		if (ListaPelikula.nireListaPelikula==null) {
			ListaPelikula.nireListaPelikula= new  ListaPelikula();
		}
		return ListaPelikula.nireListaPelikula;
	}
}
