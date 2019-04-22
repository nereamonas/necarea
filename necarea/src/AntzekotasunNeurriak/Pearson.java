package AntzekotasunNeurriak;

public class Pearson implements AntzekotasunNeurriak {
	public Pearson() {}

	public float metodoaAplikatu(float[] gehitura, float[] vectorBat) {
			float gehiG=0;
			float gehiV=0;
			
			for(int i=0;i<gehitura.length;i++) {
				gehiG=gehiG+gehitura[i];
				gehiV=gehiV+vectorBat[i];
			}
			float bbg=gehiG/gehitura.length;
			float bbv=gehiV/vectorBat.length;
			
			float bek1=0;
			float bek2=0;
			float biderk=0;
			for(int j=0;j<gehitura.length;j++) {
				bek1=bek1+((gehitura[j]-bbg)*(gehitura[j]-bbg));
				bek2=bek2+((vectorBat[j]-bbv)*(vectorBat[j]-bbv));
				biderk=biderk+((gehitura[j]-bbg)*(vectorBat[j]-bbv));
			}
			
			float formula=0;
			formula=biderk/(float)(Math.sqrt(bek1)*Math.sqrt(bek2));
			
			return formula;
			
	}
}