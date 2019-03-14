	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

	
	  

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
						
						//Hau zatiketa ondo egin dela ikusteko
						System.out.println();
						System.out.println("id");
						System.out.println(datuGuztiak[0]);
						System.out.println("titulo");
						System.out.println(datuGuztiak[1]);
						
						//ondoren datuGuztiak[1], bi zatitan banatu beharko dugu, bertan filmaren titulua eta urtea agertzen delako
						String[] TituluUrtea= datuGuztiak[1].split("(");  //no es hasi del todo porq hay otras cosas q tienen parentesis pero bueno
						
						
						//------------------------------
						//Behin film baten datu guztiak izanda, film-a sortuko dugu eta listan gehituko dugu;
						//Pelikula p1= new Pelikula(datuGuztiak[0],TituluUrtea[0],TituluUrtea[1]);
						//pelikulaZerrenda.gehituPelikula(p1);
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
						System.out.println();
						System.out.println("id pelikula");
						System.out.println(datuGuztiak[0]);
						System.out.println("etiketa");
						System.out.println(datuGuztiak[1]);
						
						//Datuekin etiketa sortu
						Etiketa e1=new Etiketa(Integer.parseInt(datuGuztiak[0]), datuGuztiak[1]);
						//begiratu listan jada etiketa hori dagoen:
						Etiketa badago = EtiketaZerrenda.etiketaBilatu(e1);
						if(badago!=null) {
							badago.gehituBesteBat(); //Etiketa existitzen bada, gehitzen diogu beste aldi batean agertu dela
						}else {
							//si aun no está creada, la creamos
							EtiketaZerrenda.gehituEtiketa(e1);
							//y vamos a buscar la peli a la que le hace referencia y se la añadimoa a ella tambn
							Pelikula peli = pelikulaZerrenda.pelikulaBilatuIdz(Integer.parseInt(datuGuztiak[0]));
							if (peli!=null) {//pelikula existitzen da eta etiketa gehituko zaio
								peli.EtiketaGehitu(e1);
							}
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
						System.out.println();
						System.out.println("pertsona id");
						System.out.println(datuGuztiak[0]);
						System.out.println("peli id");
						System.out.println(datuGuztiak[1]);
						System.out.println("peli balorazio");
						System.out.println(datuGuztiak[2]);
						
						//sartu balorazioa
						Pertsona badago= pertsonaZerrenda.bilatuPertsonaIdz(Integer.parseInt(datuGuztiak[0]));
						if (badago!=null) {
							badago.grafoaraBalorazioaGehitu(Integer.parseInt(datuGuztiak[1]),Float.parseFloat(datuGuztiak[2]));
						}else {
							Pertsona p1= new Pertsona(Integer.parseInt(datuGuztiak[0]));
							p1.grafoaraBalorazioaGehitu(Integer.parseInt(datuGuztiak[1]),Float.parseFloat(datuGuztiak[2]));
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

