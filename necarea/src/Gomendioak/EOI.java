package Gomendioak;
public class EOI extends Gomendioak{

	private EtiketaMatrize etiketaMatrize;
	private PertsonaEredua pertsonaEredua;
	
	public EOI() {
		this.etiketaMatrize=EtiketaMatrize.getEtiketaMatrize();
		this.pertsonaEredua=PertsonaEredua.getPertsonaEredua();
	}
	
}
