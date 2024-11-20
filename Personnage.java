public class Personnage {
    private String nom;
    private int pointsDeVie;
    private boolean vivant;

    public Personnage(String nom, int pointsDeVie, boolean vivant) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.vivant = true;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie <= 0) {
            vivant = false;
            pointsDeVie = 0;
            System.out.println(nom + " DEAD !");
        }
    }

    public boolean isVivant() {
        return vivant;
    }

    public void attaquer(Personnage cible, Arme arme) {
        if (!vivant) {
            System.out.println(nom + " is dead and can't attack !");
        }
        else
        {
            System.out.println(nom + " attack " + cible.getNom() + " with " + arme.getNom() + " !");
        }
        cible.recevoirDegats(arme.getDegats());
    }
}

