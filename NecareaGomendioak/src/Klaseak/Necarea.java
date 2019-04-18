package Klaseak;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Fitxategiak.Fitxategi;
import Fitxategiak.Fitxategi_CSV;
import Gomendioak.PertsonaEredua;

public class Necarea{
    //atributuak
    private static Necarea nireNecarea=null;
    
    private NecareaPelikulak pelikulak;
    private ListaPertsona pertsonak;
    private Fitxategi fitxategiak;
    private EtiketaGuztiak etiketak;
    

    
    
            
//eraikitzailea
            
    private Necarea() { 
        this.fitxategiak=new Fitxategi_CSV();
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
        this.fitxategiak.kargatuTitles();
        this.fitxategiak.kargatuTags();
        this.fitxategiak.kargatuRatings();
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
    
    public boolean pelikulaIkusiDu(int erabiltzaileId,String peli) {
        return this.pertsonak.bilatuPertsonaIdz(erabiltzaileId).bilatuPelikula(peli);
    }
    
    public String pelikularenDatuakHartu(String peli) {
        return this.pelikulak.bilatuPelikulaIzenaz(peli).datuakHartu2();
    }
    
    
    public float pelikulariEmandakoBalorazioa(int perts, String peli) {
        Pertsona pertsona=this.pertsonak.bilatuPertsonaIdz(perts);
        int peliPos=this.pelikulak.bilatuPelikularenPosizioa(peli);
        return (pertsona.posiziokoPelikularenBalorazioa(peliPos));
    }
    
    public float pelikulaBaloratu(int perts,String peli) {
        PertsonaEredua pe=PertsonaEredua.getPertsonaEredua();
        return (pe.baloratuPelikula(peli, perts));
    }
    
    
   public Vector gehienGustatukoZaizkionPelikulak(int erabiltzaileId) throws IOException {
       PertsonaEredua pe=PertsonaEredua.getPertsonaEredua();
       return pe.bektore10(pe.balorazioakEman(erabiltzaileId));
   }
    
    
}
