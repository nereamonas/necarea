package Player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

import java.io.File;

public class Reproductor {

	//atributu
	private BasicPlayer player;
	
	//eraikitzaile
	public Reproductor(){
		player = new BasicPlayer();

	}
	
	//metodoak
	public void Play() throws Exception {
		player.play();
	}
	public void AbrirFichero(String ruta) throws Exception {
		player.open(new File(ruta));
	}
	public void Pausa() throws Exception {
		player.pause();
	}
	public void Continuar() throws Exception {
		player.resume();
	}
	public void Stop() throws Exception {
		player.stop();
	}

	
	
	public static void main(String args[]){
		try {
			Reproductor mi_reproductor = new Reproductor();
			mi_reproductor.AbrirFichero("C:\\Users\\nerea\\Desktop\\a.mp3");
			mi_reproductor.Play();
		} catch (Exception ex) {
			System.out.println("Error");
		}
	}

	}
