package Gomendioak;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

public interface Gomendioak {
	public LinkedHashMap<String,Float> balorazioakEman(int pertsonaId) ;
	public float baloratuPelikula(String pelikulaIzena, int pertsonaId);
	public LinkedHashMap<String,Float> ordenatu(HashMap<String,Float> HM);
	public Vector bektore10(LinkedHashMap<String,Float> lHM) throws IOException;
}