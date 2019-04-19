package Gomendioak;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Karga.Kargatu_CSV;
 
public class EtiketaMatrizeTest {

	Kargatu_CSV f;
	EtiketaMatrize em;
	
	@Before
	public void setUp() throws Exception {
		f= new Kargatu_CSV();
		em=EtiketaMatrize.getEtiketaMatrize();
	}

	@After
	public void tearDown() throws Exception {
		em=null;
	}

	@Test
	public void testEtiketaMatrize() throws FileNotFoundException {
		f.kargatuTitles();
		f.kargatuTags();
		f.kargatuRatings();
		
		em.MatrizeaSortu();
		em.matrizeaInprimatu();
	}

}