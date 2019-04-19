package Junit;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Karga.Kargatu_CSV;
import Klaseak.NecareaPelikulak;
import Klaseak.Pelikula;
 
public class NecareaPelikulakTest {


	Kargatu_CSV f;
	NecareaPelikulak np;
	Pelikula p1;
	Pelikula p2;
	Pelikula p3;
	
	@Before
	public void setUp() throws Exception {
		f= new Kargatu_CSV(); 
		np=NecareaPelikulak.getNecareaPelikulak();
		p1= new Pelikula(1,"bajo la misma estrella",2010);
		p2= new Pelikula(2,"De todos los chicos de los que me enamore",2016);
		p3= new Pelikula(3,"Alvin y las ardillas",2014);
	
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		np=null;
		p1=null;
		p2=null;
		p3=null;
	}

	@Test
	public void testGetNecareaPelikulak() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
	}

	@Test
	public void testGehituPelikula() {

		np.erreseteatu();
		assertTrue(np.luzera()==0);
		np.gehituPelikula(p1);
		np.gehituPelikula(p2);
		np.gehituPelikula(p3);
		assertTrue(np.luzera()==3);
		assertFalse(np.luzera()==2);
	}
	
	@Test
	public void testLuzera() {
		np.erreseteatu();
		assertTrue(np.luzera()==0);
		np.gehituPelikula(p1);
		np.gehituPelikula(p2);
		assertTrue(np.luzera()==2);
		assertFalse(np.luzera()==3);
	}

	@Test
	public void testPelikulaBilatuIdz() {
		np.erreseteatu();
		np.gehituPelikula(p1);
		np.gehituPelikula(p2);
		np.gehituPelikula(p3);
		assertTrue(np.pelikulaBilatuIdz(3).equals(p3));
		assertFalse(np.pelikulaBilatuIdz(2).equals(p3));
	
	}

	@Test
	public void testInprimatuPelikulak() throws IOException {
		//Eskuz
			np.erreseteatu();
			np.gehituPelikula(p1);
			np.gehituPelikula(p2);
			np.gehituPelikula(p3);
			assertNotNull(np);
			np.inprimatuPelikulak();
			
		//Fitxategitik inportatzen
			np.erreseteatu();
			f.kargatuTitles();
			np.inprimatuPelikulak();
	}
	
	@Test
	public void testErreseteatu() {
		
		np.erreseteatu();
		assertTrue(np.luzera()==0);
		np.gehituPelikula(p1);
		np.gehituPelikula(p2);
		assertTrue(np.luzera()==2);
		np.erreseteatu();
		assertTrue(np.luzera()==0);
	}

}
