package MarieTeam;
/**
* Classe BateauMarchandise. Elle permet de :
* <ul>
* <li>Stocker les attributs d'un bateau de marchandise
* <li>Elle contient les getteurs et les setteurs
* <li>Cette classe hérite de la classe bateau pour les attributs communs
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class BateauMarchandise extends Bateau {
    private double poidsMaxBateauMarchandise;
    
    /**
     * Constructeur d'un bateau de marchandise
     * @param idBateau
     * @param nomBateau
     * @param longueur
     * @param largeur
     * @param vitesse
     * @param poidsMaxBateauMarchandise
     */
    public BateauMarchandise(int idBateau, String nomBateau, double longueur, double largeur, double vitesse,double poidsMaxBateauMarchandise) {
        super(idBateau,nomBateau,longueur,largeur,vitesse);
    	this.poidsMaxBateauMarchandise = poidsMaxBateauMarchandise;
    }

    /**
     * Get du poids max de marchandise que peut transporter le bateau
     * @return
     */
	public double getPoidsMaxBateauMarchandise() {
		return poidsMaxBateauMarchandise;
	}
	/***
	 * Set du poids max de marchandise que peut transporter le bateau
	 * @param poidsMaxBateauMarchandise
	 */
	public void setPoidsMaxBateauMarchandise(double poidsMaxBateauMarchandise) {
		this.poidsMaxBateauMarchandise = poidsMaxBateauMarchandise;
	}
}
