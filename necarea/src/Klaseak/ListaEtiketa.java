package Klaseak;
import java.util.ArrayList;
import java.util.Iterator;
 
public class ListaEtiketa {

	//atributuak
	private ArrayList<Etiketa> listaEtiketa;
	  
	
			
	//eraikitzailea
		    	
	public ListaEtiketa() {
		this.listaEtiketa=new ArrayList<Etiketa>();		
	}
	
	public void gehituEtiketa(Etiketa e) {
		
		EtiketaGuztiak eG=EtiketaGuztiak.getEtiketaGuztiak();
		
		//miramos la pequeña
		Iterator <Etiketa> itr=this.getIteradorea();
		Etiketa eBat=null;
		boolean aurkitua=false;
		while (itr.hasNext()&&!aurkitua) {
			eBat=itr.next();
			if (e.getIzena().equals(eBat.getIzena())) {
				e.gehituBesteBat();
				aurkitua=true;
			}
		}
		if (!aurkitua) {
			this.listaEtiketa.add(e);
		}
		eG.gehituEtiketa(eG.luzera(), e.getIzena());
		
	}
	
	private Iterator<Etiketa> getIteradorea() {
		return this.listaEtiketa.iterator();
	}
	
	public int luzera() {
		return this.listaEtiketa.size();
	}
	
	//Junit-etarako

	public void erreseteatu(){
		while (this.listaEtiketa.size()!=0) {
				this.listaEtiketa.remove(this.listaEtiketa.size()-1);
			}
	}
	
	public void inprimatuEtiketak() { 
		Iterator <Etiketa> itr=this.getIteradorea();
		Etiketa eBat=null;
			
		while (itr.hasNext()  ) {
			eBat=itr.next();
			eBat.print();
		}

	}

	public Etiketa posiziokoEtiketa(int i) {
		return this.listaEtiketa.get(i);
	}
	
	public String posiziokoEtiketaIzena(int i) {
    	return this.listaEtiketa.get(i).getIzena();
    }
	
	}
