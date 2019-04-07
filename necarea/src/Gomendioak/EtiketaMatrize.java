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
		System.out.println();
		System.out.println();
		System.out.println("Etiketa matrizea(formula aplikatu gabe): ");
		System.out.println();
		/*for (int i=0;i<matrizea.length;i++) {
			for(int j=0;j<matrizea[0].length;j++) {
				System.out.print(matrizea[i][j] + "  ");
			}
			System.out.println();
		}*/
		return matrizea;
	}
	
	public float[][] MatrizeaSortu() {
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
		System.out.println();
		System.out.println();
		System.out.println("Etiketa matrizea(formula aplikatuta): ");
		System.out.println();
		//this.matrizeaInprimatu();
		return m;
		
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
	
}