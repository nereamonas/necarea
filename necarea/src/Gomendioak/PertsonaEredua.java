package Gomendioak;

import Klaseak.EtiketaGuztiak;
import Klaseak.NecareaPelikulak;
import Klaseak.Pertsona;

public class PertsonaEredua {
 
	Float[][] matrizea;
	private static PertsonaEredua nirePertsonaEredua=null;
	
	public PertsonaEredua() {
		this.matrizea=new Float[2][2];
	}
	

	public static synchronized PertsonaEredua getPertsonaEredua() {
			if (PertsonaEredua.nirePertsonaEredua==null) {
				PertsonaEredua.nirePertsonaEredua= new PertsonaEredua();
			}
			return PertsonaEredua.nirePertsonaEredua;
	}
	
	
	public float[] matrizeaSortu(float[][] balorazioMatrize, float[][] etiketaMatrize, int pertsonaId) {
		EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
		NecareaPelikulak np=NecareaPelikulak.getNecareaPelikulak();
		//1- coger las pelis que tengn >3.5 de valoración - balorazioMatrize
		float[][] matrizP=new float[np.luzera()][eg.luzera()];
		int kontM=0;
		
		float[][] matrizPeliEzIkusitak= new float[np.luzera()][eg.luzera()];
		float[] pertsonarenBalorazio = balorazioMatrize[pertsonaId];
		
		//recorres la etiketaMatrize cogiendo las pelis que ha visto la persona y q sean >3.5
		for (int i=0;i<pertsonarenBalorazio.length;i++) {
			if (pertsonarenBalorazio[i]>3.5) {
				matrizP[kontM]=etiketaMatrize[i];
				kontM++;
			}
		}

		//2-Coges la etiketaMatrize, solo de las pelis que + le han gustado y sumas cada etiketa --> de aquí sacas un vector. q es de todas las pelis que ha visto que le gustan, cuantas veces se ha usado cada etiketa.
		
		//gehitu
		float[] gehitura=new float[eg.luzera()];
		
		for (int i=0;i<matrizP.length;i++) {
			for (int j=0;j<matrizP[0].length;i++) {
				gehitura[j]=gehitura[j]+matrizP[i][j];
			}
		}
		//ya tenemos el vector --> gehitura
		
		
		
		//hacer una matriz con las pelis que no ha visto:
		for (int i=0;i<balorazioMatrize.length;i++) {
			if(pertsonarenBalorazio[i]!=0) {
				matrizPeliEzIkusitak[i]=balorazioMatrize[i];
			}
		}
		
		
		//hacer la formula del cos
		float[] kosinuaAplikatuta=new float[matrizPeliEzIkusitak.length];
		for (int i=0;i<matrizPeliEzIkusitak.length;i++) {
			float[] vectorBat=matrizP[i];
			float kosinua=kosinuaKalkulatu(gehitura,vectorBat);
			kosinuaAplikatuta[i]=kosinua;
		}
		
		
		return kosinuaAplikatuta;
		//3- el vector ese q has sacado, lo conparas con el de cada pelikula que le ha gustado y las etiketas de esa peli(de la etiketaMatrize) y en cada uno aplicas la formula de kosinu y te da un numero. cuanto mas se acerque al 1 + le ha gustado
		
		
	}
	
	public float kosinuaKalkulatu(float[] gehitura, float[] vectorBat) {
		
		//hay q rellenarlo jaja es poner solo la formula
		float emaitza;
		
		float bat=(float) 0.0;
		float bi=(float) 0.0;
		float hiru=(float) 0.0;
		
		for (int i=0;i<gehitura.length;i++) {
			bat=bat + gehitura[i]*vectorBat[i];
			bi=bi+gehitura[i]*gehitura[i];
			hiru=hiru+vectorBat[i]*vectorBat[i];
		}
		
		emaitza=bat/(bi*hiru);
		
		return emaitza;
	}
	
}
