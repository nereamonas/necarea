package Gomendioak;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;
import Klaseak.EtiketaGuztiak;
import Klaseak.ListaPertsona;
import Klaseak.Necarea;
import Klaseak.NecareaPelikulak;

public class PertsonaEreduaTest {
	
	BalorazioMatrize balorazioMatrize;
	EtiketaMatrize etiketaMatrize;
	PertsonaEredua pertsonaEredua;
	Fitxategi_CSV f;
	NecareaPelikulak np;
	EtiketaGuztiak eg;
	ListaPertsona lp;
	Necarea n;
	Kosinua kos;
	
	@Before
	public void setUp() throws Exception {
		balorazioMatrize=BalorazioMatrize.getBalorazioMatrize();
		etiketaMatrize=EtiketaMatrize.getEtiketaMatrize();
		pertsonaEredua=PertsonaEredua.getPertsonaEredua();
		f=new Fitxategi_CSV();
		eg=EtiketaGuztiak.getEtiketaGuztiak();
		np = NecareaPelikulak.getNecareaPelikulak();
		lp=ListaPertsona.getListaPertsona();
		n=Necarea.getNecarea();
		kos= new Kosinua();
		

		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPertsonaEredua() throws FileNotFoundException {
		np.erreseteatu();
		lp.erreseteatu();
		f.kargatuTitles();
		f.kargatuTags();
		f.kargatuRatings();

		//guztia ondo kargatu dela ikusi:
		System.out.println("LISTA PERTSONAK:");
		lp.inprimatu();
		System.out.println("");
		System.out.println("----------------------------------");
 		System.out.println();
		
		System.out.println("ETIKETA GUZTIAK:");
		eg.inprimatuEtiketaIzenak();
		System.out.println("");
		
		System.out.println("HashMap-a imprimatu");
		eg.imprimirHM();
		System.out.println("");
		System.out.println("----------------------------------");
 		System.out.println();
		
		System.out.println("NECAREA PELIKULAK:");
		np.inprimatuPelikulak();
		System.out.println("");
		System.out.println("---------------------------------------------------");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		//Matrizeak. 
		//1- Balorazio matrizea
		System.out.println("MATRIZEAK");
		System.out.println("   1- BALORAZIO MATRIZEA");
		balorazioMatrize.matrizeaSortu();
		//inprimatu
		balorazioMatrize.bmImprimatu();
		 System.out.println();
		 System.out.println();
	     System.out.println("  --------------------------------");
	 		System.out.println();
		 System.out.println();
		 
		 
		 
		 //2- Etiketa matrizea - lehenengo matrizea
		 System.out.println("   2- ETIKETA MATRIZEA - lehenengo matrizea");
		 int[][] mm= etiketaMatrize.lehenengoMatrizeaSortu();
			//inprimatu
		 balorazioMatrize.bmImprimatu();  
			 
			 System.out.println();
	         System.out.println();
	 		System.out.println("  --------------------------------");
	 		System.out.println();
	         System.out.println();


	 	//3- ETIKETA MATRIZEA - bigarren matrizea
	    System.out.println("   3- ETIKETA MATRIZEA - bigarren matrizea");
	    etiketaMatrize.MatrizeaSortu();
	 	//inprimatu
	    etiketaMatrize.emImprimatu();
 		System.out.println();
 		System.out.println();
		System.out.println("  --------------------------------");
 		System.out.println();
 		System.out.println();
 		
 		//4- PERTSONA EREDUA
 		System.out.println("   4- PERTSONA EREDUA ");
 		System.out.println("   BALORAZIO GUZTIAK ");
 		//1 pertsonaren pelikulak
 		System.out.println("       1 PERTSONAREN BALORAZIOAK ");
 		LinkedHashMap<String,Float> hm=pertsonaEredua.balorazioakEman(1);

 		for(String key : hm.keySet()) {
 			System.out.println(key + ": " + hm.get(key));
 		}
 		System.out.println();
		System.out.println("    -------------------------");
 		System.out.println();
 		
 		
 		//2 pertsonaren pelikulak
 		System.out.println("       2 PERTSONAREN BALORAZIOAK ");
 		LinkedHashMap<String,Float> hm2=pertsonaEredua.balorazioakEman(2);

 		for(String key : hm2.keySet()) {
 			System.out.println(key + ": " + hm2.get(key));
 		}
 		System.out.println();
		System.out.println("    -------------------------");
 		System.out.println();
 		

 		//3 pertsonaren pelikulak
 		System.out.println("       3 PERTSONAREN BALORAZIOAK ");
 		LinkedHashMap<String,Float> hm3=pertsonaEredua.balorazioakEman( 3); 
 			
 		for(String key : hm3.keySet()) {
 			System.out.println(key + ": " + hm3.get(key));
 		} 
 		System.out.println();
		System.out.println("    -------------------------");
 		System.out.println();
 		
 		
 		
 		//4 pertsonaren pelikulak
 		System.out.println("       4 PERTSONAREN BALORAZIOAK ");
 		LinkedHashMap<String,Float> hm4=pertsonaEredua.balorazioakEman(4); 
 			
 		for(String key : hm4.keySet()) {
 			System.out.println(key + ": " + hm4.get(key));
 		} 
 		System.out.println();
		System.out.println("    -------------------------");
 		System.out.println();
		
		
		//5 pertsonaren pelikulak
 		System.out.println("       5 PERTSONAREN BALORAZIOAK ");
 		LinkedHashMap<String,Float> hm5=pertsonaEredua.balorazioakEman( 5); 
 			
 		for(String key : hm5.keySet()) {
 			System.out.println(key + ": " + hm5.get(key));
 		} 
 		System.out.println();
 		System.out.println("---------------------------------------------------");
	
 		System.out.println();
 		System.out.println();
 		
 		
 		System.out.println(pertsonaEredua.baloratuPelikula("Stargate ", 4045));
		System.out.println(pertsonaEredua.baloratuPelikula("Twelve Monkeys [a.k.a. 12 Monkeys] ", 4045));
		System.out.println(pertsonaEredua.baloratuPelikula( "Seven [a.k.a. Se7en] ", 4045));
		System.out.println(pertsonaEredua.baloratuPelikula("Sin City ", 4045));
		System.out.println(pertsonaEredua.baloratuPelikula("Star Wars: Episode IV - A New Hope ", 4045));
		
	
	
	}


	@Test
	public void testKosinuaKalkulatu() {
		System.out.println();
		System.out.println();
		System.out.println();
        float[] e=new float[3];
        e[0]=(float)0.3;
        e[1]=(float)0.6;
        e[2]=(float)0.4;
        
        float[] i=new float[3];
        i[0]=(float)-0.1;
        i[1]=(float)0.3;
        i[2]=(float)0.4;
       float u= kos.metodoaAplikatu(e,i);
       System.out.println("KOSINUAREN EMAITZA:"); 
       System.out.println(u);
	}
	@Test
	public void testbektore10() throws IOException {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("4045 erabiltzaileari gehien gustatuko zaizkion 10 pelikula:"); 
	       
		Vector v= n.gehienGustatukoZaizkionPelikulak(4045);
		pertsonaEredua.bektoreaInprimatu(v);		
		
	}
	
	
	
	

}