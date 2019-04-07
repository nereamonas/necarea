package Klaseak;
import java.util.ArrayList;
 
public class Pelikula {
		private int id;      
        private String izena;
        private int urtea;
        private ListaEtiketa listaEtiketa;
            
        public Pelikula(int pId,String pIz,int pUrtea) {
            this.id=pId;
        	this.izena=pIz;
            this.urtea=pUrtea;
            listaEtiketa= new ListaEtiketa();
        }
        
        public void gehituEtiketa(Etiketa e) { //pelikularen listaEtiketari etiketarenbat gehitu nahi izanez gero, metodo honen bitartez gehitzeko aukera dugu
        	Etiketa etik=listaEtiketa.etiketaDago(e.getIzena());
        	EtiketaGuztiak eg=EtiketaGuztiak.getEtiketaGuztiak();
        	if(etik==null) {
        		this.listaEtiketa.gehituEtiketa(e);
        		eg.kantitateaGehitu(e.getIzena());
        	}else {
        		listaEtiketa.gehituBesteBatEtiketari(e.getIzena());
        	}
        	
        }
        
        public boolean idBerdinaDu(int pId) { //bere id-a, sartzen den id-arekin konparatzen du, berdinak badira True bueltatuz eta bestela False. Metodo honekin bermatzen dugu, pelikularen informazioa ez pasatzea
        	return this.id==pId;
        }
        
        public int luzeraEtiketa() { //Lista Etiketaren luzera zein den esango digu
        	return this.listaEtiketa.luzera();
        }
        

        public ListaEtiketa listaEtiketaItzuli() {
        	return this.listaEtiketa;
        }
        
        public String getIzena() {
        	return this.izena;
        }
        
        public boolean izenBeraDute(String p) {
        	return this.izena.equals(p);
        }
        
        
        //Junit-etarako
        
        public void print() { //Junit-etan erabiliko da, ikusteko pelikularen atributu guztiak ondo sartu direla
        	System.out.println("Pelikularen id:" + this.id);
        	System.out.println("Izena:" + this.izena);
        	System.out.println("Urtea:" + this.urtea);
        	System.out.println();
        }
        
        public void etiketakErreseteatu() { //Junit-etan erabiliko dugu
        	this.listaEtiketa.erreseteatu();
        }
        
        public void inprimatuEtiketak() { //Junit-etan, pelikula batek dituen etiketak ondo kargatu direla ikusteko
           this.listaEtiketa.inprimatuEtiketak();
        }
        
        public int getId() { //Junit-etarako bakarrik erabilkiko dugu
        	return this.id;
        }
        
        //Botoiak egiteko erabiliko den metodoa
        public String datuakHartu() {
        	return ("Izena:"+this.izena+", Urtea:"+this.urtea);

        }
        
        public String posiziokoEtiketaIzena(int i) {
        	return this.listaEtiketa.posiziokoEtiketaIzena(i);
        }


}

