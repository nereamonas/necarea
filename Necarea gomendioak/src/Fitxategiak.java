	import java.io.BufferedReader;
import java.io.File;
	import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Scanner;
	import java.io.IOException;
	
	

public class Fitxategiak {

		private static Fitxategiak  nireFitxategiak =null;
		
		
		
		public Fitxategiak() {
		}
		
		public static synchronized Fitxategiak getFitxategia () {
			if (Fitxategiak.nireFitxategiak==null) {
				Fitxategiak.nireFitxategiak= new Fitxategiak();
			}
			return Fitxategiak.nireFitxategiak;
		}
		
		
		
		public void kargatuTitles() throws FileNotFoundException {
			
			BufferedReader reader = new BufferedReader( new FileReader("movie-titles.csv"));
			
			
			
			
			/*
	
			
			ZinemaGalderaZerrenda listaZinema= ZinemaGalderaZerrenda.getZinemaGalderaZerrenda();
			Zinema z1=null;
			
			InputStream fitx = this.getClass().getClassLoader().getResourceAsStream("galdera/ZinemaGalderak.txt");

			InputStreamReader in= new InputStreamReader(fitx);

			Scanner sc;

			try {
				
				sc = new Scanner(in);
			
				if(fitx!=null) {
			        	
				while (sc.hasNextLine()) {
					String lerroa=sc.nextLine(); 
					String[] galderaEr= lerroa.split("#"); 
					String[] galErk=galderaEr[0].split(";");
				
					String galdera=galErk[0]; 
				
					String erA= galErk[1];
					String erB= galErk[2];
					String erC= galErk[3];
					String erEgokia= galderaEr[1];
				
					z1=new Zinema(galdera, erA, erB, erC, erEgokia); 
					listaZinema.gehituGaldera(z1);
				}
			}else {
				throw (new EzDagoFitxategia());
			}
			
			}catch(EzDagoFitxategia e) {
				e.mezuaBota();
			
			}
		*/
			
			   
			
		}
		
	
}
