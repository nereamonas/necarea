package Fitxategiak;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Klaseak.EtiketaGuztiak;
import Klaseak.ListaPertsona;
import Klaseak.NecareaPelikulak;

public class Fitxategi_CSVTest {
 

	Fitxategi_CSV f;
	NecareaPelikulak np;
	EtiketaGuztiak ez;
	ListaPertsona lp;
	
	@Before
	public void setUp() throws Exception {
		f= new Fitxategi_CSV();
		np=NecareaPelikulak.getNecareaPelikulak();
		ez=EtiketaGuztiak.getEtiketaGuztiak();
		lp=ListaPertsona.getListaPertsona();
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		np=null;
		ez=null;
		lp=null;
	} 

	@Test
	public void testFitxategiak() {
		assertNotNull(f);
	}

	

	@Test
	public void testKargatuTitles() throws IOException {
		assertNotNull(f);
		f.kargatuTitles();
		//ikusteko ondo kargatu dela, pelikulak imprimatuko ditugu
			np.inprimatuPelikulak();
	}
	
	@Test 
	public void testKargatuTags() throws IOException {
		assertNotNull(f);
		f.kargatuTags();
		//ikusteko ondo kargatu dela, etiketak imprimatuko ditugu
			//ez.inprimatuEtiketak();
		
		//Metodo hau, etiketak sartzeaz aparte, pelikula bakoitzari bere etiketak sartzen dizkio. Beraz pelikula bat hartuko dugu ikusteko bere etiketak ondo sartu direla
			//Pelikula p= np.PelikulaBilatuIdz(112)
			//p.inprimatuEtiketak();
		
	}
	
	@Test
	public void testKargatuRatings() throws IOException {
		assertNotNull(f);
		f.kargatuRatings();
		//ikusteko ondo kargatu dela, pertsona guztiak imprimatuko ditugu
			//lp.inprimatuPertsonak();
		//Ondoren pertsona bakoitzaren HashMapa ondo burutu dela ikusteko, pertsona batzuen HashMap-a inprimatuko dugu
			//Pertsona p=bilatuPertsonaIdz(1);
			//p.inprimatuHashMap();
		//Eta pertsonaren pelikula lista era inprimatu
			//p.inprimatuPelikulaZerrenda();
	}

}