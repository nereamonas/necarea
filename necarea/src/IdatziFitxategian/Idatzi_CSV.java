package IdatziFitxategian;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Idatzi_CSV implements Idatzi{
	
	public Idatzi_CSV() {
		
	}
	
	public void BalorazioBerriaIdatzi(int erabiltzaileId, int peliId, float balorazioa) throws IOException {
		String ruta = "src/Fitxategiak_CVS/movie-ratings.csv";
        File archivo = new File(ruta);
        BufferedWriter bw=new BufferedWriter(new FileWriter(archivo,true));
        if(archivo.exists()) {
            bw.write(erabiltzaileId+","+peliId+","+balorazioa);
            bw.newLine();
        } 
        bw.close();
		
	}
	
	public void pasahitzBerriaIdatzi(int erabiltzaileId, int pasahitza) throws IOException {
		String ruta = "src/Fitxategiak_CVS/movie-pasahitzak.csv";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo,true));
            bw.write(erabiltzaileId+";"+pasahitza);   //tambn hay q hacer como insertar pasahitzaz... Hay q poner como meter. miraar como crear y dnd se crea
            bw.newLine();
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(erabiltzaileId+";"+pasahitza);
            bw.newLine();
        }
        bw.close();
		
	}
	
	public void etiketaBerriaIdatzi(int peliId, String etiketaIzena) throws IOException {
		String ruta = "src/Fitxategiak_CVS/movie-tags.csv";
        File archivo = new File(ruta);
        BufferedWriter bw=new BufferedWriter(new FileWriter(archivo,true));
        if(archivo.exists()) {
            bw.write(peliId+";"+etiketaIzena);
            bw.newLine();
        } 
        bw.close();
	}
}
