package MarieTeam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BateauVoyageurTest {

    @Test
    void addEquipement() {


        ArrayList<Equipement> EquipVerif = new ArrayList<Equipement>();
        ArrayList<Equipement> EquipVerifEq2 = new ArrayList<Equipement>();
        BateauVoyageur BateauVoyageurEq1 = new BateauVoyageur(10, "Titanic", 10.00, 13, 10);
        BateauVoyageur BateauVoyageurEq2 = new BateauVoyageur(11, "Mistral", 12.00, 12.12, 45);

        BateauVoyageurEq1.addEquipement(1,"Projecteur");
        BateauVoyageurEq1.addEquipement(2, "Piscine");
        BateauVoyageurEq1.addEquipement(3, "BoomBox");

        ArrayList<Equipement> EquipVrai = BateauVoyageurEq1.getListeEquipements();

        BateauVoyageurEq2.addEquipement(11, "Delorean");
        BateauVoyageurEq2.addEquipement(22, "Piscine");
        BateauVoyageurEq2.addEquipement(33, "Accès PMR");

        Equipement EquipementEq10 = new Equipement(1, "Projecteur");
        Equipement EquipementEq11 = new Equipement(2, "Piscine");
        Equipement EquipementEq12 = new Equipement(3, "BoomBox");

        EquipVerif.add(EquipementEq10);
        EquipVerif.add(EquipementEq11);
        EquipVerif.add(EquipementEq12);

        boolean test = true;
        for(int i = 0; i < EquipVerif.size(); i++)
        {

            if(EquipVerif.get(i).getIdEquipement() != BateauVoyageurEq1.getListeEquipements().get(i).getIdEquipement())
            {
                test = false;
                break;
            }
            if(EquipVerif.get(i).getEquipement() != BateauVoyageurEq1.getListeEquipements().get(i).getEquipement())
            {
                test = false;
                break;
            }
        }
        assertEquals(true, test);
    }

    @Test
    void getListeEquipements() {

        BateauVoyageur BateauEq1= new BateauVoyageur(10, "Titanic", 10.00, 13, 10);


        BateauEq1.addEquipement(1,"Projecteur");
        BateauEq1.addEquipement(2, "Piscine");
        BateauEq1.addEquipement(3, "BoomBox");
        assertTrue(BateauEq1.getListeEquipements() instanceof ArrayList<Equipement>);
    }

    @Test
    void testToString() {
        BateauVoyageur BateauVoyageurEq1 = new BateauVoyageur(10, "Titanic", 10.00, 13, 10);
        assertEquals(" ---- 10 ---- Titanic ---- 10.0m", BateauVoyageurEq1.toString());
    }
}