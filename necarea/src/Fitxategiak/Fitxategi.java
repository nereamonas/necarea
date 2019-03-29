package Fitxategiak;
import java.io.FileNotFoundException;

public interface Fitxategi { 
	public void kargatuTitles()throws FileNotFoundException;
	public void kargatuTags()throws FileNotFoundException;
	public void kargatuRatings()throws FileNotFoundException;
}
