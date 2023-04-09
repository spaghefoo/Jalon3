package MarieTeam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BateauMarchandiseTest {

    @Test
    void getPoidsMaxBateauMarchandise()
    {
        BateauMarchandise bateau1 =  new BateauMarchandise(1,"Bateau", 12.22, 12.22, 20, 100);
        assertEquals(100,bateau1.getPoidsMaxBateauMarchandise());
    }

    @Test
    void setPoidsMaxBateauMarchandise()
    {
        BateauMarchandise bateau1 =  new BateauMarchandise(1,"Bateau", 12.22, 12.22, 20, 100);
        bateau1.setPoidsMaxBateauMarchandise(120);
        assertEquals(120, bateau1.getPoidsMaxBateauMarchandise());
    }
}