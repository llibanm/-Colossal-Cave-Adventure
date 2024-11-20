public class ArmeDePres extends Arme {

    // Constructeur
    public ArmeDePres(String nom, String description, double poids, boolean active) {
        super(nom, description, poids, active);
    }

    @Override
    public void attaquer() {

    }

    // Redéfinir la méthode utiliser pour les armes de près
    @Override
    public void utiliser() {
        System.out.println("L'arme de près " + getNom() + " attaque avec une puissance de " + getactive() + " dans un combat rapproché.");
    }

    // Méthode spécifique aux armes de près
    public void combatCorpsACorps() {
        System.out.println("Combat corps à corps avec " + getNom());
    }
}
