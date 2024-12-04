package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ItemPackage.*;

import static org.junit.jupiter.api.Assertions.*;

class KeyTest {

    private Key key;

    @BeforeEach
    void setUp() {
        key = new Key("Porte Clé", "Une clé dorée", 0.5, true, "Coffre Fort");
    }

    @Test
    void testKeyCreation() {
        assertEquals("Porte Clé", key.getNom());
        assertEquals("Une clé dorée", key.getDescription());
        assertEquals(0.5, key.getVolume(), 0.001);
        assertEquals("Coffre Fort", key.getCible());
    }

    @Test
    void testUtiliser() {
        // Appel simple pour vérifier qu'il n'y a pas d'exception
        key.utiliser();
    }

    @Test
    void testToString() {
        String expectedString = "Cle{nom='Porte Clé', description='Une clé dorée', volume=0.5, cible='Coffre Fort'}";
        assertEquals(expectedString, key.toString());
    }
}
