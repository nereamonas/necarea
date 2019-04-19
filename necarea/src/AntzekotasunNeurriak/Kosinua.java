package AntzekotasunNeurriak;

public class Kosinua implements AntzekotasunNeurriak {
	public Kosinua() {}

	public float metodoaAplikatu(float[] gehitura, float[] vectorBat) {
		
		
		float emaitza;
		
		float bat=(float) 0.0;
		float bi=(float) 0.0;
		float hiru=(float) 0.0;
		
		for (int i=0;i<gehitura.length;i++) {
			bat=bat + gehitura[i]*vectorBat[i];
			bi=bi+gehitura[i]*gehitura[i];
			hiru=hiru+vectorBat[i]*vectorBat[i];
		}
		
		emaitza=(float) (bat/(Math.sqrt(bi)*Math.sqrt(hiru)));
		
		return emaitza;
	}
}