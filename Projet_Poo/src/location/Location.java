package location;

import game.Game;

import java.util.*;

public class Location {

    private String name;
    private Map<String,  Exit> exists = new HashMap<String, Exit>();


    public Location(String name) {
        this.name = name;
    }

    public void printLocation() {
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
    }

    public void goToDestination(String dest, Game game) {
        exists.get(dest).cross(game);
    }

    public  void setExit(String name, Exit newExit){
        exists.put(name,newExit);
    }
    public String getName(){
        return  name;
    }

    public void addExit(Boolean isbidirectionnal, String name, Location dest){
        Exit newExit = new Exit(dest, this,isbidirectionnal);
        setExit(name, newExit);

    }


    public void addExitWithPin(Boolean isbidirectionnal, String name, Location dest, int pin) {
        Exit newExit = new Exit(dest, this, isbidirectionnal);
        setExit(name, newExit);
    }

    public void addExitWithKey(Boolean isbidirectionnal, String name, Location dest, Key key) {
        Exit newExit = new Exit(dest, this, isbidirectionnal);
        setExit(name, newExit);

    }

}

