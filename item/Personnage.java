package item;

public class Personnage {
    private final String nom;
    private int pointsDeVie;
    private boolean vivant;

    // Constructeur
    public Personnage(String nom, int pointsDeVie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.vivant = true;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public boolean isVivant() {
        return vivant;
    }

    // Méthode pour recevoir des dégâts
    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie <= 0) {
            vivant = false;
            pointsDeVie = 0;
            System.out.println(nom + " est mort !");
        }
    }

    // Méthode pour attaquer
    public void attaquer(Personnage cible, Arme arme) {
        if (!vivant) {
            System.out.println(nom + " est mort et ne peut pas attaquer !");
            return;
        }
        if (!arme.isActive()) {
            System.out.println("L'arme " + arme.getNom() + " n'est pas activée !");
            return;
        }
        System.out.println(nom + " attaque " + cible.getNom() + " avec " + arme.getNom());
        cible.recevoirDegats(arme.getDegats());
    }
}
