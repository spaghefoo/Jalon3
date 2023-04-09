package MarieTeam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
* Classe Passerelle. Elle permet de :
* <ul>
* <li>Permet de prendre les objets en base de données
* <li>Convertir en instances des classes métiers BateauVoyageur et Euquipement
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class Passerelle {
	private ArrayList<BateauVoyageur> listeBateaux;
	private Connection connection;
	
	/**
	 * Constructeur d'une passerrelle
	 * Reecupere les données en base et charge les bateaux
	 */
	public Passerelle()
	{
		listeBateaux = new ArrayList<BateauVoyageur>();
		setAllBateaux(); // Chargement de tous les bateaux et equiepements

	}
	/**
	 * Renvoie la liste des bateaux
	 * @return ArrayList
	 */
	public ArrayList<BateauVoyageur> getListeBateaux() {
		return listeBateaux;
	}

    //La méthode getAllBateaux récupère tous les bateaux présents dans la table Bateau et les stocke dans une liste de Bateau
    public  void setAllBateaux() {
        try {
        	DatabaseConnection dbConnection = new DatabaseConnection();
        	connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Bateau");
            while(resultSet.next()) {
            	BateauVoyageur bateau = new BateauVoyageur(resultSet.getInt("IdBateau"), resultSet.getString("nomBateau"), resultSet.getDouble("Longueur"), resultSet.getDouble("Largeur"), resultSet.getDouble("Vitesse"));
            	
            	// Recuperation des equipements
            	PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM attribuer, equipement WHERE IdBateau = ? and equipement.IdEquipement = attribuer.IdEquipement");
            	statement2.setInt(1, resultSet.getInt("IdBateau"));
            	ResultSet resultSet2 = statement2.executeQuery();
            	
            	while(resultSet2.next()) {
            		bateau.addEquipement(resultSet2.getInt("IdEquipement"), resultSet2.getString("Equipement"));
            	}
                listeBateaux.add(bateau);
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des bateaux : " + e.getMessage());
        }
    }
    
    /**
     * 	Classe de test unitaire sans Base de Données
     * @param debug
     */
    	public Passerelle(boolean debug) {
    		listeBateaux = new ArrayList<BateauVoyageur>();
    		
    		BateauVoyageur bateau1 = new BateauVoyageur(1,"Bateau 1",10.0,5.0,2.5);
    		bateau1.addEquipement(1, "Equipement 1");
    		bateau1.addEquipement(2, "Equipement 2");
    		listeBateaux.add(bateau1);
    		
    		BateauVoyageur bateau2= new BateauVoyageur(2,"Bateau 2",11.0,6.0,2.5);
    		bateau2.addEquipement(3, "Equipement 3");
    		bateau2.addEquipement(4, "Equipement 4");
    		listeBateaux.add(bateau2);
    		
    		BateauVoyageur bateau3= new BateauVoyageur(3,"Bateau 3",12.0,6.0,2.5);
    		bateau3.addEquipement(3, "Equipement 4");
    		bateau3.addEquipement(4, "Equipement 5");
    		listeBateaux.add(bateau3);
    		
    	}
    	
 /*******   A UTLISER SI BESOIN	
    	//La méthode getAllBateaux récupère tous les bateaux présents dans la table Bateau et les stocke dans une liste de Bateau
        public static ArrayList<Bateau> getAllBateaux() {
            ArrayList<Bateau> bateaux = new ArrayList<Bateau>();
            try {
                Connection connection = new DatabaseConnection().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Bateau");
                while(resultSet.next()) {
                    Bateau bateau = new Bateau(resultSet.getInt("IdBateau"), resultSet.getString("nomBateau"), resultSet.getDouble("Longueur"), resultSet.getDouble("Largeur"), resultSet.getDouble("Vitesse"));
                    bateaux.add(bateau);
                }
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la récupération des bateaux : " + e.getMessage());
            }
            return bateaux;
        }

        //La méthode getBateauById récupère un bateau en fonction de son identifiant et renvoie un objet Bateau.
        public static Bateau getBateauById(int idBateau) {
            Bateau bateau = null;
            try {
                Connection connection = new DatabaseConnection().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Bateau WHERE IdBateau = ?");
                statement.setInt(1, idBateau);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    bateau = new Bateau(rs.getInt("IdBateau"), rs.getString("nomBateau"), rs.getDouble("Longueur"), rs.getDouble("Largeur"), rs.getDouble("Vitesse"));
                }
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la récupération du bateau : " + e.getMessage());
            }
            return bateau;
        }
        
        //La méthode insertBateau permet d'insérer un nouveau bateau dans la table Bateau. 
        //Elle prend en paramètre un objet Bateau et utilise une requête préparée pour insérer les valeurs dans la base de données
        public static void insertBateau(Bateau bateau) {
            try {
                Connection connection = new DatabaseConnection().getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Bateau (IdBateau, nomBateau, Longueur, Largeur, Vitesse) VALUES (?, ?, ?, ?, ?)");
                statement.setInt(1, bateau.getIdBateau());
                statement.setString(2, bateau.getNomBateau());
                statement.setDouble(3, bateau.getLongueur());
                statement.setDouble(4, bateau.getLargeur());
                statement.setDouble(5, bateau.getVitesse());
                statement.executeUpdate();
                connection.close();
                System.out.println("Le bateau a été ajouté à la base de données avec succès !");
            } catch (SQLException e) {
                System.err.println("Erreur lors de l'ajout du bateau à la base de données : " + e.getMessage());
            }
        }
        
        //La méthode updateBateau permet de mettre à jour les informations d'un bateau existant dans la table Bateau
        //Elle prend en paramètre un objet Bateau et utilise une requête préparée pour mettre à jour les valeurs dans la base de données
        public static void updateBateau(Bateau bateau) {
            try {
                Connection connection = new DatabaseConnection().getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE Bateau SET nomBateau = ?, Longueur = ?, Largeur = ?, Vitesse = ? WHERE IdBateau = ?");
                statement.setString(1, bateau.getNomBateau());
                statement.setDouble(2, bateau.getLongueur());
                statement.setDouble(3, bateau.getLargeur());
                statement.setDouble(4, bateau.getVitesse());
                statement.setInt(5, bateau.getIdBateau());
                statement.executeUpdate();
                connection.close();
                System.out.println("Le bateau a été mis à jour dans la base de données avec succès !");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la mise à jour du bateau dans la base de données : " + e.getMessage());
            }
        }
        
        //La méthode deleteBateau permet de supprimer un bateau de la table Bateau en fonction de son identifiant.
        public static void deleteBateau(int idBateau) {
            try {
                Connection connection = new DatabaseConnection().getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM Bateau WHERE IdBateau = ?");
                statement.setInt(1, idBateau);
                statement.executeUpdate();
                connection.close();
                System.out.println("Le bateau a été supprimé avec succès !");
            } catch (SQLException e) {
            	System.err.println("Erreur lors de la suppression du bateau : " + e.getMessage());
            	}
        }  
********/  		
}
