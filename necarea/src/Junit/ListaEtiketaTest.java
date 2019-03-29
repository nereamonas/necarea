package Junit;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Fitxategiak.Fitxategi_CSV;
import Klaseak.Etiketa;
import Klaseak.ListaEtiketa;
import Klaseak.ListaPelikula;
import Klaseak.ListaPertsona;
import Klaseak.NecareaPelikulak;
import Klaseak.Pelikula;
import Klaseak.Pertsona;

public class ListaEtiketaTest { 
	Fitxategi_CSV f;
	ListaEtiketa le;
	Etiketa e1;
	Etiketa e2;
	Etiketa e3;
	Etiketa e4;
	Pelikula p;
	Pelikula p2;
	ListaPelikula lp;
	NecareaPelikulak np;
	Pertsona pe;
	ListaPertsona lpe;
	

	@Before
	public void setUp() throws Exception {
		f= new Fitxategi_CSV();
		le=new ListaEtiketa();
		e1= new Etiketa(114,"Capitalism");
		e2= new Etiketa(2,"Comedy");
		e3= new Etiketa(1,"Funny");
		e4= new Etiketa(1,"Funny");
		lp=new ListaPelikula();
		np=NecareaPelikulak.getNecareaPelikulak();
		lpe= ListaPertsona.getListaPertsona();
	}

	@After
	public void tearDown() throws Exception {
		f=null;
		le=null;
		e1=null;
		e2=null;
		e3=null;
		e4=null;
		p=null;
		p2=null;
		lp=null;
		np=null;
		pe=null;
		lpe=null;
		
	}

	@Test
	public void testListaEtiketa() {
		assertNotNull(le);

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
	public void testInprimatuEtiketak() throws IOException {
		
		le.erreseteatu();
		le.gehituEtiketa(e1);
		le.gehituEtiketa(e2);
		le.gehituEtiketa(e3);
		assertNotNull(le);
		le.inprimatuEtiketak();
		
		//Fitxategitik inportatzen
		
		//Pelikula guztietatik(NecareaPelikulak)
		np.erreseteatu();
		f.kargatuTitles();
		//adibidez 114 pelikularen etiketak inprimatu
		p=np.pelikulaBilatuIdz(114);
		p.print(); //pelikula ondo hartu duela ikusteko
		f.kargatuTags();
		p.inprimatuEtiketak();
		
		//Pertsona baten ikusitako pelikuletatik abiatuz
		lp.erreseteatu();
		lpe.erreseteatu();
		f.kargatuTitles();
		f.kargatuRatings();
		f.kargatuTags();
		pe=lpe.bilatuPertsonaIdz(1);
		pe.idInprimatu();//pertsona ondo lortu duela ikusteko
		pe.printPelikulaBatenEtiketak(1);
		//Ez du pelikula hori ikusi(Necareatik bilatu etiketak ikusteko)
		pe.printIkusitakoPelikulak();//809 pelikula ikusi duenez etiketak inprima ditzake
		pe.printPelikulaBatenEtiketak(809);

	}

}