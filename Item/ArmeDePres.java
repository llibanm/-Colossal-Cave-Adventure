package Item;

public class ArmeDePres extends Arme {

    // Constructeur
    public ArmeDePres(String nom, String description, double volume, boolean transportable, int degats) {
        super(nom, description, volume, degats);
    }

    @Override
    public void attaquer() {
        if (isActive()) {
            System.out.println("L'arme de près " + getNom() + " frappe l'ennemi en infligeant " + getDegats() + " dégâts !");
        } else {
            System.out.println("L'arme de près " + getNom() + " n'est pas activée et ne peut pas frapper.");
        }
    }

    // Méthode spécifique aux armes de près
    public void combatCorpsACorps() {
        System.out.println("Vous engagez un combat rapproché avec " + getNom() + ".");
    }
}
