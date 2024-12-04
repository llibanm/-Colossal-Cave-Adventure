package Tests;

import characterPackage.EnumDamageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ItemPackage.*;


import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    // Classe concrète pour tester la classe abstraite Weapon
    static class TestWeapon extends Weapon {
        public TestWeapon(String nom, String description, double volume, int degats, EnumDamageType.DamageType damageType) {
            super(nom, description, volume, degats, damageType);
        }

        @Override
        public void utiliser() {
            // Implémentation fictive pour les tests
            System.out.println("Vous utilisez " + getNom() + " pour attaquer.");
        }
    }

    private Weapon weapon;

    @BeforeEach
    void setUp() {
        weapon = new TestWeapon(
                "Arc",
                "Un arc long et puissant",
                5.0,
                30,
                EnumDamageType.DamageType.MAGIC
        );
    }

    @Test
    void testCreation() {
        assertEquals("Arc", weapon.getNom());
        assertEquals("Un arc long et puissant", weapon.getDescription());
        assertEquals(5.0, weapon.getVolume(), 0.001);
        assertEquals(30, weapon.getDegats());
        assertEquals(EnumDamageType.DamageType.MAGIC, weapon.getDamageType());
        assertFalse(weapon.isActive());
    }

    @Test
    void testActiver() {
        weapon.activer();
        assertTrue(weapon.isActive());
    }

    @Test
    void testDesactiver() {
        weapon.activer();
        weapon.desactiver();
        assertFalse(weapon.isActive());
    }

    @Test
    void testUtiliser() {
        // Simple appel pour vérifier qu'il n'y a pas d'exception
        weapon.utiliser();
    }
}

