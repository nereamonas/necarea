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
		
		public void matrizeaSortu() {
			ListaPertsona lp=ListaPertsona.getListaPertsona();
			
			for(int i=0; i<lp.luzera();i++) {
				Pertsona p1=lp.bilatuPertsonaIdz(i);
				for(int j=0;j<p1.zenbatPelikulaIkusi();j++) {
					mat[i][p1.pelikularenId(j)]=p1.posiziokoPelikularenBalorazioa(j);
				}
			}
		}

}
