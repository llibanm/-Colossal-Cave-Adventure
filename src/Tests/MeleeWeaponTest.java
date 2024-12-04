package Tests;

import characterPackage.EnumDamageType;
import ItemPackage.MeleeWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeleeWeaponTest {

    // Classe concrète pour tester la classe abstraite MeleeWeapon
    static class TestMeleeWeapon extends MeleeWeapon {
        public TestMeleeWeapon(String nom, String description, double volume, boolean transportable, int degats, EnumDamageType.DamageType damageType) {
            super(nom, description, volume, transportable, degats, damageType);
        }

        @Override
        public void utiliser() {
            // Implémentation fictive pour les tests
            System.out.println("Vous utilisez " + getNom() + " pour attaquer.");
        }
    }

    private MeleeWeapon meleeWeapon;

    @BeforeEach
    void setUp() {
        meleeWeapon = new TestMeleeWeapon(
                "Épée",
                "Une épée tranchante",
                3.0,
                true,
                50,
                EnumDamageType.DamageType.MAGIC
        );
    }

    @Test
    void testCreation() {
        assertEquals("Épée", meleeWeapon.getNom());
        assertEquals("Une épée tranchante", meleeWeapon.getDescription());
        assertEquals(3.0, meleeWeapon.getVolume(), 0.001);
        assertEquals(50, meleeWeapon.getDegats());
        assertEquals(EnumDamageType.DamageType.MAGIC, meleeWeapon.getDamageType());
    }

    @Test
    void testCombatCorpsACorps() {
        // Simple appel de méthode pour vérifier qu'elle ne génère pas d'exception
        meleeWeapon.combatCorpsACorps();
    }

    @Test
    void testUtiliser() {
        // Simple appel de méthode pour vérifier qu'elle ne génère pas d'exception
        meleeWeapon.utiliser();
    }
}
