package item;

public abstract class Item {
    private String nom;
    private String description;
    private double volume;
    // Constructeur
    public Item(String nom, String description, double volume) {
        this.nom = nom;
        this.description = description;
        this.volume = volume;
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
                '}';
    }
}
