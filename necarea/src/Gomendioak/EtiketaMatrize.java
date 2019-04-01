package Gomendioak;
import Klaseak.Etiketa;
import Klaseak.EtiketaGuztiak;
import Klaseak.ListaEtiketa;
import Klaseak.NecareaPelikulak;

public class EtiketaMatrize {
	
	
	private static EtiketaMatrize nireEtiketaMatrize=null;
	private float[][] matrize;	
	 
//eraikitzailea    
	
	private EtiketaMatrize() {	
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		this.matrize=new float[np.luzera()][eg.luzera()];
		
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
		int[][]matrizea=new int[np.luzera()][eg.luzera()];
		
		for (int i=0; i<np.luzera();i++) {
			ListaEtiketa le=np.posiziokoPelikularenListaEtiketa(i);
			for (int j=0;j<le.luzera();j++) {
				Etiketa eBat=le.posiziokoEtiketa(j);
				int pos=eg.EtiketarenPosizioa(eBat.getIzena());
				matrizea[i][pos]=eBat.getAldiak();
			
			}	
		}	
		return matrizea;
	}
	
	public float[][] MatrizeaSortu() {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		int[][] lehenengoMatrizea=this.lehenengoMatrizeaSortu();
		float[][] m=new float[np.luzera()][eg.luzera()];
		for (int i=0;i<np.luzera();i++) {
			for(int j=0;j<eg.luzera();j++) {
				m[i][j]=(float) (lehenengoMatrizea[i][j]*Math.log10(np.luzera()/eg.kantitatea(eg.posiziokoEtiketaIzena(j))));
			}
		}
		 this.matrize=m;
		return m;
		
	}
	
	
	
	
}
