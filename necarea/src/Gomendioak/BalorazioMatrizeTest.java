package Gomendioak;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;

public class BalorazioMatrizeTest {
	
	BalorazioMatrize bm;
	Fitxategi_CSV f;

	@Before
	public void setUp() throws Exception {
		bm= BalorazioMatrize.getBalorazioMatrize();
		f=new Fitxategi_CSV();
	}

	@After
	public void tearDown() throws Exception {
		bm=null;
		f=null;
	}

	@Test
	public void testBalorazioMatrize() {
		assertNotNull(bm);
	}
	
	@Test
	public void testMatrizeaSortu() throws FileNotFoundException {
		f.kargatuTitles();
		f.kargatuRatings();
		
		bm.matrizeaSortu();
		//Van bien
		System.out.println(bm.posiziokoBalorazioa(240, 77) + " -> 5.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 146) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 462) + " -> 1.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 275) + " -> 2.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 329) + " -> 5.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 607) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 1891) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 788) + " -> 2.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 603) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 85) + " -> 5.0 izan behar du.");
		//Van bien
	}
	
	@Test
	public void testPosiziokoBalorazioa() throws FileNotFoundException {
		f.kargatuTitles();
		f.kargatuRatings();
		
		bm.matrizeaSortu();
		//Van bien
		System.out.println(bm.posiziokoBalorazioa(240, 77) + " -> 5.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 146) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 462) + " -> 1.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 275) + " -> 2.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 329) + " -> 5.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 607) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 1891) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 788) + " -> 2.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 603) + " -> 4.0 izan behar du.");
		System.out.println(bm.posiziokoBalorazioa(240, 85) + " -> 5.0 izan behar du.");
		//Van bien
		//No cuadran porque hay id de usuarios que no hay
	}

}