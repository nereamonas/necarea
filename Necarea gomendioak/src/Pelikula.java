
public class Pelikula {
		private int id;      
        private String izena;
        private String urtea;
        private ListaEtiketa listaEtiketa;
            
        public Pelikula(int pId,String pIz,String pUrtea) {
            this.id=pId;
        	this.izena=pIz;
            this.urtea=pUrtea;
            listaEtiketa= new ListaEtiketa();
        }
        
        public void EtiketaGehitu(Etiketa e) {
        	listaEtiketa.gehituEtiketa(e);
        }
}

 