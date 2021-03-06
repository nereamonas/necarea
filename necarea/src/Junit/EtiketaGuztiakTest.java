package Junit;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Karga.Kargatu_CSV;
import Klaseak.EtiketaGuztiak;
 
public class EtiketaGuztiakTest {  
	
	Kargatu_CSV f;
	String s1;
	String s2;
	String s3;
	EtiketaGuztiak eG;
	

	@Before
	public void setUp() throws Exception {
		f= new Kargatu_CSV();
		s1="Comedy";
		s2="Funny";
		s3="Love";
		eG=EtiketaGuztiak.getEtiketaGuztiak();
		
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		s1=null;
		s2=null;
		s3=null;
		eG=null;
		
	}

	@Test
	public void testGetEtiketaGuztiak() {
		assertNotNull(eG);
	}
	
	@Test
	public void testGehituEtiketa() {
		eG.erreseteatu();
		assertTrue(eG.luzera()==0);
		//System.out.println(eG.luzera());
		eG.gehituEtiketa(eG.luzera(),s1);
		//System.out.println(eG.luzera());
		eG.gehituEtiketa(eG.luzera(),s2);
		//System.out.println(eG.luzera());
		eG.gehituEtiketa(eG.luzera(),s3);
		//System.out.println(eG.luzera());
		assertTrue(eG.luzera()==3);
		assertFalse(eG.luzera()==2);
		eG.gehituEtiketa(eG.luzera(),s3);
		//System.out.println(eG.luzera());
		assertTrue(eG.luzera()==3);
		assertFalse(eG.luzera()==4);
		
		
	}

	@Test
	public void testBilatuEtiketaIzena() {
		eG.erreseteatu();
		eG.gehituEtiketa(eG.luzera(),s1);
		eG.gehituEtiketa(eG.luzera(),s2);
		eG.gehituEtiketa(eG.luzera(),s3);
		assertTrue(eG.bilatuEtiketaIzena("Comedy")==true);
		assertTrue(eG.bilatuEtiketaIzena("Horror")==false);
		
	}

	@Test
	public void testInprimatuEtiketaIzena() throws IOException{
		eG.erreseteatu();
		eG.gehituEtiketa(eG.luzera(),s1);
		eG.gehituEtiketa(eG.luzera(),s2);
		eG.gehituEtiketa(eG.luzera(),s3);
		assertNotNull(eG);
		eG.inprimatuEtiketaIzenak();
		
		//fitxategi handiarekin 
		eG.erreseteatu();
		f.kargatuTitles();
		f.kargatuTags();
		eG.inprimatuEtiketaIzenak();
		
	}
	@Test
	public void testLuzera() {
		eG.erreseteatu();
		assertTrue(eG.luzera()==0);
		eG.gehituEtiketa(eG.luzera(),s1);
		eG.gehituEtiketa(eG.luzera(),s2);
		assertTrue(eG.luzera()==2);
		assertFalse(eG.luzera()==3);
	}
	
	@Test
	public void testErreseteatu() {
		
		eG.erreseteatu();
		assertTrue(eG.luzera()==0);
		eG.gehituEtiketa(eG.luzera(),s1);
		eG.gehituEtiketa(eG.luzera(),s2);
		assertTrue(eG.luzera()==2);
		eG.erreseteatu();
		assertTrue(eG.luzera()==0);
	}

}