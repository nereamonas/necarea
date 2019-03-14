
 
public class Etiketa {

	//atributuak  
	private int pelikulaZenbakia;
	private String etiketaIzena;
	private int zenbatAldiz;
	    
	
			
	//eraikitzailea
			
	public Etiketa(int peliZenb, String etiketa) {
		this.pelikulaZenbakia=peliZenb;
		this.etiketaIzena=etiketa;
		this.zenbatAldiz=1;
	}
	
	public void gehituBesteBat() {
		this.zenbatAldiz++;
	}
	
}
