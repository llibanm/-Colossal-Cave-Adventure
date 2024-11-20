import GameInterfaces.CommandInterface;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class CommandImplementation implements CommandInterface {

    private List<String> command;

    public CommandImplementation() {
        this.command = new ArrayList<>();
    }

    public void addCommand(String command) {
        this.command.add(command);
    }

    public void printCommand() {
        for (String command : this.command) {
            System.out.println(command);
        }
    }

    public int getNumCommand() {
        return command.size();
    }

    public String getFirstArg() {
        //command.getFirst();
        return command.get(0);
    }

    public boolean isEmptyCommand() {
        return command.isEmpty();
    }

    public String getSecondCommand() {
        return command.get(getNumCommand()-1);
    }

    public void emptyCommand() {
        this.command.clear();
    }

    @Override
    public void Help() {

        if(command.isEmpty()){
            System.out.println("""
                        HELP <Argument> -> Print the menu of commands if no argument given with it. Else, print the corresponding argument's description.
                        GO <Location> -> Move the main character in the corresponding Location
                        LOOK [LOCATION] -> if no argument given, display a menu of all observable arguments. Else display a description of the given argument, whether items or location
                        TAKE object -> send a specific object to the backpack if enough space is available
                        DROP object -> drop a specific object from the backpack in the location the character is currently in.
                        DESTROY object -> remove an object from the game, it cannot be recovered
                        USE object1 [object2] -> use an object, if the object require a second argument then it must be used with
                        a second one.
                        SAVE -> save the game in the game files.
                        QUIT -> Exit the game.\s
                        """);
            return;
        }

        String c= getFirstArg();
        switch(c.toUpperCase()){
            case "GO":
                System.out.println("\"GO <Location> -> Move the main character in the corresponding Location\n");
            break;

            case "HELP":
                System.out.println("HELP <Argument> -> Print the menu of commands if no argument given with it. Else, print the corresponding argument's description\n");
                break;

            case "LOOK":
                System.out.println("LOOK [LOCATION] -> if no argument given, display a menu of all observable arguments. Else display a description of the given argument, whether items or location\n");
                break;

            case "TAKE":
                System.out.println("TAKE object -> send a specific object to the backpack if enough space is available\n");
                break;

            case "DROP":
                System.out.println("DROP object -> drop a specific object from the backpack in the location the character is currently in.\n");
                break;

            case "DESTROY":
                System.out.println("DESTROY object -> remove an object from the game, it cannot be recovered\n");
                break;

            case "SAVE":
                System.out.println("SAVE -> save the game in the game files\n");
                break;

            case "USE":
                System.out.println("USE object1 [object2] -> use an object, if the object require a second argument then it must be used with a second one.\n");
                break;

            case "QUIT":
                System.out.println("QUIT -> Exit the game.\n");
                break;
            default:
                System.out.println("""
                        HELP <Argument> -> Print the menu of commands if no argument given with it. Else, print the corresponding argument's description.
                        GO <Location> -> Move the main character in the corresponding Location
                        LOOK [LOCATION] -> if no argument given, display a menu of all observable arguments. Else display a description of the given argument, whether items or location
                        TAKE object -> send a specific object to the backpack if enough space is available
                        DROP object -> drop a specific object from the backpack in the location the character is currently in.
                        DESTROY object -> remove an object from the game, it cannot be recovered
                        USE object1 [object2] -> use an object, if the object require a second argument then it must be used with
                        a second one.
                        SAVE -> save the game in the game files.
                        QUIT -> Exit the game.\s
                        """);
        }

    }

}
