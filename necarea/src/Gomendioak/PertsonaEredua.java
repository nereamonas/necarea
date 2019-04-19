package Gomendioak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.Map.Entry;

import Klaseak.EtiketaGuztiak;
import Klaseak.ListaPertsona;
import Klaseak.NecareaPelikulak;
import Klaseak.Pertsona;

public class PertsonaEredua {
 

	private static PertsonaEredua nirePertsonaEredua=null;
	
	public PertsonaEredua() {
		
	}
	

	public static synchronized PertsonaEredua getPertsonaEredua() {
			if (PertsonaEredua.nirePertsonaEredua==null) {
				PertsonaEredua.nirePertsonaEredua= new PertsonaEredua();
			}
			return PertsonaEredua.nirePertsonaEredua;
	}
	
	
	public LinkedHashMap<String,Float> balorazioakEman(int pertsonaId) { //NO VA BIEN igual se puede hacer usando el otro
		BalorazioMatrize BM = BalorazioMatrize.getBalorazioMatrize();
		EtiketaMatrize EM=EtiketaMatrize.getEtiketaMatrize();
		
		BM.matrizeaSortu();
		EM.MatrizeaSortu();
		
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		ListaPertsona lp=ListaPertsona.getListaPertsona();
		
		//1- Balorazio matrizean pertsona bilatuko dugu (id-a, matrizearen posizioa da). Pertsona horren pelikula errenkada hartuko dugu. 
		float[] pertsonarenBalorazio = BM.pertsonarenBalorazioa(lp.zeinPosiziotanDago(pertsonaId));
		//2- Ikusi dituen eta 3.5 baino gehiagoko balorazioa eman dien pelikulak hartuko dira. Gehitura izeneko bektore bat sortuko dugu eta posizio bakoitzean orain esandako pelikula guztien etiketa bakoitzaren batura gordeko da
		//3- Beste bektore bat sortuko dugu kosinuaAplikatuta izenekoa. Ikusi ez dituen pelikulak begiratu beharko ditugu eta kosinua formula aplikatu etiketaMatrizeko errenkada bakoitza gehitura bektorearekin.
		//Ezin dugu goiko for-a erabili, oraindik gehitura bektorea sortuta ez dugulako
		float[] kosinuaAplikatuta=EM.kosinuaAplikatutaBektore(pertsonarenBalorazio);
		//4- HashMap bat sortu (pelikula, kosinuan ateratako balioa
		HashMap<String,Float> HM= EM.hmSortu(kosinuaAplikatuta);		
		return this.ordenatu(HM);
		
	}
	

	
	public float baloratuPelikula(String pelikulaIzena, int pertsonaId) { //LO DE -2 SI NO LO HA VISTO DONDE VA?
		BalorazioMatrize BM = BalorazioMatrize.getBalorazioMatrize();
		EtiketaMatrize EM=EtiketaMatrize.getEtiketaMatrize();
		
		BM.matrizeaSortu();
		EM.MatrizeaSortu();
		
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		ListaPertsona lp=ListaPertsona.getListaPertsona();
		 
		float[] pertsonarenBalorazio = BM.pertsonarenBalorazioa(lp.zeinPosiziotanDago(pertsonaId)); 
		float kosinua= EM.kosinuaAplikatu(pelikulaIzena, pertsonarenBalorazio);
		return kosinua;
		
	}
	
	public LinkedHashMap<String,Float> ordenatu(HashMap<String,Float> HM) {
		HashMap mapResultado = new LinkedHashMap<String,Float>();
		ArrayList<String> Keys = new ArrayList(HM.keySet());
		ArrayList<Float> Values = new ArrayList(HM.values());
		TreeSet conjuntoOrdenado = new TreeSet(Values);
		Object[] arrayOrdenado = conjuntoOrdenado.toArray();
		int size = arrayOrdenado.length;
		for (int i=size-1; i>=0; i--) {
		mapResultado.put
		(Keys.get(
		Values.indexOf(arrayOrdenado[i])),arrayOrdenado[i]);
		}
		return (LinkedHashMap<String, Float>) mapResultado;
		}
	
	public Vector bektore10(LinkedHashMap<String,Float> lHM) throws IOException {
		int kont=0;

		Vector elementuak = new Vector();
		for(Entry<String, Float> entry : lHM.entrySet()){
			if (kont<10) {
				 String key = entry.getKey();
				 Float value = entry.getValue();
				 if(value!=-2.0) {
				String s=(key+": " +value);
				elementuak.addElement(s);
				 }
			}
			kont++;
		}
		
		return elementuak;
	}
	
	//junit
	
	public void bektoreaInprimatu(Vector v) {
		for (int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		
	}
		
	
}