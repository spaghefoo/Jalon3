package MarieTeam;

/**
* Classe Parametres. Elle contients les constantes utiles :
* <ul>
* <li>Acc�s base de donn�es
* <li>Acc�s aux fichiers
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class Parametres {
    public static final String DB_URL = "jdbc:mysql://localhost/marieteam?serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	//public static final String DB_PARAMS = "user="+DB_USER+"&password="+DB_PASSWORD;
    /**
	 * DOSSIER : Chemin o� est g�n�r� le fichier
	 */
	public static String DOSSIER_PDF = "C:\\Users\\cours\\Downloads\\pdf\\";
	public static String FICHIER_PDF = "bateaux.pdf";
	
	public static String DOSSIER_IMAGES = "C:\\Users\\cours\\Downloads\\img\\";
	public static String EXAMPLE_IMAGE = "brochure.jpg";
	public static String NOM_DEBUT_IMAGE = "img";
	public static String NOM_FIN_IMAGE = ".jpg";
}
