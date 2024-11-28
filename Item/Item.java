public class Item {
    private String nom;
    private String description;
    private double volume;
    private boolean transportable;

    // Constructeur
    public Item(String nom, String description, double volume, boolean transportable) {
        this.nom = nom;
        this.description = description;
        this.volume = volume;
        this.transportable = transportable;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isTransportable() {
        return transportable;
    }

    // Méthode par défaut pour utiliser un objet
    public void utiliser() {
        System.out.println(nom + " ne peut pas être utilisé directement.");
    }

    @Override
    public String toString() {
        return "Item{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", volume=" + volume +
                ", transportable=" + transportable +
                '}';
    }
}
