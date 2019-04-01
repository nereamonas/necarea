package Klaseak;
import java.util.ArrayList;
import java.util.Iterator;
 
public class ListaPelikula {
	//atributuak
	private ArrayList<Pelikula> listaPelikula;
	
	
			
	//eraikitzailea     
			
	public ListaPelikula() {
		this.listaPelikula=new ArrayList<Pelikula>();		
	}
	
	public void gehituPelikula(Pelikula p) {
		listaPelikula.add(p);
	}
	
	private Iterator<Pelikula> getIteradorea() {
		return this.listaPelikula.iterator();
	}
	
	public Pelikula pelikulaBilatuIdz(int pId) {
		Iterator <Pelikula> itr=this.getIteradorea();
		Pelikula pBat=null;
		Pelikula p=null;
		boolean aurkitua=false;
		
		while (itr.hasNext()&& !aurkitua) {
			pBat=itr.next();
			if (pBat.idBerdinaDu(pId)) { 
				aurkitua=true;
			}
		}
		if(aurkitua) {
		p=pBat;
		}
	return p;
	}
	
	public int luzera() {
		return this.listaPelikula.size();
	}
	
	
	public int posiziokoPelikulakoIda(int p) {
		return this.listaPelikula.get(p).getId();
	}
	
	public String posiziokoPelikularenIzena(int i) {
		return this.listaPelikula.get(i).getIzena();
	}
	

	public ListaEtiketa posiziokoPelikularenListaEtiketa(int i) {
		return this.listaPelikula.get(i).listaEtiketaItzuli();
	}
	
	public int bilatuPelikularenPosizioa(String p) {
		Iterator <Pelikula> itr=this.getIteradorea();
		Pelikula pBat=null;
		int kont=0;
		boolean aurkitua=false;
		int emaitza=-1;
			
		while (itr.hasNext() &&!aurkitua ) {
			pBat=itr.next();
			if(pBat.izenBeraDute(p)) {
				aurkitua=true;
			}else {
			kont++;
			}
		}
		if (aurkitua) {
			emaitza=kont;
		}
		
		return emaitza;
	}
	

	//Junit-etarako behar diren metodoak
		public void inprimatuPelikulak() { //jUnit-etan hitz guztiak ondo gehitu direla ikusteko
			Iterator <Pelikula> itr=this.getIteradorea();
			Pelikula pBat=null;
				
			while (itr.hasNext()  ) {
				pBat=itr.next();
				pBat.print();
			}
		}
		
		public void erreseteatu(){
			while (this.listaPelikula.size()!=0) {
   				this.listaPelikula.remove(this.listaPelikula.size()-1);
   			}
		}
		
		
		//Botoiak egiteko erabiliko da
		public String datuakHartu(int p) {
			return this.listaPelikula.get(p).datuakHartu();
		}
	
}