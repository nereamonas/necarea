package Gomendioak;

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
	
	
	public void matrizeaSortu(float[][] balorazioMatrize, float[][] etiketaMatrize) {
		//1- coger las pelis que tengn >3.5 de valoración - balorazioMatrize
		
		//2-Coges la etiketaMatrize, solo de las pelis que + le han gustado y sumas cada etiketa --> de aquí sacas un vector. q es de todas las pelis que ha visto que le gustan, cuantas veces se ha usado cada etiketa.
		
		//3- el vector ese q has sacado, lo conparas con el de cada pelikula que le ha gustado y las etiketas de esa peli(de la etiketaMatrize) y en cada uno aplicas la formula de kosinu y te da un numero. cuanto mas se acerque al 1 + le ha gustado
		
		
	}
	
}
