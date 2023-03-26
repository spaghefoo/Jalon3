package MarieTeam;
/**
* Classe Equipement. Elle permet de :
* <ul>
* <li>Stocker les attributs des équipements des bateaux de voyageur
* <li>Elle contient les getteurs et les setteurs
* </ul>
* 
* @author      Galdric TINGAUD
* @author      Sofiane ACHERAIOU 
* @author      Theophane LEGRAND
*/
public class Equipement {
    private int idEquipement;
    private String equipement;

    /**
     * Constructeur d'une équipement
     * @param idEquipement
     * @param equipement
     */
    public Equipement(int idEquipement, String equipement) {
        this.idEquipement = idEquipement;
        this.equipement = equipement;
    }

    /**
     * Get l'id de l'équipement
     * @return l'id (entier)
     */
    public int getIdEquipement() {
        return idEquipement;
    }
    /**
     * Set l'id de l'équipement
     * @param idEquipement
     */
    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    /**
     * Get le nom de l'équipement
     * @return
     */
    public String getEquipement() {
        return equipement;
    }
    /**
     * Set le nom de l'équipement
     * @param equipement
     */
    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }
}
