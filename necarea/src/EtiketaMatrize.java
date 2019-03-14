
public class EtiketaMatrize {
	
	
	private static EtiketaMatrize nireEtiketaMatrize=null;
	
	
//eraikitzailea    
	
	private EtiketaMatrize() {	
	}

	public static synchronized EtiketaMatrize EtiketaMatrize() {
			if (EtiketaMatrize.nireEtiketaMatrize==null) {
					EtiketaMatrize.nireEtiketaMatrize= new EtiketaMatrize();
			}
			return EtiketaMatrize.nireEtiketaMatrize;
	}
}
