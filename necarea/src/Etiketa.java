
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
	
	public int getAldiak() {
		return this.zenbatAldiz;
	}

	public String getIzena() {
		return this.etiketaIzena;
	}

//Junit-etarako

public void print() {
	System.out.println("Pelikula zenbakia:" + this.pelikulaZenbakia);
	System.out.println("Etiketa izena:" + this.etiketaIzena);
	System.out.println("Agerpen aldiak:" + this.zenbatAldiz);
	System.out.println();
}


	

}