
public class EtiketaMatrize {
	
	
	private static EtiketaMatrize nireEtiketaMatrize=null;
	private Float[][] matrize;	
	
//eraikitzailea    
	
	private EtiketaMatrize() {	
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		this.matrize=new Float[np.luzera()][eg.luzera()];
		
	}

	public static synchronized EtiketaMatrize getEtiketaMatrize() {
			if (EtiketaMatrize.nireEtiketaMatrize==null) {
					EtiketaMatrize.nireEtiketaMatrize= new EtiketaMatrize();
			}
			return EtiketaMatrize.nireEtiketaMatrize;
	}
	
	private int[][] lehenengoMatrizeaSortu() {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		int[][]matrizea=new int[np.luzera()][eg.luzera()];
		
		for (int i=0; i<np.luzera();i++) {
			ListaEtiketa le=np.posiziokoPelikularenListaEtiketa(i);
			for (int j=0;j<le.luzera();j++) {
				Etiketa eBat=le.posiziokoEtiketa(i);
				int pos=eg.EtiketarenPosizioa(eBat.getIzena());
				matrizea[i][pos]=eBat.getAldiak();
			}	
		}	
		return matrizea;
	}
	
	public void MatrizeaSortu() {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		int[][] lehenengoMatrizea=this.lehenengoMatrizeaSortu();
		
		for (int i=0;i<eg.luzera();i++) {
			for(int j=0;j<np.luzera();j++) {
				this.matrize[i][j]=(float) (lehenengoMatrizea[i][j]*Math.log10(np.luzera()/eg.kantitatea(eg.posiziokoEtiketaIzena(j))));
			}
		}
		
	}
	
	
	
	
}
