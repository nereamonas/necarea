import java.util.ArrayList;
import java.util.Iterator;

public class ListaPelikula {
	//atributuak
	private ArrayList<Pelikula> listaPelikula;
	private static ListaPelikula nireListaPelikula=null;
	
	
			
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
		boolean aurkitua=false;
		
		while (itr.hasNext()&& !aurkitua) {
			pBat=itr.next();
			if (pId==pBat.getId()) {
				aurkitua=true;
			}
		}
		return pBat;
	}
	

	public int luzera() {
		return this.listaPelikula.size();
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
		
}
