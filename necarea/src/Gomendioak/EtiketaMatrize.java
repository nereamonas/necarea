package Gomendioak;
import java.util.HashMap;

import AntzekotasunNeurriak.AntzekotasunNeurriak;
import AntzekotasunNeurriak.Kosinua;
import Klaseak.Etiketa;
import Klaseak.EtiketaGuztiak;
import Klaseak.ListaEtiketa;
import Klaseak.NecareaPelikulak;

public class EtiketaMatrize {
	
	
	private static EtiketaMatrize nireEtiketaMatrize=null;
	private float[][] matrize;	
	private AntzekotasunNeurriak an;
	 
//eraikitzailea    
	
	private EtiketaMatrize() {	
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		this.matrize=new float[np.luzera()][eg.luzera()];
		this.an=new Kosinua();
		
	}

	public static synchronized EtiketaMatrize getEtiketaMatrize() {
			if (EtiketaMatrize.nireEtiketaMatrize==null) {
					EtiketaMatrize.nireEtiketaMatrize= new EtiketaMatrize();
			}
			return EtiketaMatrize.nireEtiketaMatrize;
	}
	
	public int[][] lehenengoMatrizeaSortu() {   //cambiar luego a privado, q es para comprobarlo
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		int[][]matriz=new int[np.luzera()][eg.luzera()];
		
		for (int i=0; i<np.luzera();i++) {
			ListaEtiketa le=np.posiziokoPelikularenListaEtiketa(i);
			for (int j=0;j<le.luzera();j++) {
				Etiketa eBat=le.posiziokoEtiketa(j);
				int pos=eg.EtiketarenPosizioa(eBat.getIzena());
				matriz[i][pos]=eBat.getAldiak();
			}	
		}	
		/*System.out.println();
		System.out.println();
		System.out.println("Etiketa matrizea(formula aplikatu gabe): ");
		System.out.println();
		for (int i=0;i<matrizea.length;i++) {
			for(int j=0;j<matrizea[0].length;j++) {
				System.out.print(matrizea[i][j] + "  ");
			}
			System.out.println();
		}*/
		return matriz;
	}
	
	public void MatrizeaSortu() {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		int[][] lehenengoMatrizea=this.lehenengoMatrizeaSortu();
		float[][] m=new float[np.luzera()][eg.luzera()];
		for (int i=0;i<np.luzera();i++) {
			for(int j=0;j<eg.luzera();j++) {
				if (eg.kantitatea(eg.posiziokoEtiketaIzena(j))==0){
					m[i][j]=(float)0.0;
				
				}else {
					float bat=(float) lehenengoMatrizea[i][j];
					float bi=(float) np.luzera();
					float hiru=(float)eg.kantitatea(eg.posiziokoEtiketaIzena(j));
					m[i][j]=(float) (bat*Math.log10(bi/hiru));
					
				}
			}
		}
		this.matrize=m;
		/*System.out.println();
		System.out.println();
		System.out.println("Etiketa matrizea(formula aplikatuta): ");
		System.out.println();
		this.matrizeaInprimatu();
		*/
		
		
	}
	
	
	public int posiziokoZenbakiaLehenengoMatrizean(int peliId,String etiketaIzena) {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		int[][] mat=this.lehenengoMatrizeaSortu();
		
		return mat[np.zeinPosiziotanDago(peliId)][eg.EtiketarenPosizioa(etiketaIzena)];
	}
	
	public float posiziokoZenbakiaBigarrenMatrizean(int peliId,String etiketaIzena) {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		
		return matrize[np.zeinPosiziotanDago(peliId)][eg.EtiketarenPosizioa(etiketaIzena)];
	}
	
	public void matrizeaInprimatu() {
		for (int i=0;i<matrize.length;i++) {
			for(int j=0;j<matrize[0].length;j++) {
				System.out.print(matrize[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	
	//Ikusi dituen eta 3.5 baino gehiagoko balorazioa eman dien pelikulak hartuko dira. Gehitura izeneko bektore bat sortuko dugu eta posizio bakoitzean orain esandako pelikula guztien etiketa bakoitzaren batura gordeko da.
	public float [] gehituraKalkulatu(float[] perBalorazioa) {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		float[] gehitura=new float[eg.luzera()];
		for (int i=0;i<this.matrize.length;i++) {
			if (perBalorazioa[i]>=3.5) {
				//Pelikula ikusi du eta gainera 3.5 baino gehiago emana dio
				for(int j=0;j<this.matrize[i].length;j++) {
					gehitura[j]=gehitura[j]+this.matrize[i][j];
				}
			}
		}
		return gehitura;
	}
	//Kosinua formula kalkulatuko dugu, ikusi nahi duen pelikularekin	
	public float antzekotasunaAplikatu(String peliIzen, float[] perBalorazioa) {
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		float[] nahiDuenPelikulaEtiketak = this.matrize[np.bilatuPelikularenPosizioa(peliIzen)];
		float kosinua=an.metodoaAplikatu(this.gehituraKalkulatu(perBalorazioa),nahiDuenPelikulaEtiketak);
		return kosinua;
		
	}

	
	//metodo handiarentzat 
	
	public float[] antzekotasunaAplikatutaBektore(float[] pertsonarenBalorazio) {
	NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();	
	float[] gehitura=this.gehituraKalkulatu(pertsonarenBalorazio);
	float[] antzAplikatuta=new float[np.luzera()];
	for (int i=0;i<this.matrize.length;i++) {
		if (pertsonarenBalorazio[i]==0.0) {
			//Ez du pelikulaIkusi
			float[] vectorBat=this.matrize[i];
			float antz=an.metodoaAplikatu(gehitura,vectorBat);
			antzAplikatuta[i]=antz;
		}else {
			//Pelikula ikusi du
			antzAplikatuta[i]=(float) -2.0;
		}
	}
	return antzAplikatuta;
	}
	//hasMap sortu
	public HashMap<String,Float> hmSortu(float[] antzAplikatuta){
	HashMap<String,Float> HM= new HashMap<String, Float>();
	NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
	for (int i=0; i<this.matrize.length;i++) {
		HM.put(np.posiziokoPelikularenIzena(i), antzAplikatuta[i]);
	}
	return HM;
	

}
}