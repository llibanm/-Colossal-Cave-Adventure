package Game.StoryPackage;

public class Story {
    private int storyProgression;

    public Story(int storyProgression) {
        storyProgression = storyProgression;
    }

    public static Story beginningStory(){
        System.out.println("\nYou wake up hardly and with great difficulty.\n");
        pause(1);
        System.out.println("You attempt to open your still-sleepy eyes.");
        System.out.println("""
                Fields of grass and Roses surround you and the chirping of hummingbirds and dove embrace your ear
                beautifully.
                """);
        pause(3);
        System.out.println("""
                Trees ,tall and small, far in the horizon,
                calming winds touching your cheeks.
                """);
        pause(3);
        System.out.println("""
                Although you don't why, you find yourself in a meadow.
                You try to assert your memory, but you're struck by a mild headache.
                """);
        pause(3);
        System.out.println("""
                You attempt to move your limbs and you hear a sound.
                """);
        pause(3);
        System.out.println("*CLANK*");

        pause(2);

        System.out.println("Your leg hit an object.");


        System.out.println("A backpack");
        pause(2);
        System.out.println("After drawing closer to it, you assess its content");

        pause(3);
        System.out.println("\nA rocky hammer");
        pause(2);
        System.out.println("Three band aids\n");
        //pause(2);
        //System.out.println("One key\n");
        //pause(2);
        //System.out.println("A torch");

        pause(3);
        System.out.println("And that's not just this, you find yourself wearing a cloth armor");

        pause(3);
        System.out.println("Questions rushes into your mind");

        pause(3);

        System.out.println(" 'Why is a backpack here ?' ");

        pause(3);
        System.out.println("""
                 'was i out for a journey ? For exploration ?'
                 ' and if so, what was the the goal of it ?'
                """);

        pause(3);
        System.out.println("""
           'Why am i here ?'
           'Why can't i recall anything ?'
           """);

        pause(3);
        System.out.println("""
                You attempt to reach for something tangible in theses questions but fail to grab
                unto anything.
                """);

        pause(3);
        System.out.println("""
               All you know now is that you must leave now.
               """);

        pause(3);
        System.out.println("""
                While picking the backpack from the grass, you find a name tag on it.
                """);

        pause(3);
        System.out.println("""
                Despite the poorly writing, you are still able to distinguish the letters.
                """);

        pause(3);
        System.out.println("""
                You attempt to read the name.
                """);
        return new Story(0);
    }


    public static void pause(int second){
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
