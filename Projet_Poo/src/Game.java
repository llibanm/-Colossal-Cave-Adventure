import java.util.Scanner;

public class Game //extends CommandImplementation
{
    private CommandImplementation command;
    private EnumCommand.Command currentCommand;

    private static Scanner sc;
    private static boolean gameFinished;
    private static String commandString;



    public Game(){
        gameFinished = false;
        command = new CommandImplementation();
    }

    //pour les vérifications
    public boolean isGameFinished(){
        return gameFinished;
    }

    public void setGameFinished(){
        gameFinished = true;
    }

    // pour les affichages

    public void printCommand(){// pour test
        System.out.println("Command typed :"+commandString);
    }


    public void welcomePrint(){
        System.out.println("""
                           Welcome to the game!
                           I hope you will enjoy it.
                           If you need any help, don't forget to enter the command HELP to know about all the command,
                           or HELP with a specific command to know about it.""");

    }

    //Pour les entrées

    public void openScan(){
        sc = new Scanner(System.in);
    }

    public void closeScan(){
        sc.close();
    }

    public void ScanGame(){//pour l'entrée
        System.out.println("""
                \nEnter the command that you want to perform. Write HELP with or without another command if need.
                """);
        System.out.print("Command: ");
        commandString=sc.nextLine();
    }



    public void addCommandArgumentIntoList(){// pour récupérer les commandes dans le chaine de charactere
        String commandInput;

        int index=commandString.indexOf(' ');

        if( index== -1 ){
            System.out.print("""
                    The output is undetectable.
                    Please try again.
                    """);
            return;
        }
        commandInput=commandString.substring(0,index); //on récupère la première instance avant un espace

        switch(commandInput.toUpperCase()){ // on le change en type énuméré
            case "HELP":
                currentCommand=EnumCommand.Command.HELP;break;
            case "QUIT":
                currentCommand= EnumCommand.Command.QUIT;break;
            case "SAVE":
                currentCommand= EnumCommand.Command.SAVE;break;
            case "LOAD":
                currentCommand= EnumCommand.Command.LOAD;break;
            case "USE":
                currentCommand= EnumCommand.Command.USE;break;
            case "DESTROY":
                currentCommand= EnumCommand.Command.DESTROY;break;
            case "LOOK":
                currentCommand= EnumCommand.Command.LOOK;break;
            case "DROP":
                currentCommand= EnumCommand.Command.DROP;break;
            case "TAKE":
                currentCommand= EnumCommand.Command.TAKE;break;
            case "GO":
                currentCommand= EnumCommand.Command.GO;break;
            default:
                System.out.println("""
                        Unknown command.
                        please try again.
                        """);
                return;
        }

        commandInput=commandString.substring(index); // on récupère ce qu'il y'a après l'espace

        if(commandInput.isEmpty()){
            return;
        }

        index=commandInput.indexOf(' '); // on récupère la deuxieme instance d'espace

        if(index== -1 ){
            command.addCommand(commandInput);
        }
        else{ // on ajoute les arguments dans la liste
            command.addCommand(commandInput.substring(0, index));
            command.addCommand(commandInput.substring(index+1));
        }
    }

    //

    // JEU

    public void gameLoop(){

       welcomePrint();
       openScan();
       while(!isGameFinished()){
           while(currentCommand == null){
               ScanGame();
               addCommandArgumentIntoList();
           }

           switch(currentCommand){
               case EnumCommand.Command.HELP:
                   command.Help();
                   break;

               case  EnumCommand.Command.QUIT:
                   setGameFinished();
                   break;

               default:
                   System.out.println("""
                                         The command you typed has not been recognized.
                                         Please try again.
                                         """);
                   break;
           }
           command.emptyCommand();
       }
       closeScan();



    }

}
