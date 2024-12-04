package ItemPackage.BackpackPackage;

import ItemPackage.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private List<Item> items;
    private final double MAX_CAPACITY;
    private double capacity;

    public Backpack(double cap) {
        items = new ArrayList<Item>();
        MAX_CAPACITY = cap;
        capacity = 0;
    }
    public double getCapacity() {
        return capacity;
    }
    public void printMaxWeight(){
        System.out.println("\nthe MAX weight of current backpack is ["+MAX_CAPACITY+"]");
    }

    public void printWeight(){
        System.out.println("\nthe weight of current backpack is ["+capacity+"]");
    }

    // for item in backpack
    public int getNumberItems(){
        return items.size();
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public Item getItem(String name){
        Item item = null;
        for(Item i: items){
            if(name.equals(i.getNom())){
                item = i;
                //removeItem(item);
                break;
            }

        }
        return item;
    }

    public void addItem(Item item) {
        if(capacity + item.getVolume() > MAX_CAPACITY) {
            System.out.println("\n The weight is too large.\n");
            return;
        }
        items.add(item);
        capacity+=item.getVolume();
    }

    public void removeItem(Item item) {
        items.remove(item);
        capacity-=item.getVolume();
    }


    public void printItems() {
        System.out.println("The items in the backpack are: ");
        int i  = 0;
        for (Item item : items) {
            System.out.println(i+"-"+item);
            i++;
        }
    }

    public void lookIntoItem(Item item) {
        for(Item i : items) {
           if(i.equals(item)) {
               System.out.println("\n************[LOOKING INTO "+item.getNom()+"]*************");
               System.out.println("\n["+item.getNom()+"]");
               System.out.println("\n"+item.getDescription());
               System.out.println("\nWeight of "+item.getNom()+":["+item.getVolume()+"]\n");
           }
        }
    }
}
