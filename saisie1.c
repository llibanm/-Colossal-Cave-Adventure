#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "saisie1.h"
#include "syllogisme.h"
#include "affichageSyl.h"
#include "setter.h"
#include "getter.h"
#include "regles.h"

static char *quantificateur[] = {"1 -> Type A : Tout S est P",
                                 "2 -> Type E : Aucun S n'est P",
                                 "3 -> Type I : Quelque S est P",
                                 "4 -> Type O : Quelque S n'est pas P"};

char *allouer(int n)
{
    char *s = malloc(n * sizeof(char));
    return s;
}

void desallouer(char *s)
{
    free(s);
}

// Premièr mode de saisi
void modeSaisi_V1()
{
    int input;
    Syllogisme syllogisme;

    printf("\n");
    printf("PS : POUR ÉVITER LES TAUTOLOGIES ET DOUBLE NÉGATION, VOUS POURRIEZ NOUS DONNER DES INFMATIONS PLUS PRÉCISES ET CLAIRES \n");
    printf("    LE BUT EST DE NE PAS AVOIR DES AMBIGUITÉS PENDANT LA SAISIE, DONC BIEN FORMULEZ VOTRE PHRASE ET LES MOTS !\n");
    printf("     ON VOUS REMERCIE ET ON VA BIEN TRAVAILLER ENSEMBLE!\n");
    printf("**********************************************************************************************************************\n");
    printf("\n");





    printf("Vous allez rédiger vous même les trois propositions: \n");
    printf("Quel type de proposition que vous souhaitez : \n");


        for (int i = 0; i < 4; i++)
    {
        printf("%s\n", quantificateur[i]);
    }

    printf("\n");
    printf("Vous avez une liste à choisir \n");
    printf("Veuillez choisir un numéro pour continuer!\n");
    
    for (int i = 1; i <= 3; i++)
    {
        //printf("Pour la proposition %d :\n", i);
        if (i == 1)
        {
            
            do{
                printf("------------ATTENTION----------------\n");
                printf("Veuillez choisir un numéro entre 1 et 4!\n");
                scanf_int("Pour la proposition 1 \n", &input);
            }while (input < 1 || input > 4);

            switch (input)
            {
            case 1:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[0]);
                syllogisme.U1 = true;
                syllogisme.A1 = true;
                break;
            case 2:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[1]);
                syllogisme.U1 = true;
                syllogisme.A1 = true;
                break;

            case 3:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[2]);
                syllogisme.U1 = false;
                syllogisme.A1 = true;
                break;
            case 4:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[3]);
                syllogisme.U1 = false;
                syllogisme.A1 = false;
                break;
            default:
                break;
            }
        }
        if (i == 2)
        {
            do{
                printf("------------ATTENTION----------------\n");
                printf("Veuillez choisir un numéro entre 1 et 4!\n");
                scanf_int("Pour la proposition 2 \n", &input);
            }while (input < 1 || input > 4);

            switch (input)
            {
            case 1:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[0]);
                syllogisme.U2 = true;
                syllogisme.A2 = true;
                 break;
            case 2:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[1]);
                syllogisme.U2 = true;
                syllogisme.A2 = true;
                 break;

            case 3:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[2]);
                syllogisme.U2 = false;
                syllogisme.A2 = true;
                break;
            case 4:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[3]);
                syllogisme.U2 = false;
                syllogisme.A2 = false;
                break;
            default:
                break;
            }
        }
        if (i == 3)
        {
            do{
                printf("------------ATTENTION----------------\n");
                printf("Veuillez choisir un numéro entre 1 et 4!\n");
                scanf_int("Pour la proposition 3 \n", &input);
            }while (input < 1 || input > 4);

            switch (input)
            {
            case 1:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[0]);
                syllogisme.Uc = true;
                syllogisme.Ac = true;
                break;
            case 2:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[1]);
                syllogisme.Uc = true;
                syllogisme.Ac = true;
                break;
            case 3:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[2]);
                syllogisme.Uc = false;
                syllogisme.Ac = true;
                break;
            case 4:
                printf("Vous avez choisi %d : %s\n", input, quantificateur[3]);
                syllogisme.Uc = false;
                syllogisme.Ac = false;
                break;
            default:
                break;
            }
        }
    }
    //bool hyp_ex = Ruu(&syllogisme);
    terme sujet = allouer(30);
    terme predicat = allouer(30);
    terme moyen_terme = allouer(30);
    //printf("Veuillez nous donner le sujet de votre conclusion : \n");
    scanf_char("Veuillez nous donner le sujet de votre conclusion : \n", &sujet);


    setSujet(&syllogisme, sujet);
    printf("%s\n", sujet);


    //printf("Veuillez nous donner le prédicat de votre conclusion : \n");
    scanf_char("Veuillez nous donner le prédicat de votre conclusion : \n", &predicat);
    setPredicat(&syllogisme, predicat);
    printf("%s\n", predicat);

    //printf("Veuillez nous donner le moyen terme : \n");
    scanf_char("Veuillez nous donner le moyen terme : \n", &moyen_terme);
    setMoyenTerme(&syllogisme, moyen_terme);
    printf("%s\n", syllogisme.moyen_terme);

    int fig;
    printf("Veuillez nous donner une figure que vous souhaitez : \n");
    printf("---------------------------------------------------------\n");
    printf("Figure 1    /    Figure 2   /   Figure 3    /    Figure 4 \n");
    printf("M   ->  P   /   P   ->  M   /   M   ->  P   /   P   ->  M \n");
    printf("S   ->  M   /   S   ->  M   /   M   ->  S   /   M   ->  S \n");
    printf("S   ->  P   /   S   ->  P   /   S   ->  P   /   S   ->  P \n");
    printf("---------------------------------------------------------\n");

    do{
        printf("------------ATTENTION----------------\n");
        printf("Veuillez choisir un numéro entre 1 et 4 pour continuer!\n");
        scanf_int("Pour la proposition 1 \n", &fig);
    }while (fig < 1 || fig > 4);


    syllogisme.figure = fig;
    printf("%d\n", fig);


    printf("\n");

    printf("Voici les donnée récupérées:\n");
    afficher_struct(&syllogisme);
    
    //affichage du syllogisme sous forme de figure

    afficher_syllogisme(&syllogisme, sujet, predicat, moyen_terme, fig);
    //test_gle(syllogisme, teste_de_validite(&syllogisme), hyp_ex, teste_pertinence(&syllogisme));

    initTabBool();
    printf_regle();
    displayBool();
    int numRegle;
    do
    {
        
        if(numRegle != -1)
        {
            scanf_regle(syllogisme, &numRegle);
        }
    } while (numRegle != -1);
    
    bool isValid = true;
    for(int i = 0; i < getSizeBool(); i++)
    {
        isValid = (isValid && getBool(i));
    }  
    if(isValid == true)
    {
        printf("\n");
        printf("=> Ce syllogisme est validé \n");
        displayBool();
    }  
    else
    {
        printf("\n");
        printf("=> Ce syllogisme n'est pas validé\n");
        for(int i = 0; i < getSizeBool(); i++)
        {
            if(getBool(i) == false)
            {
                printf("Vous avez pas satisfait la règle numéro %d\n", i);
            }
        }
        displayBool();
    }
    

    // initialiser les 3 propositions du syllogisme
    
    // init_proposs(&syllogisme, sujet, predicat, moyen_terme, figure);
    desallouer(sujet);
    desallouer(predicat);
    desallouer(moyen_terme);

}
