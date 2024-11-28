public class Cle extends Item {
    private String cible;

    // Constructeur
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
        System.out.println("Vous utilisez la clé " + getNom() + " pour ouvrir " + cible + ".");
    }

    @Override
    public String toString() {
        return "Cle{" +
                "nom='" + getNom() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", volume=" + getVolume() +
                ", cible='" + cible + '\'' +
                '}';
    }
}
