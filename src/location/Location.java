package location;

import ItemPackage.Item;
import ItemPackage.Comrade;
import ItemPackage.meleeWeapon.RockyHammer;
import characterPackage.Enemies.*;
import ItemPackage.Key;
import java.util.*;

public class Location {

    private String name;
    private Map<String,  Exit> exists = new HashMap<String, Exit>();
    List<Item> items = new ArrayList<>();
    List<Comrade> Allies = new ArrayList<>();
    List<Foes> Foe = new ArrayList<>();
    public Location(String name) {
        this.name = name;
    }

    public void printLocation() {
        System.out.println("**************Lieux:"+getName()+"******************");
        /**affiche les sorties de la location et les items présents dans la location*/
        if (exists == null || exists.isEmpty()) {
            System.out.println("No exit visible.");
            return;
        }

        System.out.println("list of exits :");
        for (Map.Entry<String, Exit> entry : exists.entrySet()) {
            String key = entry.getKey(); // La clé (nom de la sortie)
            Exit value = entry.getValue(); // L'objet Exit associé
            System.out.println("Name : " + key + ", detail : " + value.getName());
        }
        System.out.println("list of items :  ");
        for (Item item : items) {
            System.out.println("item name "+item.getNom());
        }

    }

    public Location goToDestination(String dest, Location currloc) {
        /**Aller vers une destination spécifique, change la destination
         courante dans game*/
        // Exit destination = exists.get(dest);
        Exit destination = getExit(dest);
        if (destination != null) {
            return destination.cross(currloc);
        }
        else {
            System.out.println("cette sortie est inexistante");
            return  currloc;
        }
    }

    public Exit getExit(String exit){
        /**retourne une location qui sera casté plus tard
         pour accéder aux methodes spécifiques (ExitWithPin...)*/
        if (exists.containsKey(exit)) {
            return exists.get(exit);
        }
        else{
            return null;
        }
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
        ExitWithKey newExit = new ExitWithKey(dest, this,key, isbidirectionnal);
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

        prairieEntree.addFoe(new Werewolf(1));

        Key k1 = new Key("key", "clé",0.1, true,"porte desert final");
        montagne.addExitWithKey(false,"dessertFinal", DessertFinal, k1);
        montagne.addItem(k1);
        //ajout de quelques items et personnages
        RockyHammer hammer= new RockyHammer();
        prairieEntree.addItem(hammer);
        montagne.addItem(hammer);
        //Character ch = new Goblin(10);
        //montagne.addCharacter(ch);
        return prairieEntree;
    }

    /** Items of location*/
    public  void addItem(Item i){
        items.add(i);
    }

    public Item getItem(String name){
        Item i=null;
        for(Item item : items){
            if(name.equals(item.getNom())){
                i=item;
                removeItem(i);
                break;
            }
        }
        return i;
    }

    public  int getsizeItems(){
        return  items.size();
    }

    public void removeItem(Item i){
        items.remove(i);
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public void printItem(){
        for (Item item : items){
            System.out.println("item name: "+item.getNom());
        }
    }


    /**enemy of location*/

    public void addFoe(Foes foe){
        this.Foe.add(foe);
    }

    public void removeFoe(int index){
        this.Foe.remove(index);
    }

    public void printFoes(){

        if(Foe.isEmpty()){
            System.out.println("Aucun Enemie en vue!!!.");
            return;
        }

        for (Foes f : Foe){

            switch (f.getFoe()){
                case BLOB :
                    ((Blob)f).printStats();
                    break;

                case ZOMBIES:
                    ((Zombie)f).printStats();
                    break;

                case GOBLIN:
                    ((Goblin)f).printStats();
                    break;

                case WEREWOLF:
                    ((Werewolf)f).printStats();
                    break;
            }

        }
    }

    public int getSizeFoe(){
        return Foe.size();
    }

    public Foes getFirstFoe(){
        if(Foe.isEmpty()){
            return null;
        }
        return Foe.get(0);
    }

    public Foes getIndexFoe(int index){
        return Foe.get(index);
    }

    public boolean areFoesEmpty(){
        return Foe.isEmpty();
    }

    /**character of location*/
    public void addAlly(Comrade al){
        this.Allies.add(al);
    }

    public void removeAllies(int index){
        this.Allies.remove(index);
    }

    public void printCharacters(){
        for (Comrade al : Allies){
            System.out.println("nom perso: "+al.getName());
        }
    }
    public  int getSizeAllies(){
        return Allies.size();
    }

}

