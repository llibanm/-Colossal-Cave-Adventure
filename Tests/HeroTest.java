package Tests;

import ItemPackage.BackpackPackage.Backpack;
import ItemPackage.BackpackPackage.StartingBackpack;
import ItemPackage.Weapon;
import characterPackage.Enemies.Foes;
import characterPackage.EnumDamageType;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characterPackage.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private Hero hero;
    private Weapon testWeapon;
    private Foes testFoe;

    @BeforeEach
    void setUp() {
        hero = new Hero();
        hero.setHeroName("TestHero");

        // Crée une arme fictive
        testWeapon = new Weapon("TestSword", "A sharp sword", 5.0, 10, EnumDamageType.DamageType.PHYSICAL) {
            @Override
            public void utiliser() {
                System.out.println("Using the TestSword.");
            }
        };

        // Ajoute l'arme au sac de départ
        hero.getCurrentBackpack().addItem(testWeapon);
        hero.setEquippedWeapon(testWeapon);

        // Crée un ennemi fictif
        testFoe = new Foes() {
            private int hp = 50;
            private final int armor = 20;
            private final int magicResistance = 10;
            private final String foeName = "TestFoe";

            @Override
            public int getHp() {
                return hp;
            }

            @Override
            public int getArmor() {
                return armor;
            }

            @Override
            public int getMagicResistance() {
                return magicResistance;
            }

            @Override
            public void lowerHp(int amount) {
                hp -= amount;
            }

            @Override
            public String getFoeName() {
                return foeName;
            }

            @Override
            public void setStat(int level) {
            }

            @Override
            public String switchName(int s) {
                return "";
            }

            @Override
            public void switchStats() {

            }
        };
    }

    @Test
    void testHeroInitialization() {
        assertEquals("TestHero", hero.getHeroName());
        assertNotNull(hero.getCurrentBackpack());
        assertFalse(hero.isHeroDead());
        assertEquals(10, hero.getHp());
        assertEquals(5, hero.getPower());
    }

    @Test
    void testEquipWeapon() {
        assertEquals(testWeapon, hero.getEquippedWeapon());
        assertEquals(10 + hero.getPower(), hero.getCumulativeDamage());
    }

    @Test
    void testAttackHeroPhysical() {
        int initialFoeHp = testFoe.getHp();
        hero.attackHero(testFoe);

        int damage = (int) ((100 - testFoe.getArmor()) / 100.0 * hero.getCumulativeDamage());
        assertEquals(initialFoeHp - damage, testFoe.getHp());
    }

    @Test
    void testBackpackManagement() {
        Backpack newBackpack = new StartingBackpack();
        hero.changeBackpack(newBackpack);

        assertEquals(newBackpack, hero.getCurrentBackpack());
    }

    @Test
    void testHeroDead() {
        hero.setHp(0);
        assertTrue(hero.isHeroDead());

        hero.setHp(-10);
        assertTrue(hero.isHeroDead());
    }
}

