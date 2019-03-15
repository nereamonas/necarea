import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaEtiketaTest {
	Fitxategiak f;
	ListaEtiketa le;
	Etiketa e1;
	Etiketa e2;
	Etiketa e3;
	Etiketa e4;

	@Before
	public void setUp() throws Exception {
		f= Fitxategiak.getFitxategia();
		le=new ListaEtiketa();
		e1= new Etiketa(114,"Capitalism");
		e2= new Etiketa(2,"Comedy");
		e3= new Etiketa(1,"Funny");
		e4= new Etiketa(1,"Funny");
		
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		le=null;
		e1=null;
		e2=null;
		e3=null;
		e4=null;
	}

	@Test
	public void testListaEtiketa() {
		assertNotNull(e1);
		assertNotNull(e2);
		assertNotNull(e3);
		assertNotNull(e4);
	}

	@Test
	public void testGehituEtiketa() {
		le.erreseteatu();
		assertTrue(le.luzera()==0);
		le.gehituEtiketa(e1);
		le.gehituEtiketa(e2);
		le.gehituEtiketa(e3);
		assertTrue(le.luzera()==3);
		assertFalse(le.luzera()==2);
		le.gehituEtiketa(e4);
		assertTrue(le.luzera()==3);
		assertFalse(le.luzera()==4);
		//errepikatuta badago etiketa +1 egiten duela ikusteko
		assertTrue(e4.getAldiak()==2);
		assertFalse(e4.getAldiak()==3);
			
	}

	@Test
	public void testLuzera() {
		le.erreseteatu();
		assertTrue(le.luzera()==0);
		le.gehituEtiketa(e1);
		le.gehituEtiketa(e3);
		assertTrue(le.luzera()==2);
		assertFalse(le.luzera()==3);
	}

	@Test
	public void testErreseteatu() {
		le.erreseteatu();
		assertTrue(le.luzera()==0);
		le.gehituEtiketa(e1);
		le.gehituEtiketa(e2);
		assertTrue(le.luzera()==2);
		le.erreseteatu();
		assertTrue(le.luzera()==0);
	}
	
	@Test
	public void testInprimatuEtiketak() {
		
		le.erreseteatu();
		le.gehituEtiketa(e1);
		le.gehituEtiketa(e2);
		le.gehituEtiketa(e3);
		assertNotNull(le);
		le.inprimatuEtiketak();
	}

}