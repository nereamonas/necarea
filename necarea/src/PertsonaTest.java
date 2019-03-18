import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PertsonaTest {
	NecareaPelikulak np;
	Fitxategiak f;
	Pertsona per;
	Pelikula p1,p2;
	ListaPertsona lp;

	@Before
	public void setUp() throws Exception {
		p1= new Pelikula(1,"bajo la misma estrella",2010);
		p2= new Pelikula(2,"De todos los chicos de los que me enamore",2016);
		per= new Pertsona(1234);
		f= Fitxategiak.getFitxategia();
		np = NecareaPelikulak.getNecareaPelikulak();
		lp= ListaPertsona.getListaPertsona();
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		f=null;
		np=null;
		lp=null;
	}

	@Test
	public void testPertsona() {
		assertNotNull(per);
	}

	@Test
	public void testGrafoaraBalorazioaGehitu() {
		per.grafoaraBalorazioaGehitu(p1.getId(), (float) 4.0);
		per.grafoaraBalorazioaGehitu(p2.getId(), (float) 4.5);
		per.balorazioakInprimatu();
	}

	@Test
	public void testPelikulaGehitu() {
		per.pelikulaGehitu(p1);
		per.pelikulaGehitu(p2);
		assertTrue(per.zenbatPelikulaIkusi()==2);
		assertFalse(per.zenbatPelikulaIkusi()==3);
	}
	
	@Test
	public void zenbatPelikulaIkusi() {
		assertTrue(per.zenbatPelikulaIkusi()==0);
		per.pelikulaGehitu(p1);
		per.pelikulaGehitu(p2);
		assertTrue(per.zenbatPelikulaIkusi()==2);
		assertFalse(per.zenbatPelikulaIkusi()==3);
	}
	
	@Test
	public void ikusitakoakErreseteatu() {
		per.pelikulaGehitu(p1);
		per.pelikulaGehitu(p2);
		per.ikusitakoakErreseteatu();
		assertTrue(per.zenbatPelikulaIkusi()==0);
	}
	
	@Test
	public void balorazioakInprimatu() {
		lp.erreseteatu();
		np.erreseteatu();
		try {
			f.kargatuTitles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			f.kargatuRatings();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//lp.inprimatu();
		lp.bilatuPertsonaIdz(1).balorazioakInprimatu();
		
	}

}