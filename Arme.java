public abstract class Arme extends Item {
    private boolean active;
    private int degat;

    // Constructeur
    public Arme(String nom, String description, double volume, boolean active) {
        super(nom, description, volume, active);
        this.active = active;
    }

    // Getter pour la active
    public boolean getactive() {
        return active;
    }
    public void setactive(boolean active) {
        this.active = active;
    }

    public abstract void attaquer();

    public int getDegats() {
        return degat;
    }
    public void setDegats(int degat) {
        this.degat = degat;
    }
}
