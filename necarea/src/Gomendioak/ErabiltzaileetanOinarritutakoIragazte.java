package Gomendioak;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Vector;

public class ErabiltzaileetanOinarritutakoIragazte {


	private static ErabiltzaileetanOinarritutakoIragazte nireErabiltzaileetanOinarritutakoIragazte=null;
	
	private ErabiltzaileetanOinarritutakoIragazte() {
		
	}
	

	public static synchronized ErabiltzaileetanOinarritutakoIragazte getErabiltzaileetanOinarritutakoIragazte() {
			if (ErabiltzaileetanOinarritutakoIragazte.nireErabiltzaileetanOinarritutakoIragazte==null) {
				ErabiltzaileetanOinarritutakoIragazte.nireErabiltzaileetanOinarritutakoIragazte= new ErabiltzaileetanOinarritutakoIragazte();
			}
			return ErabiltzaileetanOinarritutakoIragazte.nireErabiltzaileetanOinarritutakoIragazte;
	}
	
	
	public LinkedHashMap<String,Float> balorazioakEman(int pertsonaId) { 
		LinkedHashMap<String,Float> emaitza= new LinkedHashMap<String,Float>();
		return emaitza;
	}
	
	public float baloratuPelikula(String pelikulaIzena, int pertsonaId) { 
		float emaitza=(float)0.0;
		return emaitza;
	}
	
	public Vector bektore10(LinkedHashMap<String,Float> lHM) throws IOException {
		Vector emaitza= new Vector();
		return emaitza;
	}
	
}