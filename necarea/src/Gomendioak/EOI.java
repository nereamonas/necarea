package Gomendioak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.Vector;

import Klaseak.EtiketaGuztiak;
import Klaseak.ListaPertsona;
import Klaseak.Necarea;
import Klaseak.NecareaPelikulak;

public class EOI implements Gomendioak{
 
	private static EOI nireEOI=null;
	
	private EOI() {
		
	}
	

	public static synchronized EOI getEOI() {
			if (EOI.nireEOI==null) {
				EOI.nireEOI= new EOI();
			}
			return EOI.nireEOI;
	}
	
	
	public LinkedHashMap<String,Float> balorazioakEman(int pertsonaId) { 
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
		float[] antzAplikatuta=EM.antzekotasunaAplikatutaBektore(pertsonarenBalorazio);
		//4- HashMap bat sortu (pelikula, kosinuan ateratako balioa
		HashMap<String,Float> HM= EM.hmSortu(antzAplikatuta);	
		return this.ordenatu(HM);
		
	}
	
	public LinkedHashMap<String,Float> ordenatu(HashMap<String,Float> HM) {
		LinkedHashMap<String, Float> mapResultado = new LinkedHashMap<String,Float>();
		LinkedHashMap<String, Float> map10 = new LinkedHashMap<String,Float>();
		ArrayList<String> Keys = new ArrayList<String>(HM.keySet());
		ArrayList<Float> Values = new ArrayList(HM.values());
		TreeSet conjuntoOrdenado = new TreeSet(Values);
		Object[] arrayOrdenado = conjuntoOrdenado.toArray();
		int size = arrayOrdenado.length;
		for (int i=size-1; i>=0; i--) {
		mapResultado.put
		(Keys.get(
		Values.indexOf(arrayOrdenado[i])),(Float) arrayOrdenado[i]);
		}
		
		final Iterator<Entry<String, Float>> it = mapResultado.entrySet().iterator();
		Entry<String, Float> entry= null;
		int kont=0;
		while (it.hasNext()&& kont<10) {
			entry= it.next();
			String key = entry.getKey();
			 Float value = entry.getValue();
			map10.put(key,value);
			kont++;
		}
			
			
			
		return map10;
		}
	
	

	
	public float baloratuPelikula(String pelikulaIzena, int pertsonaId) { 
		boolean ikusiDu=Necarea.getNecarea().pelikulaIkusiDu(pertsonaId, pelikulaIzena);
		float emaitza=-2;
		if(!ikusiDu) {
			BalorazioMatrize BM = BalorazioMatrize.getBalorazioMatrize();
			EtiketaMatrize EM=EtiketaMatrize.getEtiketaMatrize();
			
			BM.matrizeaSortu();
			EM.MatrizeaSortu();
			
			EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
			NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
			ListaPertsona lp=ListaPertsona.getListaPertsona();
			 
			float[] pertsonarenBalorazio = BM.pertsonarenBalorazioa(lp.zeinPosiziotanDago(pertsonaId)); 
			float antzekotasun= EM.antzekotasunaAplikatu(pelikulaIzena, pertsonarenBalorazio);
			emaitza=antzekotasun;
		}
		
		return emaitza;
		
	}
	

	
	public Vector bektore10(LinkedHashMap<String,Float> lHM) throws IOException {
		int kont=0;
		Vector elementuak = new Vector();
		final Iterator<Entry<String, Float>> it = lHM.entrySet().iterator();
		Entry<String, Float> entry= null;
		
		while (it.hasNext()&& kont<10) {
			entry= it.next();
			String key = entry.getKey();
			Float value = entry.getValue();
			if(value!=-2.0) {
			String s=(key+": " +value);
			elementuak.addElement(s);
			kont++;
			}
		}
			
		
		return elementuak;
	}
	
}