package ItemPackage.Item;

import characterPackage.EnumDamageType;

public abstract class MeleeWeapon extends Weapon {


    // Constructeur
    public MeleeWeapon(String nom, String description, double volume, boolean transportable, int degats, EnumDamageType.DamageType damageType) {
        super(nom, description, volume, degats,damageType);
    }


    // Méthode spécifique aux armes de près
    public void combatCorpsACorps() {
        System.out.println("Vous engagez un combat rapproché avec " + getNom() + ".");
    }

}
