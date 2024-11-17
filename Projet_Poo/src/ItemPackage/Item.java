package ItemPackage;

public abstract class Item {
    private String nom;
    private String description;
    private double poids;

    public Item(String nom, double poids,String description) {
        this.nom = nom;
        this.poids = poids;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPoids() {
        return poids;
    }
  
    public void printUsageItem() {
        System.out.println("Vous utilisez " + this.nom);
    }

    public void examiner() {
        System.out.println(this.description);
    }

    public abstract void use();

}
