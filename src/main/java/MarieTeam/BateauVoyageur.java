package MarieTeam;
import java.util.ArrayList;
/**
* Classe BateauVoyageur. Elle permet de :
* <ul>
* <li>Stocker les attributs d'un bateau de voyageur. Attribut non commun est la liste des equipements
* <li>Elle contient les getteurs et les setteurs
* <li>Cette classe hérite de la classe bateau pour les attributs communs
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class BateauVoyageur extends Bateau {
    private ArrayList<Equipement> listeEquipements = new ArrayList<Equipement>();

    /**
     * Ajout d'une équipement dans un bateau voyageur
     * @param idEquipement
     * @param equipement
     */
    public void addEquipement(int idEquipement, String equipement)
    {
    	Equipement e = new Equipement(idEquipement,equipement);
    	listeEquipements.add(e);
    }
    /**
     * Constrcuteur d'un bateau de voyageur
     * @param idBateau
     * @param nomBateau
     * @param longueur
     * @param largeur
     * @param vitesse
     */
    public BateauVoyageur(int idBateau, String nomBateau, double longueur, double largeur, double vitesse) {
        super(idBateau,nomBateau,longueur,largeur,vitesse);
    	listeEquipements = new ArrayList<Equipement>();
    }
    
    /**
     * Retourne la liste des équipements
     * @return Retourne la liste des équipements
     */
    public ArrayList<Equipement> getListeEquipements(){
    	return listeEquipements;
    }
   
    /**
     * ToSrint sert pour afficher en mode texte
     * @return Retourne une chaine permettant l'affichage
     */
    public String toString() {
    	return 	" ---- " +this.getIdBateau() + " ---- " + this.getNomBateau() +
    			" ---- " + this.getLongueur() + "m";
     }
}
