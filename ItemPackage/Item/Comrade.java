package ItemPackage.Item;

public class Comrade {
    private final String name;
    private int hp;
    private boolean isAlive;

    // Constructeur
    public Comrade(String name, int Hp) {
        this.name = name;
        this.hp = Hp;
        this.isAlive = true;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    // Méthode pour recevoir des dégâts
    public void recieveDamage(int degats) {
        hp -= degats;
        if (hp <= 0) {
            isAlive = false;
            hp = 0;
            System.out.println(name + " est mort !");
        }
    }

    // Méthode pour attaquer
    public void attackAlly(Comrade cible, Weapon arme) {
        if (!isAlive) {
            System.out.println(name + " est mort et ne peut pas attaquer !");
            return;
        }
        if (!arme.isActive()) {
            System.out.println("L'arme " + arme.getNom() + " n'est pas activée !");
            return;
        }
        System.out.println(name + " attaque " + cible.getName() + " avec " + arme.getNom());
        cible.recieveDamage(arme.getDegats());
    }
}
