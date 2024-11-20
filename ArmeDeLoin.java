public class ArmeDeLoin extends Arme {

    // Constructeur
    public ArmeDeLoin(String nom, String description, double poids, boolean puissante) {
        super(nom, description, poids, puissante);
    }

    // Implémentation de la méthode attaquer
    @Override
    public void attaquer() {
        if (getactive()) {
            System.out.println("L'arme de loin " + getNom() + " ready to shoot in distance !");
        } else {
            System.out.println("L'arme de loin " + getNom() + " not ready to shoot.");
        }
    }

    // Méthode spécifique aux armes de loin
    public void tirADistance() {
        System.out.println("shoot in distance with " + getNom());
    }
}
