package ItemPackage.Item;

import characterPackage.EnumDamageType;

public abstract class Weapon extends Item {
    private int degats;
    private boolean active;
    EnumDamageType.DamageType damageType;

    // Constructeur
    public Weapon(String nom, String description, double volume, int degats, EnumDamageType.DamageType e) {
        super(nom, description, volume);
        this.degats = degats;
        this.active = false;
        damageType=e;
    }

    // Getters et setters
    public int getDegats() {
        return this.degats;
    }

    public EnumDamageType.DamageType getDamageType() {
        return this.damageType;
    }

    public boolean isActive() {
        return active;
    }

    public void activer() {
        active = true;
        System.out.println(getNom() + " est maintenant activée !");
    }

    public void desactiver() {
        active = false;
        System.out.println(getNom() + " est maintenant désactivée !");
    }


}
