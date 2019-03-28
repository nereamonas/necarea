
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
	
}
