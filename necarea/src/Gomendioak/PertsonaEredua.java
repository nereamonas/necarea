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
	
	
	public LinkedHashMap<String,Float> balorazioakEman(int pertsonaId) {
		BalorazioMatrize BM = BalorazioMatrize.getBalorazioMatrize();
		EtiketaMatrize EM=EtiketaMatrize.getEtiketaMatrize();
		float[][] balorazioMatrize=BM.matrizeaSortu();
		float[][] etiketaMatrize=EM.MatrizeaSortu();
		
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		ListaPertsona lp=ListaPertsona.getListaPertsona();
		//1- Balorazio matrizean pertsona bilatuko dugu (id-a, matrizearen posizioa da). Pertsona horren pelikula errenkada hartuko dugu. 
		float[] pertsonarenBalorazio = balorazioMatrize[lp.zeinPosiziotanDago(pertsonaId)];
		
		
		//2- Ikusi dituen eta 3.5 baino gehiagoko balorazioa eman dien pelikulak hartuko dira. Gehitura izeneko bektore bat sortuko dugu eta posizio bakoitzean orain esandako pelikula guztien etiketa bakoitzaren batura gordeko da
		//3- Beste bektore bat sortuko dugu kosinuaAplikatuta izenekoa. Ikusi ez dit

		float[] gehitura=new float[eg.luzera()];
		for (int i=0;i<etiketaMatrize.length;i++) {
			if (pertsonarenBalorazio[i]>3.5) {
				//Pelikula ikusi du eta gainera 3.5 baino gehiago emana dio
				for(int j=0;j<etiketaMatrize[i].length;j++) {
					gehitura[j]=gehitura[j]+etiketaMatrize[i][j];
				}
			}
		}
		

		
		//3- Beste bektore bat sortuko dugu kosinuaAplikatuta izenekoa. Ikusi ez dituen pelikulak begiratu beharko ditugu eta kosinua formula aplikatu etiketaMatrizeko errenkada bakoitza gehitura bektorearekin.
		//Ezin dugu goiko for-a erabili, oraindik gehitura bektorea sortuta ez dugulako
		float[] kosinuaAplikatuta=new float[np.luzera()];
		for (int i=0;i<etiketaMatrize.length;i++) {
			if (pertsonarenBalorazio[i]==0.0) {
				//Ez du pelikulaIkusi
				float[] vectorBat=etiketaMatrize[i];
				float kosinua=kosinuaKalkulatu(gehitura,vectorBat);
				kosinuaAplikatuta[i]=kosinua;
			}else {
				//Pelikula ikusi du
				kosinuaAplikatuta[i]=(float) -2.0;
			}
		}
		
		//4- HashMap bat sortu (pelikula, kosinuan ateratako balioa
		HashMap<String,Float> HM= new HashMap<String, Float>();
		
		for (int i=0; i<etiketaMatrize.length;i++) {
			HM.put(np.posiziokoPelikularenIzena(i), kosinuaAplikatuta[i]);
		}
		
		//Faltaria ordenarlo cogiendo las 10 primeras solo
		
		return this.ordenatu(HM);
		
	}
	
	
	
	
	public float baloratuPelikula(String pelikulaIzena, int pertsonaId) {
		BalorazioMatrize BM = BalorazioMatrize.getBalorazioMatrize();
		EtiketaMatrize EM=EtiketaMatrize.getEtiketaMatrize();
		float[][] balorazioMatrize=BM.matrizeaSortu();
		float[][] etiketaMatrize=EM.MatrizeaSortu();
		
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		ListaPertsona lp=ListaPertsona.getListaPertsona();
		//1- Balorazio matrizean pertsona bilatuko dugu (id-a, matrizearen posizioa da). Pertsona horren pelikula errenkada hartuko dugu. 
		float[] pertsonarenBalorazio = balorazioMatrize[lp.zeinPosiziotanDago(pertsonaId)];
		
		//2- Ikusi dituen eta 3.5 baino gehiagoko balorazioa eman dien pelikulak hartuko dira. Gehitura izeneko bektore bat sortuko dugu eta posizio bakoitzean orain esandako pelikula guztien etiketa bakoitzaren batura gordeko da
		//3- Beste bektore bat sortuko dugu kosinuaAplikatuta izenekoa. Ikusi ez dit
		float[] gehitura=new float[eg.luzera()];
		for (int i=0;i<etiketaMatrize.length;i++) {
			if (pertsonarenBalorazio[i]>=3.5) {
				//Pelikula ikusi du eta gainera 3.5 baino gehiago emana dio
				for(int j=0;j<etiketaMatrize[i].length;j++) {
					gehitura[j]=gehitura[j]+etiketaMatrize[i][j];
				}
			}
		}
		
		  
		/*for (int k=0;k<gehitura.length;k++) {
			System.out.print(gehitura[k] + "  ");
		}*/
		
		//3- Kosinua formula kalkulatuko dugu, ikusi nahi duen pelikularekin
		float[] nahiDuenPelikulaEtiketak = etiketaMatrize[np.bilatuPelikularenPosizioa(pelikulaIzena)];
		float kosinua=kosinuaKalkulatu(gehitura,nahiDuenPelikulaEtiketak);
		
		
		return kosinua;
		//return 0;
	}
	
	
	
	
	public float kosinuaKalkulatu(float[] gehitura, float[] vectorBat) {
		
		
		float emaitza;
		
		float bat=(float) 0.0;
		float bi=(float) 0.0;
		float hiru=(float) 0.0;
		
		for (int i=0;i<gehitura.length;i++) {
			bat=bat + gehitura[i]*vectorBat[i];
			bi=bi+gehitura[i]*gehitura[i];
			hiru=hiru+vectorBat[i]*vectorBat[i];
		}
		
		emaitza=(float) (bat/(Math.sqrt(bi)*Math.sqrt(hiru)));
		
		return emaitza;
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
				String s=(key+": " +value);
				elementuak.addElement(s);
			}
			kont++;
		}
		
		return elementuak;
	}
		
	
}
