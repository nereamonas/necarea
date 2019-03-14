
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
        
        public void gehituEtiketa(Etiketa e) {
        	listaEtiketa.gehituEtiketa(e);
        }
        
        public int getId() {
        	return this.id;
        }
        
        public int luzeraEtiketa() {
        	return this.listaEtiketa.luzera();
        }
        
        
        //Junit-etarako
        
        public void print() {
        	System.out.println("Pelikularen id:" + this.id);
        	System.out.println("Izena:" + this.izena);
        	System.out.println("Urtea:" + this.urtea);
        	System.out.println();
        }
        
        public void etiketakErreseteatu() {
        	this.listaEtiketa.erreseteatu();
        }
        
        public void inprimatuEtiketak() {
        
        }
        
}

