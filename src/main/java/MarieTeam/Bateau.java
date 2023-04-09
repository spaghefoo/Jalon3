package MarieTeam;

/**
* Classe Bateau. Elle permet de :
* <ul>
* <li>Stocker les attributs d'un bateau
* <li>Elle contient les getteurs et les setteurs
* <li>Classe mere de tous les bateaux
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class Bateau {
    
    private int idBateau;
    private String nomBateau;
    private double longueur;
    private double largeur;
    private double vitesse;
	/**
	 * Constructeur de Bateau    
	 * @param idBateau : id du bateau
	 * @param nomBateau : nom du bateau
	 * @param longueur : longueur du bateau
	 * @param largeur : largeur du bateau
	 * @param vitesse : vitesse du bateau
	 */
    public Bateau(int idBateau, String nomBateau, double longueur, double largeur, double vitesse) {
        this.setIdBateau(idBateau);
        this.setNomBateau(nomBateau);
        this.setLongueur(longueur);
        this.setLargeur(largeur);
        this.setVitesse(vitesse);
    }
    /**
     * Permet de convertir en chaine le nom du bateau
     * @return : String 
     */
    public String toString() {
    	return idBateau + " " + nomBateau;
     }
    
    /**
     * Get l'id id bateau
     * @return int : Id du bateau
     */
	public int getIdBateau() {
		return idBateau;
	}
	/**	
	 * Set l'id du bateau
	 * @param idBateau : id du bateau
	 */
	public void setIdBateau(int idBateau) {
		this.idBateau = idBateau;
	}
	/**
	 * Get le nom du bateau
	 * @return nom du bateau
	 */
	public String getNomBateau() {
		return nomBateau;
	}
	/**
	 * Set le nom du bateau
	 * @param nomBateau: nom du bateau
	 */
	public void setNomBateau(String nomBateau) {
		this.nomBateau = nomBateau;
	}
	/**
	 * Get la longueur du bateau
	 * @return : entier longueur du bateau
	 */
	public double getLongueur() {
		return longueur;
	}
	/**
	 * Set la longueur du bateau
	 * @param longueur : Reel la logueur du bateau
	 */
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	/**
	 * Get la largeur du bateau
	 * @return la largeur du bateau
	 */
	public double getLargeur() {
		return largeur;
	}
	/**
	 * Set la largeur du bateau
	 * @param largeur : largeur du bateau
	 */
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	/**
	 * Get la vistesse du bateau
	 * @return la vitesse du bateau
	 */
	public double getVitesse() {
		return vitesse;
	}
	/**
	 * Set la vitesse du bateau
	 * @param vitesse : vitesse du bateau
	 */
	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}
	
	public String getNomImage() {
		String nomImage = Parametres.NOM_DEBUT_IMAGE + this.getIdBateau()+Parametres.NOM_FIN_IMAGE;
		System.out.println("Image " + nomImage);
		return nomImage;
	}
}


