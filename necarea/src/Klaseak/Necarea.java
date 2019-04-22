package Klaseak;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Karga.Kargatu;
import Karga.Kargatu_CSV;
import Gomendioak.PertsonaEredua;

public class Necarea{
	//atributuak
    private static Necarea nireNecarea=null;
    
    private NecareaPelikulak pelikulak;
    private ListaPertsona pertsonak;
    private Kargatu kargatu;
    private EtiketaGuztiak etiketak;
    

    
    
            
//eraikitzailea
            
    private Necarea() { 
    	this.kargatu=new Kargatu_CSV();
    	this.pelikulak=NecareaPelikulak.getNecareaPelikulak();
    	this.pertsonak=ListaPertsona.getListaPertsona();
    	this.etiketak=EtiketaGuztiak.getEtiketaGuztiak();
    }    
    
    public static synchronized Necarea getNecarea() {
        if (Necarea.nireNecarea==null) {
        	Necarea.nireNecarea= new  Necarea();
        }
        return Necarea.nireNecarea;
    }
    
    public void fitxategiGuztiakKargatu() throws FileNotFoundException {
    	this.kargatu.guztiaKargatu();
    }
    
    public boolean pertsonaBilatu(int id) {
    	boolean dago=false;
    	if(this.pertsonak.bilatuPertsonaIdz(id)!=null) {
    		dago=true;
    	}
    	return dago;
    }
    
    public boolean pasahitzaKonprobatu(int erabiltzailea, int pasahitza) {
    	boolean ondo=false;
    	if(this.pertsonak.bilatuPertsonaIdz(erabiltzailea).pasahitzaKonprobatu(pasahitza)) {
    		ondo=true;
    	}
    	
    	return ondo;
    }
    
    public void erabiltzaileaGehitu(int id) {
    	Pertsona pBerria= new Pertsona(id);
    	this.pertsonak.gehituPertsona(pBerria);
    }
    
    
    public Vector bektorePelikulak() throws IOException {
    	return this.pelikulak.bektorePelikulak();
    }
    
    
    public Vector ikusitakoPelikulak(int erabiltzaile) throws IOException {
    	return this.pertsonak.bilatuPertsonaIdz(erabiltzaile).bektoreIkusitakoPelikulak();
    }
    
    public Vector ikusiEzDituenPelikulak(int erabiltzaile) {
    	return this.pertsonak.bilatuPertsonaIdz(erabiltzaile).bektoreIkusiEzDituenPelikulak();
    }
    
    public boolean pelikulaIkusiDu(int erabiltzaileId,String peli) {
    	return this.pertsonak.bilatuPertsonaIdz(erabiltzaileId).bilatuPelikula(peli);
    }
    
    public String pelikularenDatuakHartu(String peli) {
    	return this.pelikulak.bilatuPelikulaIzenaz(peli).datuakHartu2();
    }
    
    
    public float pelikulariEmandakoBalorazioa(int perts, String peli) {
    	Pertsona pertsona=this.pertsonak.bilatuPertsonaIdz(perts);
    	int peliPos=this.pelikulak.bilatuPelikularenPosizioa(peli);
    	int peliId =this.pelikulak.bilatuPelikulaIzenaz(peli).getId();
    	return (pertsona.idHorrenPelikularenBalorazioa(peliId));
    }
    
    public float pelikulaBaloratu(int perts,String peli) {
    	PertsonaEredua pe=PertsonaEredua.getPertsonaEredua();
    	return (pe.baloratuPelikula(peli, perts));
    }
    
    
   public Vector gehienGustatukoZaizkionPelikulak(int erabiltzaileId) throws IOException {
	   PertsonaEredua pe=PertsonaEredua.getPertsonaEredua();
	   return pe.bektore10(pe.balorazioakEman(erabiltzaileId));
   }
   
   public void pasahitzaAldatu(int erabiltzaile, int p) {
	   this.pertsonak.bilatuPertsonaIdz(erabiltzaile).pasahitzaAldatu(p);
   }
   
   public int pelikularenUrtea(String peli) {
	  return this.pelikulak.bilatuPelikulaIzenaz(peli).getUrtea();
   }
   
   public int pelikularenId(String peli) {
	   return this.pelikulak.bilatuPelikulaIzenaz(peli).getId();
   }
   
   public Vector PelikularenListaEtiketa(String peli) throws IOException {
	   return this.pelikulak.bilatuPelikulaIzenaz(peli).BektoreListaEtiketa();
   }
   
   public void pelikulaGehitu(String peliIzen, int pertsona) {
	   Pelikula p=this.pelikulak.bilatuPelikulaIzenaz(peliIzen);
	   this.pertsonak.bilatuPertsonaIdz(pertsona).pelikulaGehitu(p);
   }
   
   public void balorazioaGehitu(int pertsona,String peliIzen,float n) {
	  
	    Pertsona p=this.pertsonak.bilatuPertsonaIdz(pertsona);
   		int peliPos=this.pelikulak.bilatuPelikularenPosizioa(peliIzen);
   		p.grafoaraBalorazioaGehitu(peliPos, n);
   }

    
}