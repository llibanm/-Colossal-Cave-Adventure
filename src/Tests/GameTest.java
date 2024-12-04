package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.Game;
import CommandImplementationPackage.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        // Créer une instance de Game avant chaque test
        game = new Game();
    }

    @Test
    void testGameInitialization() {
        // Vérifier que le jeu a été initialisé correctement
        assertNotNull(game);
        assertNotNull(game.getHero());
        assertNotNull(game.getCurrentLocation());
    }

   /* @Test
    void testGameLoop() {
        // Ce test doit vérifier si la boucle de jeu fonctionne.
        // Pour simplifier, nous allons vérifier si la méthode `gameLoop` ne lance pas d'exception.
        try {
            game.gameLoop();
        } catch (Exception e) {
            fail("Le jeu a échoué lors de l'exécution de la boucle.");
        }
    }*/

  /*  @Test
    void testSetHeroName() {
        // Vérifier si le nom du héros est défini correctement.
        game.setHero();
        assertNotNull(game.getHero().getHeroName());
        assertFalse(game.getHero().getHeroName().isEmpty());
    }

    @Test
    void testFight() {
        // Vérifier si la méthode de combat fonctionne correctement
        try {
            game.fight();
        } catch (Exception e) {
            fail("Le combat a échoué.");
        }
    }

    @Test
    void testPrintMessageWithHeroName() {
        // Tester la méthode de message avec le nom du héros
        game.getHero().setHeroName("John");
        game.PrintMessageWithHeroName("Welcome, ");
        // Vous devriez voir "Welcome, John" dans la sortie de la console.
    }

    @Test
    void testCommandProcessing() {
        // Tester si les commandes sont bien traitées
        game.transformStringToEnum("HELP");
        assertEquals(EnumCommand.Command.HELP, game.getCurrentCommand());

        game.transformStringToEnum("QUIT");
        assertEquals(EnumCommand.Command.QUIT, game.getCurrentCommand());
    }

    @Test
    void testIsGameFinished() {
        // Vérifier si la condition de fin de jeu fonctionne
        game.setGameFinished();
        assertTrue(game.isGameFinished());
    }

    @Test
    void testScanGame() {
        // Teste la lecture de la commande via l'entrée utilisateur
        // Dans un vrai test, il faut simuler l'entrée utilisateur (par exemple, utiliser un scanner simulé)
        try {
            game.openScan();
            game.ScanGame(); // Devrait fonctionner sans problème
        } catch (Exception e) {
            fail("La lecture des commandes a échoué.");
        }
    }*/

}
