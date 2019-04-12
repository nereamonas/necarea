package Gomendioak;

public class ErabiltzaileetanOinarritutakoIragazte {
	private static ErabiltzaileetanOinarritutakoIragazte nireErabiltzaileetanOinarritutakoIragazte=null;
	
	public ErabiltzaileetanOinarritutakoIragazte() {
	
	}
	

	public static synchronized ErabiltzaileetanOinarritutakoIragazte getErabiltzaileetanOinarritutakoIragazte() {
			if (ErabiltzaileetanOinarritutakoIragazte.nireErabiltzaileetanOinarritutakoIragazte==null) {
				ErabiltzaileetanOinarritutakoIragazte.nireErabiltzaileetanOinarritutakoIragazte= new ErabiltzaileetanOinarritutakoIragazte();
			}
			return ErabiltzaileetanOinarritutakoIragazte.nireErabiltzaileetanOinarritutakoIragazte;
	}
	
	public void baloratu(int pertsonaId,String peliIzen) {
		BalorazioMatrize balorazioMatrize=BalorazioMatrize.getBalorazioMatrize();
	}
	
}
