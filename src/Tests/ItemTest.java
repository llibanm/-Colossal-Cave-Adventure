package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ItemPackage.*;


class ItemTest {

    private Item testItem;

    @BeforeEach
    void setUp() {
        // Créer un objet concret de type Item en instanciant une sous-classe simple
        testItem = new Item("Potion", "Restores health", 0.5) {
            @Override
            public void utiliser() {
                // Redéfinir la méthode utiliser pour ce test concret
                System.out.println("Using the potion.");
            }
        };
    }

    @Test
    void testItemConstruction() {
        // Vérifier que l'objet Item a été correctement instancié
        assertNotNull(testItem);
        assertEquals("Potion", testItem.getNom());
        assertEquals("Restores health", testItem.getDescription());
        assertEquals(0.5, testItem.getVolume());
    }

    @Test
    void testUtiliserMethod() {
        // Tester la méthode utiliser
        testItem.utiliser(); // Cela devrait imprimer "Using the potion."
    }

    @Test
    void testToStringMethod() {
        // Tester la méthode toString
        String expectedString = "Item{nom='Potion', description='Restores health', volume=0.5}";
        assertEquals(expectedString, testItem.toString());
    }

    @Test
    void testNom() {
        // Tester le getter pour le nom
        assertEquals("Potion", testItem.getNom());
    }

    @Test
    void testDescription() {
        // Tester le getter pour la description
        assertEquals("Restores health", testItem.getDescription());
    }

    @Test
    void testVolume() {
        // Tester le getter pour le volume
        assertEquals(0.5, testItem.getVolume());
    }
}

