package Junit;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;
import Klaseak.Etiketa;
import Klaseak.NecareaPelikulak;
import Klaseak.Pelikula;
 
public class PelikulaTest {

	Pelikula p1;
	Pelikula p2;
	Etiketa e1;
	Etiketa e2;
	Etiketa e3;
	Fitxategi_CSV f;
	NecareaPelikulak np;
	
	@Before
	public void setUp() throws Exception {
		p1= new Pelikula(1,"bajo la misma estrella",2010);
		p2= new Pelikula(2,"De todos los chicos de los que me enamore",2016);
		e1= new Etiketa(1,"Llorar");
		e3= new Etiketa(2,"Llorar");
		e2= new Etiketa(1,"Amor");
		f= new Fitxategi_CSV(); 
		np = NecareaPelikulak.getNecareaPelikulak();
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		e1=null;
		e2=null;
		e3=null;
		f=null;
		np=null;
	}

	@Test
	public void testPelikula() {
		assertNotNull(p1);
	}

	@Test
	public void testGehituEtiketa() {
		p1.etiketakErreseteatu();
		assertTrue(p1.luzeraEtiketa()==0);
		p1.gehituEtiketa(e1);
		p1.gehituEtiketa(e2);
		assertTrue(p1.luzeraEtiketa()==2);
		assertFalse(p1.luzeraEtiketa()==3);
	}

	@Test
	public void testIdBerdinaDu() {
		assertTrue(p1.idBerdinaDu(1));
		assertTrue(p2.idBerdinaDu(2));
		assertFalse(p2.idBerdinaDu(1)); 
	}

	
	public void testLuzeraEtiketa() {
		p1.etiketakErreseteatu();
		assertTrue(p1.luzeraEtiketa()==0);
		p1.gehituEtiketa(e1);
		p1.gehituEtiketa(e2);
		assertTrue(p1.luzeraEtiketa()==2);
		assertFalse(p1.luzeraEtiketa()==3);
	}
	
	@Test
	public void testPrint() {
		assertNotNull(p1);
		p1.print();
	}
	
	
	
	
	@Test
	public void testInprimatuEtiketak() throws IOException {
		//Manualki
			p1.etiketakErreseteatu();
			assertTrue(p1.luzeraEtiketa()==0);
			p1.gehituEtiketa(e1);
			p1.gehituEtiketa(e2);
			p1.inprimatuEtiketak();
			
		//fitxategietatik inportatzen.
			f.kargatuTitles();
			f.kargatuTags();
			//ikusteko ondo kargatu dela, etiketak imprimatuko ditugu
			
			//Metodo hau, etiketak sartzeaz aparte, pelikula bakoitzari bere etiketak sartzen dizkio. Beraz pelikula bat hartuko dugu ikusteko bere etiketak ondo sartu direla
			Pelikula p= np.pelikulaBilatuIdz(120);
			p.inprimatuEtiketak();
	}
	
	@Test
	public void testDatuakHartu() throws IOException {
		
		p1.datuakHartu();
		assertNotNull(p1);
	}
}
