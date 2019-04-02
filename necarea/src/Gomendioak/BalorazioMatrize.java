package Gomendioak;
import Klaseak.ListaPertsona;
import Klaseak.NecareaPelikulak;
import Klaseak.Pertsona;

public class BalorazioMatrize {
	
	private float[][] mat;
	private static BalorazioMatrize nireBalorazioMatrize=null;
	
	 
	//eraikitzailea
		
		private BalorazioMatrize() {
			ListaPertsona lp=ListaPertsona.getListaPertsona();
			NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
			this.mat= new float[lp.luzera()][np.luzera()];
		}

		public static synchronized BalorazioMatrize getBalorazioMatrize() {
				if (BalorazioMatrize.nireBalorazioMatrize==null) {
					BalorazioMatrize.nireBalorazioMatrize= new BalorazioMatrize();
				}
				return BalorazioMatrize.nireBalorazioMatrize;
		}
		
		public float[][] matrizeaSortu() {
			ListaPertsona lp=ListaPertsona.getListaPertsona();
			NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
			float[][] mat2=new float[lp.luzera()][np.luzera()];
			for(int i=0; i<lp.luzera();i++) {
				Pertsona p1=lp.posiziokoPertsona(i);
				//System.out.println(i+1 + ". pertsonara heldu gara (i. errenkada)");
				for(int j=0;j<p1.zenbatPelikulaIkusi();j++) {
					//System.out.println(i+1 + ". pertsonak ikusitako " + j + ". pelikulara heldu gara (j. zutabea)");
					mat2[i][np.zeinPosiziotanDago(p1.pelikularenId(j))]=p1.posiziokoPelikularenBalorazioa(j);
				}
			}
			mat=mat2;
			return mat;
		}
		
		//Junit-etarako
		
		public float posiziokoBalorazioa(int pertsonaId, int peliId) {
			NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
			ListaPertsona lp=ListaPertsona.getListaPertsona();
			return mat[lp.zeinPosiziotanDago(pertsonaId)][np.zeinPosiziotanDago(peliId)];
		}

}