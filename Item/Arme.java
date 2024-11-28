package Item;

public abstract class Arme extends Item {
    private int degats;
    private boolean active;

    // Constructeur
    public Arme(String nom, String description, double volume, int degats) {
        super(nom, description, volume);
        this.degats = degats;
        this.active = false;
    }

    // Getters et setters
    public int getDegats() {
        return degats;
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

    public abstract void attaquer();
}
