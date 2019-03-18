import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPertsonaTest {
	ListaPertsona lp;
	Pertsona p1,p2,p3;

	@Before
	public void setUp() throws Exception {
		lp=ListaPertsona.getListaPertsona();
		p1=new Pertsona(1111);
		p2=new Pertsona(2222);
		p3=new Pertsona(3333);
	}

	@After
	public void tearDown() throws Exception {
		lp=null;
		p1=null;
		p2=null;
		p3=null;
	}

	@Test
	public void testGetListaPertsona() {
		assertNotNull(lp);
	}

	@Test
	public void testBilatuPertsonaIdz() {
		lp.erreseteatu();
		lp.gehituPertsona(p1);
		lp.gehituPertsona(p2);
		lp.gehituPertsona(p3);
		assertNotNull(lp.bilatuPertsonaIdz(1111));
		assertNotNull(lp.bilatuPertsonaIdz(2222));
		assertNotNull(lp.bilatuPertsonaIdz(3333));
		assertNull(lp.bilatuPertsonaIdz(4444));
	}
	
	@Test
	public void testInprimatu() {
		System.out.println("Inprimatu test-a:");
		lp.erreseteatu();
		lp.gehituPertsona(p1);
		lp.gehituPertsona(p2);
		lp.gehituPertsona(p3);
		lp.inprimatu();
	}
	
	@Test
	public void testErreseteatu() {
		lp.gehituPertsona(p1);
		lp.gehituPertsona(p2);
		lp.gehituPertsona(p3);
		System.out.println("Hiru pertsona daude:");
		lp.inprimatu();
		System.out.println("Hutsik dago:");
		lp.erreseteatu();
		lp.inprimatu();
	}
	