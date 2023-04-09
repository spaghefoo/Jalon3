package MarieTeam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BateauTest {

    @Test
    void testToString() {
        Bateau bateau1 = new Bateau(0, "Al xi", 100.60, 200.30, 15.45);
        Bateau bateau2 = new Bateau(1, "Supra Bateau", 50.6, 222.33, 40.45);

        assertEquals("0 Al xi", bateau1.toString());
        assertEquals("1 Supra Bateau", bateau2.toString());
    }

    @Test
    void getIdBateau() {
        Bateau bateau1 = new Bateau(0, "Al xi", 100.60, 200.30, 15.45);
        Bateau bateau2 = new Bateau(1, "Supra Bateau", 100.60, 200.30, 15.45);

        assertEquals(0, bateau1.getIdBateau());
        assertEquals(0, bateau2.getIdBateau());
    }

    @Test
    void setIdBateau() {
        Bateau bateau1 = new Bateau(0, "Al xi", 100.60,200.30, 15.45);
        Bateau bateau2 = new Bateau(3, "Titanic", 102.60,203.30, 15.45);

        bateau1.setIdBateau(10);
        bateau2.setIdBateau(11);
        assertEquals(10, bateau1.getIdBateau());
        assertEquals(11, bateau2.getIdBateau());
    }

    @Test
    void getNomBateau() {
        Bateau bateau1 = new Bateau(0, "Al xi", 100.60,200.30, 15.45);
        Bateau bateau2 = new Bateau(3, "Titanic", 102.60,203.30, 15.45);

        assertEquals("Al xi", bateau1.getNomBateau());
        assertEquals("Titanic", bateau2.getNomBateau());
    }

    @Test
    void setNomBateau() {
        Bateau bateau1 = new Bateau(0, "Placeholder", 80,200, 15.45);

        bateau1.setNomBateau("Mistal");

        assertEquals("Mistal", bateau1.getNomBateau());
    }

    @Test
    void getLongueur() {
        Bateau bateau1 = new Bateau(0, "Al xi", 99,200, 15.45);

        assertEquals(99, bateau1.getLongueur());
    }

    @Test
    void setLongueur() {
        Bateau bateau1 = new Bateau(0, "Al xi", 99,200, 15.45);

        bateau1.setLongueur(99);
        assertEquals(99, bateau1.getLongueur());
    }

    @Test
    void getLargeur() {
        Bateau bateau1 = new Bateau(0, "Al xi", 99,200, 15.45);

        assertEquals(200, bateau1.getLargeur());
    }

    @Test
    void setLargeur() {
        Bateau bateau1 = new Bateau(0, "Al xi", 99,200, 15.45);

        bateau1.setLargeur(1000.1234);
        assertEquals(1000.1234, bateau1.getLargeur());
    }

    @Test
    void getVitesse() {
        Bateau bateau1 = new Bateau(0, "Al xi", 99,200, 15.45);

        assertEquals(15.45, bateau1.getVitesse());
    }

    @Test
    void setVitesse() {
        Bateau bateau1 = new Bateau(0, "Al xi", 99,200, 15.45);

        bateau1.setVitesse(100.100);

        assertEquals(100.100, bateau1.getVitesse());
    }

    @Test
    void getNomImage() {
        //String image = Parametres.NOM_FIN_IMAGE;
        Bateau bateau1 = new Bateau(100, "Al xi", 99,200, 15.45);

        assertEquals("img100.jpg", bateau1.getNomImage());
    }
}