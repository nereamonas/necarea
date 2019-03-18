	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

	
	

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
		

		public void kargatuTitles() throws IOException {
			NecareaPelikulak pelikulaZerrenda= NecareaPelikulak.getNecareaPelikulak();
			
			// .csv fitxategia irekitzeko
			BufferedReader reader = new BufferedReader( new FileReader("src/Fitxategiak/movie-titles.csv"));
			
			try {
				Scanner s=new Scanner(reader);

				if(s!=null) {	
					while (s.hasNextLine()) {
						//lerro bat hartuko dugu
						String line=s.nextLine();
						
						//lerro hori, lehenengo ";"-ren bitartez batatuko dugu. (excelen gelaxkak direnak)
						String[] datuGuztiak=line.split(";");
						
						//ondoren datuGuztiak[1], bi zatitan banatu beharko dugu, bertan filmaren titulua eta urtea agertzen delako
						String[] TituluUrtea= datuGuztiak[1].split(Pattern.quote("("));  //no es hasi del todo porq hay otras cosas q tienen parentesis pero bueno
						String[] Urtea= TituluUrtea[1].split(Pattern.quote(")"));
						
						
						//Hau zatiketa ondo egin dela ikusteko
						/*System.out.println();
						System.out.println("id");
						System.out.println(datuGuztiak[0]);
						System.out.println("titulo");
						System.out.println(TituluUrtea[0]);
						System.out.println("a�o");
						System.out.println(Urtea[0]);
						*/
						
						
						//Behin film baten datu guztiak izanda, film-a sortuko dugu eta listan gehituko dugu;
						Pelikula p1= new Pelikula(Integer.parseInt(datuGuztiak[0]),TituluUrtea[0],Integer.parseInt(Urtea[0]));
						pelikulaZerrenda.gehituPelikula(p1);
					}
				}else {
					throw (new EzDagoFitxategia());
				}
				
			}catch(EzDagoFitxategia e) {
				e.mezuaBota();
			}	
		}
		
		public void kargatuTags() throws IOException {
			EtiketaGuztiak EtiketaZerrenda= EtiketaGuztiak.getEtiketaGuztiak();
			NecareaPelikulak pelikulaZerrenda= NecareaPelikulak.getNecareaPelikulak();			
			
			// .csv fitxategia irekitzeko
			BufferedReader reader = new BufferedReader( new FileReader("src/Fitxategiak/movie-tags.csv"));
			
			try {
				Scanner s=new Scanner(reader);

				if(s!=null) {	
					while (s.hasNextLine()) {
						//lerro bat hartuko dugu
						String line=s.nextLine();
						
						//lerro hori, lehenengo ";"-ren bitartez batatuko dugu. (excelen gelaxkak direnak)
						String[] datuGuztiak=line.split(";");
						
						//Hau zatiketa ondo egin dela ikusteko
						/*System.out.println();
						System.out.println("id pelikula");
						System.out.println(datuGuztiak[0]);
						System.out.println("etiketa");
						System.out.println(datuGuztiak[1]);
						*/
						
						//Datuekin etiketa sortu
						Etiketa e1=new Etiketa(Integer.parseInt(datuGuztiak[0]), datuGuztiak[1]);
						
						//busco la peli para a�adirle la etiketa
						Pelikula peli = pelikulaZerrenda.pelikulaBilatuIdz(Integer.parseInt(datuGuztiak[0]));
						if (peli!=null) {//pelikula existitzen da eta etiketa gehituko zaio
							peli.gehituEtiketa(e1);
						}
						
						//Si el nombre de la etiketa no se ha dicho, la a�adiremos a etiketaGuztiak
						boolean dago=EtiketaZerrenda.bilatuEtiketaIzena(datuGuztiak[1]);
						if(!dago) {  //si no esta a�adimos, sino nada
							EtiketaZerrenda.gehituEtiketa(datuGuztiak[1]);
						}
					}
				}else {
					throw (new EzDagoFitxategia());
				}
				
			}catch(EzDagoFitxategia e) {
				e.mezuaBota();
			}	
		} 
		

		public void kargatuRatings() throws IOException {
			ListaPertsona pertsonaZerrenda= ListaPertsona.getListaPertsona();
			NecareaPelikulak pelikulaZerrenda=NecareaPelikulak.getNecareaPelikulak();
			
			// .csv fitxategia irekitzeko
			BufferedReader reader = new BufferedReader( new FileReader("src/Fitxategiak/movie-ratings.csv"));
			
			try {
				Scanner s=new Scanner(reader);

				if(s!=null) {	
					while (s.hasNextLine()) {
						//lerro bat hartuko dugu
						String line=s.nextLine();
						
						//lerro hori, lehenengo ";"-ren bitartez batatuko dugu. (excelen gelaxkak direnak)
						String[] datuGuztiak=line.split(",");
						
						//Hau zatiketa ondo egin dela ikusteko
						/*System.out.println();
						System.out.println("pertsona id");
						System.out.println(datuGuztiak[0]);
						System.out.println("peli id");
						System.out.println(datuGuztiak[1]);
						System.out.println("peli balorazio");
						System.out.println(datuGuztiak[2]);
						*/
						
						//sartu balorazioa
						Pertsona badago= pertsonaZerrenda.bilatuPertsonaIdz(Integer.parseInt(datuGuztiak[0]));
						
						Pelikula pelihori=pelikulaZerrenda.pelikulaBilatuIdz(Integer.parseInt(datuGuztiak[1]));
						if (badago!=null) {
							badago.grafoaraBalorazioaGehitu(Integer.parseInt(datuGuztiak[1]),Float.parseFloat(datuGuztiak[2]));
							badago.pelikulaGehitu(pelihori);
						}else {
							Pertsona p1= new Pertsona(Integer.parseInt(datuGuztiak[0]));
							pertsonaZerrenda.gehituPertsona(p1);
							p1.grafoaraBalorazioaGehitu(Integer.parseInt(datuGuztiak[1]),Float.parseFloat(datuGuztiak[2]));
							p1.pelikulaGehitu(pelihori);
						}
						
					}  
				}else {
					throw (new EzDagoFitxategia());
				}
				
			}catch(EzDagoFitxategia e) {
				e.mezuaBota();
			}	
		}			
		
		
	
}
