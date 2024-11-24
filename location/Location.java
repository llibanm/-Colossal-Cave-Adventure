package location;

import DamageTypePackage.EnumDamageType;
import ItemPackage.Item;
import ItemPackage.WeaponPackagge.EnumWeapon;
import ItemPackage.WeaponPackagge.Weapons;
import characterPackage.Enemies.Goblin;
import game.Game;
import characterPackage.Character;
import java.util.*;

public class Location {

    private String name;
    private Map<String,  Exit> exists = new HashMap<String, Exit>();
    List<Item> items = new ArrayList<>();
    List<Character> characters = new ArrayList<>();
    public Location(String name) {
        this.name = name;
    }

    public void printLocation() {
        /**affiche les sorties de la location et les items présents dans la location*/
        if (exists == null || exists.isEmpty()) {
            System.out.println("Aucune sortie disponible.");
            return;
        }

        System.out.println("Liste des sorties :");
        for (Map.Entry<String, Exit> entry : exists.entrySet()) {
            String key = entry.getKey(); // La clé (nom de la sortie)
            Exit value = entry.getValue(); // L'objet Exit associé
            System.out.println("Nom : " + key + ", Détail : " + value);
        }
        System.out.println("Liste d'items :  ");
        for (Item item : items) {
            System.out.println("Nom items "+item.getNom());
        }

    }

    public Location goToDestination(String dest, Location currloc) {
       /**Aller vers une destination spécifique, change la destination
        courante dans game*/
        Exit destination = exists.get(dest);
        return destination.cross(currloc);
    }

    public Exit getExit(String exit){
        /**retourne une location qui sera casté plus tard
         pour accéder aux methodes spécifiques (ExitWithPin...)*/
        return  exists.get(exit);
    }
    public  void setExit(String name, Exit newExit){
        /**insere  une nouvelle sortie parmi les sorties de la location actuelle*/
        exists.put(name,newExit);
    }
    public String getName(){
        /**retourne le nom de la location courante*/
        return  name;
    }

    public void addExit(Boolean isbidirectionnal, String name, Location dest){
        /**crée une nouvelle Sortie et l'insere dans la location actuelle */
        Exit newExit = new Exit(dest, this,isbidirectionnal);
        setExit(name, newExit);

    }


    public void addExitWithPin(Boolean isbidirectionnal, String name, Location dest, int pin) {
        /** cree une sortie avec code pin et l'insere,
         si elle est bidirectionnelle elle sera également insérée dans la location de destination
         afin de pouvoir revenir vers l'actuelle*/
        ExitWithPin newExit = new ExitWithPin(dest, this,pin, isbidirectionnal);
        setExit(name, newExit);
    }

    public void addExitWithKey(Boolean isbidirectionnal, String name, Location dest, Key key) {
        Exit newExit = new Exit(dest, this, isbidirectionnal);
        setExit(name, newExit);

    }
    public static Location genererMonde(){
        /**retourne Le monde(composé de 4 lieux) où le jeu se déroulera
         on retourne le lieux initial qui contiendra les sorties menant aux autres lieux */
        //liste des locations
        Location prairieEntree = new Location("prairieEntree");
        Location foret = new Location("foret");
        Location montagne = new Location("montagne");
        Location DessertFinal = new Location("dessertFinal");

        //insertion des portes entre  les lieux
        prairieEntree.addExit(true,"foret",foret);
        foret.addExitWithPin(true,"montagne", montagne, 1234 );

        Key k1 = new Key();
        montagne.addExitWithKey(false,"dessertFinal", DessertFinal, k1);

        //ajout de quelques items et personnages
        Weapons marteau = new Weapons("marteau", 10, "masse", EnumWeapon.WeaponType.BOW, EnumDamageType.DamageType.PHYSICAL,20);
        montagne.addItem(marteau);
        //Character ch = new Goblin(10);
        //montagne.addCharacter(ch);
        return prairieEntree;
    }

    /** Items de la location*/
    public  void addItem(Item i){
        items.add(i);
    }
    public  int getsizeItems(){
        return  items.size();
    }
    public void removeItem(int index){
        items.remove(index);
    }
    public void printItem(){
        for (Item item : items){
            System.out.println("nom item: "+item.getNom());
        }
    }


    /**Personnages de la location*/
    public void addCharacter(Character ch){
        this.characters.add(ch);
    }

    public void removeCharacter(int index){
        this.characters.remove(index);
    }
    public void printCharacters(){
        for (Character ch : characters){
            System.out.println("nom perso: "+ch.getHeroName());
        }
    }
    public  int getSizeCharacters(){
        return characters.size();
    }

}

