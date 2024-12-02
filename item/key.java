package item;

public class key extends Item {
    private final String cible;

    // Constructeur
    public key(String nom, String description, double volume, boolean cible) {
        super(nom, description, volume);
        this.cible = getCible();
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
        return "key{" +
                "nom='" + getNom() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", volume=" + getVolume() +
                ", cible='" + cible + '\'' +
                '}';
    }
}

