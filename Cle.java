public class Cle extends Item {
    private final String cible;

    public Cle(String nom, String description, double volume, boolean transportable, String cible) {
        super(nom, description, volume, transportable);
        this.cible = cible;
    }

    // Getter pour la cible
    public String getCible() {
        return cible;
    }

    @Override
    public void utiliser() {
        System.out.println("You use the cle " + getNom() + " to open " + cible + ".");
    }

    @Override
    public String toString() {
        return "Cle{" +
                "name='" + getNom() + '\'' + ", description='" + getDescription() + '\'' + ", volume=" + getvolume();
    }
}