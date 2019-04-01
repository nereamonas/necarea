package Gomendioak;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;
import Klaseak.Etiketa;
import Klaseak.EtiketaGuztiak;
import Klaseak.ListaPertsona;
import Klaseak.NecareaPelikulak;
import Klaseak.Pelikula;
import Klaseak.Pertsona;

public class PertsonaEreduaTest {

	Pelikula p1,p2,p3;

	Etiketa e1,e2,e3,e4,e5,e6;
	Pertsona pe1,pe2,pe3;
	Fitxategi_CSV f;
	NecareaPelikulak np;
	EtiketaGuztiak eg;
	ListaPertsona lp;
	BalorazioMatrize balorazioMatrize;
	EtiketaMatrize etiketaMatrize;
	PertsonaEredua pertsonaEredua;
	
	@Before
	public void setUp() throws Exception {
		p1= new Pelikula(1,"bajo la misma estrella",2010);
		p2= new Pelikula(2,"De todos los chicos de los que me enamore",2016);
		p3= new Pelikula(3,"Alvin y las ardillas",2015);
		e1= new Etiketa(1,"Llorar");	
		e2= new Etiketa(1,"Amor");
		e3= new Etiketa(2,"Llorar");
		e4= new Etiketa(2,"Amor");
		e5= new Etiketa(3,"Risa");
		e6= new Etiketa(3,"Llorar");
		e6.gehituBesteBat();

		
		p1.gehituEtiketa(e1);
		p1.gehituEtiketa(e2);
		p2.gehituEtiketa(e3);
		p2.gehituEtiketa(e4);
		p3.gehituEtiketa(e5);
		p3.gehituEtiketa(e6);
		
		eg=EtiketaGuztiak.getEtiketaGuztiak();
		
		
		pe1= new Pertsona(1);
		pe2= new Pertsona(2);
		pe3= new Pertsona(3);
		pe1.pelikulaGehitu(p2);
		pe1.pelikulaGehitu(p3);
		pe2.pelikulaGehitu(p1);
		pe2.pelikulaGehitu(p2);
		pe3.pelikulaGehitu(p1);
		f= new Fitxategi_CSV(); 
		np = NecareaPelikulak.getNecareaPelikulak();
		np.gehituPelikula(p1);
		np.gehituPelikula(p2);
		np.gehituPelikula(p3);
		/*
		eg.gehituEtiketa("Risa");
		eg.gehituEtiketa("Llorar");
		eg.gehituEtiketa("Amor");
		eg.grafoaraIzenaGehitu(0,"Risa");
		eg.grafoaraIzenaGehitu(1,"Llorar");
		eg.grafoaraIzenaGehitu(2,"Amor");
		eg.EtiketaErrepikatuDa("Llorar");
		eg.EtiketaErrepikatuDa("Llorar");
		eg.EtiketaErrepikatuDa("Llorar");
		eg.EtiketaErrepikatuDa("Amor");
		*/
		
		lp=ListaPertsona.getListaPertsona();
		lp.gehituPertsona(pe1);
		lp.gehituPertsona(pe2);
		lp.gehituPertsona(pe3);
		
		pe1.grafoaraBalorazioaGehitu(2, (float)3.5);
		pe1.grafoaraBalorazioaGehitu(3, (float)2.0);
		pe2.grafoaraBalorazioaGehitu(1, (float)5.0);
		pe2.grafoaraBalorazioaGehitu(2, (float)3.0);
		pe3.grafoaraBalorazioaGehitu(1, (float)4.0);
		
		
		balorazioMatrize=BalorazioMatrize.getBalorazioMatrize();
		etiketaMatrize=EtiketaMatrize.getEtiketaMatrize();
		pertsonaEredua=PertsonaEredua.getPertsonaEredua();
		
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPertsonaEredua() {
		

		System.out.println("LISTA PERTSONAK:");
		lp.inprimatu();
		
		System.out.println("ETIKETA GUZTIAK:");
		eg.inprimatuEtiketaIzenak();
		
		eg.imprimirHM();
		
		
		System.out.println("");

		System.out.println("NECAREA PELIKULAK:");
		np.inprimatuPelikulak();
		
		//la 1
		float[][] m1=balorazioMatrize.matrizeaSortu();
		//inprimatu
		 for(int i=0;i<m1.length;i++) {
             for(int j=0;j<m1[i].length;j++) {
            	 System.out.print(m1[i][j]);
            	 System.out.print("   ");
             }
             System.out.println();
		 }

  
         System.out.println();
         System.out.println();
         System.out.println();
		
         
         
         
         
        int[][] mm= etiketaMatrize.lehenengoMatrizeaSortu();
		//inprimatu
		 for(int i=0;i<mm.length;i++) {
           for(int j=0;j<mm[i].length;j++) {
          	 System.out.print(mm[i][j]);
          	 System.out.print("   ");
           }
           System.out.println();
		 }      
		 
		 System.out.println();
         System.out.println();
         System.out.println();
		
         
         
		
		//la2
		float[][] m2=etiketaMatrize.MatrizeaSortu();
		//inprimatu
		 for(int i=0;i<m2.length;i++) {
            for(int j=0;j<m2[i].length;j++) {
           	 System.out.print(m2[i][j]);
           	 System.out.print("   ");
            }
            System.out.println();
		 }
		

         System.out.println();
         System.out.println();
         System.out.println();
		
		
         
         
         
         
         
         
         
		//la 3
		HashMap<String,Float> hm=pertsonaEredua.balorazioakEman(balorazioMatrize.matrizeaSortu(), etiketaMatrize.MatrizeaSortu(), 1);
	
	
		//inprimatu HashMap
		
			for(String key : hm.keySet()) {
				System.out.println(key + ": " + hm.get(key));
			}
	}

	@Test
	public void testGetPertsonaEredua() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatrizeaSortu() {
		fail("Not yet implemented");
	}

	@Test
	public void testKosinuaKalkulatu() {
		fail("Not yet implemented");
	}

}
