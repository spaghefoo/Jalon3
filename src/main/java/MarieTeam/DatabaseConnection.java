package MarieTeam;
import java.sql.*;
/**
* Classe DatabaseConnection. Elle permet de :
* <ul>
* <li>D'acc�der � la base de donn�es
* <li>Ouvrir une connection
* <li>Fermer une connection
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class DatabaseConnection {
  
    
    private Connection connection;
    private String DB_DRIVER = Parametres.DB_DRIVER;
    private String DB_URL = Parametres.DB_URL;

    /**
     * Constructeur d'une connection de base de donn�es
     */
    public DatabaseConnection() {
        try {
            Class.forName(this.DB_DRIVER);
            this.connection = DriverManager.getConnection(this.DB_URL, Parametres.DB_USER, Parametres.DB_PASSWORD);
            System.out.println("Connexion � la base de donn�es �tablie avec succ�s !");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
            
        }
    }
    
    /**
     * Retourne la connection
     * @return
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Ferme la connnection
     */
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connexion � la base de donn�es ferm�e avec succ�s !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion � la base de donn�es : " + e.getMessage());
        }
    }
    
}
