package IdatziFitxategian;

import java.io.IOException;

public interface Idatzi {
	public void BalorazioBerriaIdatzi(int erabiltzaileId, int peliId, float balorazioa) throws IOException;
	public void pasahitzBerriaIdatzi(int erabiltzaileId, int pasahitza) throws IOException;
	public void etiketaBerriaIdatzi(int peliId, String etiketaIzena) throws IOException;
}
