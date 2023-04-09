package MarieTeam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipementTest {

    @Test
    void getIdEquipement() {
        Equipement equip1 = new Equipement(1,"Autoradio");

        assertEquals(1, equip1.getEquipement());
    }

    @Test
    void setIdEquipement() {
        Equipement equip2 = new Equipement(10, "BoomBox");

        equip2.setIdEquipement(11);

        assertEquals(11, equip2.getEquipement());

    }

    @Test
    void getEquipement() {
        Equipement equip2 = new Equipement(10, "BoomBox");

        assertEquals("BoomBox", equip2.getEquipement());
    }

    @Test
    void setEquipement() {
        Equipement equip2 = new Equipement(10, "BoomBox");

        equip2.setEquipement("Bouées");
        assertEquals("Bouées", equip2.getEquipement());

    }
}