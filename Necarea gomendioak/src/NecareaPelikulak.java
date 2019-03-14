import java.util.ArrayList;

public class NecareaPelikulak {
	//atributuak
	private ListaPelikula listaPeli;
	private static NecareaPelikulak nireNecareaPelikulak=null;
	
	
			
	 //eraikitzailea
			
	private NecareaPelikulak() {
		this.listaPeli=new ListaPelikula();		
	}
	    
	public static synchronized NecareaPelikulak getNecareaPelikulak() {
		if (NecareaPelikulak.nireNecareaPelikulak==null) {
			NecareaPelikulak.nireNecareaPelikulak= new  NecareaPelikulak();
		}
		return NecareaPelikulak.nireNecareaPelikulak;
	}
	
	public void gehituPelikula(Pelikula p) {
		this.listaPeli.gehituPelikula(p);
	}
	
	public Pelikula pelikulaBilatuIdz(int id) {
		return this.listaPeli.pelikulaBilatuIdz(id);
	}
}
