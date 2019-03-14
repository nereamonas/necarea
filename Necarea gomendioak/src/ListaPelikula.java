import java.util.ArrayList;

public class ListaPelikula {
	//atributuak
	private ArrayList<Pelikula> listaPelikula;
	private static ListaPelikula nireListaPelikula=null;
	
	
			
	//eraikitzailea     
			
	public ListaPelikula() {
		this.listaPelikula=new ArrayList<Pelikula>();		
	}
	
	public void gehituPelikula(Pelikula p) {
		listaPelikula.add(p);
	}
	
	public Pelikula pelikulaBilatuIdz(int id) {
		Pelikula aurkitu=null;
		//busca a ver si está esa peli y la returnea
		return aurkitu;
	}
}
 
