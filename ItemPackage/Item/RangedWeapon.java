package ItemPackage.Item;

import characterPackage.EnumDamageType;

public abstract class RangedWeapon extends Weapon {

   

    // Constructeur
    public RangedWeapon(String nom, String description, double volume, boolean transportable, int degats, EnumDamageType.DamageType type) {
        super(nom, description, volume, degats,type);
    }

    public void attaquer() {
        if (isActive()) {
            System.out.println("L'arme de loin " + getNom() + " tire à distance et inflige " + getDegats() + " dégâts !");
        } else {
            System.out.println("L'arme de loin " + getNom() + " n'est pas activée et ne peut pas tirer.");
        }
    }

    // Méthode spécifique aux armes de loin
    public void tirADistance() {
        System.out.println("Vous tirez avec précision à distance avec " + getNom() + ".");
    }
}
