public class Item {
    private String nom;
    private String description;
    private double volume;
    private boolean transportable;

    public Item(String nom, String description, double volume, boolean transportable) {
        this.nom = nom;
        this.description = description;
        this.volume = Item.this.volume;
        this.transportable = transportable;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getvolume() {
        return volume;
    }

    public boolean isTransportable() {
        return transportable;
    }

    public void utiliser() {
        System.out.println("Cet objet ne peut pas être utilisé directement.");
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
