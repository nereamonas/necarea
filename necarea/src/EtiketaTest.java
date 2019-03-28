import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EtiketaTest { 
	
	Etiketa e1;
	Etiketa e2;
	Etiketa e3;
	Fitxategi_CSV f;

	@Before
	public void setUp() throws Exception {
		e1= new Etiketa(114,"Capitalism");
		e3= new Etiketa(2,"Comedy");
		e2= new Etiketa(1,"Funny");
		f= new Fitxategi_CSV();
	}
	
	@After
	public void tearDown() throws Exception {
		f=null;
		e1=null;
		e2=null;
		e3=null;
	}

	@Test
	public void testEtiketa() {
		assertNotNull(e1);
		assertNotNull(e2);
		assertNotNull(e3);
	}

	@Test
	public void testGehituBesteBat() {
		assertTrue(e1.getAldiak()==1);
		e1.gehituBesteBat();
		assertTrue(e1.getAldiak()==2);
		assertFalse(e1.getAldiak()==1);
		
		e2.gehituBesteBat();
		e2.gehituBesteBat();
		assertTrue(e2.getAldiak()==3);
		assertFalse(e2.getAldiak()==2);
		
	}
	
	@Test
	public void testPrint() throws IOException {
		assertNotNull(e1);
		e1.print();
	}
	@Test
	public void testGetAldiak() {
		assertTrue(e1.getAldiak()==1);
	}
	@Test
	public void testGetIzena() {
		assertTrue(e1.getIzena().equals("Capitalism"));
	}

	

}
