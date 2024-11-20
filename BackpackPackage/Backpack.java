package BackpackPackage;

import ItemPackage.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> items;
    private final double MAX_WEIGHT;
    private double weight;

    public Backpack(double weight) {
        items = new ArrayList<Item>();
        MAX_WEIGHT = weight;
        weight = 0;
    }

    public void printMaxWeight(){
        System.out.println("\nthe MAX weight of current backpack is ["+MAX_WEIGHT+"]");
    }

    public void printWeight(){
        System.out.println("\nthe weight of current backpack is ["+weight+"]");
    }

    // for item in backpack
    public void addItem(Item item) {
        if(weight + item.getPoids() > MAX_WEIGHT) {
            System.out.println("\n The weight is too large.\n");
            return;
        }
        items.add(item);
        weight+=item.getPoids();
    }

    public void removeItem(Item item) {
        items.remove(item);
        weight-=item.getPoids();
    }

    public void printItems() {
        System.out.println("The items in the backpack are: ");
        for (Item item : items) {
            System.out.println(""+item);
        }
    }

    public void lookIntoItem(Item item) {
        for(Item i : items) {
           if(i.equals(item)) {
               System.out.println("\n************[LOOKING INTO "+item.getNom()+"]*************");
               System.out.println("\n["+item.getNom()+"]");
               System.out.println("\n"+item.getDescription());
               System.out.println("\nWeight of "+item.getNom()+":["+item.getPoids()+"]\n");
           }
        }
    }
}
