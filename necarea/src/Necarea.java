public class Necarea {
	//atributuak
    private static Necarea nireNecarea=null;
    
    
    
            
//eraikitzailea
            
    private Necarea() {        
    }    
    
    public static synchronized Necarea getNecarea() {
        if (Necarea.nireNecarea==null) {
        	Necarea.nireNecarea= new  Necarea();
        }
        return Necarea.nireNecarea;
    }



}