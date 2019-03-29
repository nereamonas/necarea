package Junit;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;
import Klaseak.ListaPelikula;
import Klaseak.Pelikula;
 
public class ListaPelikulaTest { 
	
	Fitxategi_CSV f;
	ListaPelikula lp;
	Pelikula p1;
	Pelikula p2;
	Pelikula p3; 
	
	@Before
	public void setUp() throws Exception {
		f= new Fitxategi_CSV();
		lp=new ListaPelikula();
		p1= new Pelikula(1,"bajo la misma estrella",2010);
		p2= new Pelikula(2,"De todos los chicos de los que me enamore",2016);
		p3= new Pelikula(3,"Alvin y las ardillas",2014);
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		lp=null;
		p1=null;
		p2=null;
		p3=null;
	}

	@Test
	public void testListaPelikula() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
	}

	@Test
	public void testGehituPelikula() {
		
		lp.erreseteatu();
		assertTrue(lp.luzera()==0);
		lp.gehituPelikula(p1);
		lp.gehituPelikula(p2);
		lp.gehituPelikula(p3);
		assertTrue(lp.luzera()==3);
		assertFalse(lp.luzera()==2);
	}

	@Test
	public void testPelikulaBilatuIdz() {
		lp.erreseteatu();
		lp.gehituPelikula(p1);
		lp.gehituPelikula(p2);
		lp.gehituPelikula(p3);
		assertTrue(lp.pelikulaBilatuIdz(3).equals(p3));
		assertFalse(lp.pelikulaBilatuIdz(2).equals(p3));
	}

	@Test
	public void testLuzera() {
		lp.erreseteatu();
		assertTrue(lp.luzera()==0);
		lp.gehituPelikula(p1);
		lp.gehituPelikula(p2);
		assertTrue(lp.luzera()==2);
		assertFalse(lp.luzera()==3);
	}
	
	@Test
	public void testInprimatuPelikulak() {
			lp.erreseteatu();
			lp.gehituPelikula(p1);
			lp.gehituPelikula(p2);
			lp.gehituPelikula(p3);
			assertNotNull(lp);
			lp.inprimatuPelikulak();
			
	}
	@Test
	public void testErreseteatu() {
		
		lp.erreseteatu();
		assertTrue(lp.luzera()==0);
		lp.gehituPelikula(p1);
		lp.gehituPelikula(p2);
		assertTrue(lp.luzera()==2);
		lp.erreseteatu();
		assertTrue(lp.luzera()==0);
	}

}
