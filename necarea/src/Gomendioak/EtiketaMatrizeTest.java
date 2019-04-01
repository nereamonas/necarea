package Gomendioak;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;
 
public class EtiketaMatrizeTest {

	Fitxategi_CSV f;
	EtiketaMatrize em;
	
	@Before
	public void setUp() throws Exception {
		f= new Fitxategi_CSV();
		em=EtiketaMatrize.getEtiketaMatrize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEtiketaMatrize() throws FileNotFoundException {
		f.kargatuTitles();
		f.kargatuTags();
		f.kargatuRatings();
		
		em.MatrizeaSortu();
	}

}
