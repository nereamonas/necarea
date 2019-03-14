 
public class BalorazioMatrize {
	private static BalorazioMatrize nireBalorazioMatrize=null;
	
	
	//eraikitzailea
		
		private BalorazioMatrize() {	
		}

		public static synchronized BalorazioMatrize BalorazioMatrize() {
				if (BalorazioMatrize.nireBalorazioMatrize==null) {
					BalorazioMatrize.nireBalorazioMatrize= new BalorazioMatrize();
				}
				return BalorazioMatrize.nireBalorazioMatrize;
		}
}
