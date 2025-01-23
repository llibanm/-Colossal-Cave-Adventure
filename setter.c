#include "syllogisme.h"
#include "getter.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>
#include "regles.h"
#include "affichageSyl.h"
#include "tousLesSyllo.h"
#include "setter.h"

#define MAX 256
//  setteurs

void setMoyenTerme(Syllogisme *self, const terme s)
{
    // + allocation avant usage
    self->moyen_terme = malloc(sizeof(char) * (strlen(s) + 1));
    strcpy(self->moyen_terme, s);
}

void setSujet(Syllogisme *self, const terme s)
{

    self->sujet = malloc(sizeof(char) * (strlen(s) + 1));
    strcpy(self->sujet, s);
}

void setPredicat(Syllogisme *self, const terme s)
{

    self->predicat = malloc(sizeof(char) * (strlen(s) + 1));
    strcpy(self->predicat, s);
}
void setFigure(Syllogisme *self, figure fig)
{
    self->figure = fig;
}

void setU1(Syllogisme *const self, bool v)
{
    self->U1 = v;
}
void setU2(Syllogisme *const self, bool v)
{
    self->U2 = v;
}
void setUc(Syllogisme *const self, bool v)
{
    self->Uc = v;
}

void setA1(Syllogisme *const self, bool v)
{
    self->A1 = v;
}
void setA2(Syllogisme *const self, bool v)
{
    self->A2 = v;
}
void setAc(Syllogisme *const self, bool v)
{
    self->Ac = v;
}

void setS(Syllogisme *const self, bool v)
{
    self->S = v;
}
void setP(Syllogisme *const self, bool v)
{
    self->P = v;
}
//......................
void setUx(Syllogisme *const self, int numProp, bool v)
{
    switch (numProp)
    {
    case 1:
        self->U1 = v;
        break;
    case 2:
        self->U2 = v;
        break;
    case 3:
        self->Uc = v;
        break;
    default:
        break;
    }
}

void setAx(Syllogisme *const self, int numProp, bool v)
{
    switch (numProp)
    {
    case 1:
        self->A1 = v;
        break;
    case 2:
        self->A2 = v;
        break;
    case 3:
        self->Ac = v;
        break;
    default:
        break;
    }
}

bool scanf_bool(char *message)
{
    char input[100];

    while (1)
    {
        printf("\n%s\n", message);

        if (fgets(input, sizeof(input), stdin) == NULL)
        { // LIRE LA LIGNE ENTIERE
            printf("Erreur de lecture. Veuillez réessayer.\n");
            continue; // EN CAS D'ERREUR DE LECTURE EN RE-ENTRE DANS LA BOUCLE WHILE
        }

        input[strcspn(input, "\n")] = '\0'; // REMPLACER LE \n A LA FIN PAR \0 POUR NE PAS PROVOQUER
                                            // D'ERREUR DANS LES LECTURES SUIVANTES

        if (strcmp(input, "0") == 0)
        { // VERIFIE SI L'ENTREE EST "0"
            return false;
        }
        else if (strcmp(input, "1") == 0)
        { // VERIFIE SI L'ENTREE EST "1"
            return true;
        }
        else
        {
            printf("----------------------ATTENTION-----------------------------\n");
            printf("Entrée invalide.\n");
        }
    }
}

bool isDigit(char *str) {
    while (*str) {
        if (isdigit(*str)) {
            return true;
        }
        str++;
    }
    return false;
}

void scanf_char(char *message, terme * chaine ) { //char s[100]
    bool isValid = false; 
    bool isChiffre = false;
    int taille;
    char* buffer = NULL;
    buffer = malloc(MAX*sizeof(char)); 
    printf("%s\n", message);
    do
    {
        printf("Entrez le terme que vous voulez ( c'est uniquement les lettres) : ");
        fgets(buffer, MAX, stdin);
        
        taille = strlen(buffer);        // suppression du saut de ligne
        if(isDigit(buffer))
        {
            isChiffre = true;
            printf("----------------------ATTENTION-----------------------------\n");
            printf("La saisie ne peut pas être un chiffre.\n\n");
        }
        else{
            isChiffre = false;
        }


        if( (buffer[taille - 1]) == '\n')
        {
            buffer[taille - 1] = '\0';
            taille--;
        }

        if( taille == 0)
        {
            printf("----------------------ATTENTION-----------------------------\n");
            printf("La saisie ne peut pas être vide.\n\n");        
        }
        else if (!isChiffre)
        {
            isValid = true;
            *chaine = malloc((taille + 1) * sizeof(char));
            strcpy(*chaine, buffer);
            printf("Le terme récupéré est : %s\n", *chaine);
        }   
         
        
    } while (!isValid);

    free(buffer);
}

void scanf_int(char *message, int *number)
{
    bool isValid = false;
    char *buffer = NULL;
    buffer = malloc(MAX * sizeof(char));
    printf("%s\n", message);
    do
    {
        printf("Entrez un nombre entier : ");
        fgets(buffer, MAX, stdin);
        buffer[strcspn(buffer, "\n")] = '\0'; // Remplacer le \n par \0
        if (isDigit(buffer))
        {
            isValid = true;
            *number = io_strToInt(buffer);
        }
        else
        {
            printf("----------------------ATTENTION-----------------------------\n");
            printf("La saisie ne peut pas être un caractère.\n\n");
        }
    } while (!isValid);
    free(buffer);
}

int io_strToInt(const char *s)
{
    if (s == NULL)
    {
        printf("Erreur chaine NULL\n");
    }
    long int tmp;
    char *end;

    tmp = strtol(s, &end, 10);

    return (int)tmp;
}

void activeRegle(Syllogisme sefl, int numRegle)
{
    switch (numRegle)
    {
    case 0:
        if (R_mt(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 0 : La quantité du moyen terme %s est universelle dans les deux premisses\n", sefl.moyen_terme);
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_mt **********************************\n\n");
            printf("La quantité du moyen terme %s n'est pas universelle dans les deux premisses\n", sefl.moyen_terme);
            printf("Ce syllogisme ne satisfait pas la règle R_mt, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 1:
        if (R_lh(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 1 : La quantité du Sujet %s de ce syllogisme est universelle dans sa premisse\n", sefl.sujet);
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_lh **********************************\n\n");
            printf("La quantité du Sujet %s ou du Predicat %s de ce syllogisme \n", sefl.sujet, sefl.predicat);
            printf("est universelle dans la conclusion mais ne l'est pas dans sa premisse\n");
            printf("Ce syllogisme ne satisfait pas la règle R_lh, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 2:
        if (Rnn(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 2 : Les deux premisses de ce syllogisme ne sont pas negatives\n");
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_nn **********************************\n\n");
            printf("Les deux premisses de ce syllogisme sont negatives\n");
            printf("Et nous savons que deux premisses négatives ne peuvent aboutir a une conclusion.\n");
            printf("Ainsi, ce syllogisme ne satisfait pas la regle R_nn, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 3:
        if (Rn(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 3 : Si une prémisse est négative, la conclusion est négative.\n");
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_n **********************************\n\n");
            printf("L'une des deux premisses de ce syllogisme est negative mais pas sa conclusion\n");
            printf("Et nous savons que si une premisse est négative la conclusion doit l'etre aussi.\n");
            printf("Ainsi, ce syllogisme ne satisfait pas la regle R_n, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 4:
        if (Raa(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 4 : Les deux premisses de ce syllogisme sont affirmatives\n");
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_aa **********************************\n\n");
            printf("Les deux premisses de ce syllogisme sont affirmatives mais pas sa conslusion\n");
            printf("Et nous savons que deux premisses positives donnent forcement une conclusion positive.\n");
            printf("Ainsi, ce syllogisme ne satisfait pas la regle R_aa, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 5:
        if (Rpp(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 5 : Les deux premisses de ce syllogisme ne sont pas particuliers\n");
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_pp **********************************\n\n");
            printf("Les deux premisses de ce syllogisme sont particulieres\n");
            printf("Et nous savons que deux premisses particulieres ne peuvent aboutir a une conclusion.\n");
            printf("Ainsi, ce syllogisme ne satisfait pas la regle R_pp, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 6:
        if (Rp(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 6 : Si une prémisse est particulière la conclusion est particulière.\n");
        }
        else
        {
            boolOff(numRegle);
            printf("\n");
            printf("**************************** REGLE R_p **********************************\n\n");
            printf("L'une des deux premisses de ce syllogisme est particuliere mais pas sa conclusion\n");
            printf("Et nous savons que si une premisse est particuliere la conclusion doit l'etre aussi.\n");
            printf("Ainsi, ce syllogisme ne satisfait pas la regle R_p, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 7:

        if (Ruu(&sefl))
        {
            boolOn(numRegle);
            printf("=>  Règle 7 : Les deux premisses de ce syllogisme sont universelles et la conclusion est non particuliere\n");
        }
        else
        {

            boolOff(numRegle);
            printf("\n");
            printf("**********************REGLE R_uu (HYPOTHESE D'EXISTENCE) ***********************\n\n");
            printf("Comme vous avez notifie lors de la saisie qu'il peut s'agir dans les premisses de ce syllogisme \n");
            printf("d'ensembles d'individus vides, on ne peut accepter ce syllogisme aux premisses universelles \n");
            printf("et a la conclusion particuliere.\n");
            printf("Ainsi, ce syllogisme ne retient pas l'hypothese d'existence, donc il n'est pas valide.\n\n\n");
        }
        break;
    case 8:
        // Test inintéressant les règles
        if (is_syllo_ininteressant(&sefl))
        {
            boolOn(numRegle);
            printf("=> Règle 8 : Ce syllogisme est \"inintéressant\"\n");
        }
        else
        {
            boolOff(numRegle);
            printf("=> Règle 8 : Ce syllogisme est intéressant ***\n");
        }
        break;
    case 9:
        // Appliquer toutes les regles

        for (int i = 0; i < numRegle; i++)
        {

            activeRegle(sefl, i);
            displayBool();
            printf("\n");
        }

        break;
    default:
        break;
    }
}
void scanf_regle(Syllogisme self, int *numRegle)
{ // char *message
    bool isValid = false;
    int taille;
    char *buffer = NULL;
    buffer = malloc(MAX * sizeof(char));
    printf("\n");
    // printf("%s\n", message);
    do
    {
        printf("Pour tester une règle spécifique, veuillez choisir un numéro dans la liste déroulante : ");
        fgets(buffer, MAX, stdin);
        buffer[strcspn(buffer, "\n")] = '\0'; // Remplacer le \n par \0

        taille = strlen(buffer);
        if (taille == 0)
        {
            printf("----------------------ATTENTION-----------------------------\n");
            printf("La saisie ne peut pas être vide.\n\n");
        }
        else if (strcmp(buffer, "-1") == 0)
        {
            *numRegle = -1;
            isValid = true;
        }
        else if (!isDigit(buffer))
        {
            printf("----------------------ATTENTION-----------------------------\n");
            printf("La saisie dois être un chiffre.\n");
        }
        else
        {
            *numRegle = io_strToInt(buffer);
            if (*numRegle >= 0 && *numRegle <= 9)
            {

                activeRegle(self, *numRegle);
                displayBool();
                isValid = true;
            }

            else
            {
                printf("----------------------ATTENTION-----------------------------\n");
                printf("La saisie dois être un chiffre en 0 et 9.\n");
            }
        }

    } while (!isValid);

    free(buffer);
}

void setquantifPx(Syllogisme *const self, int numProp)
{
    printf("\n***QUANTITE ET QUALITE DE P%d : \n", numProp);
    bool q = scanf_bool("-Si la proposition est universelle, tapez 1, sinon, tapez 0\n");
    bool ql = scanf_bool("-Si elle est affirmative, tapez 1, sinon, tapez 0\n");
    setUx(self, numProp, q);
    setAx(self, numProp, ql);
}

int scanf_arg_main(char *message)
{
    char input[100];

    while (1)
    {
        printf("\n%s\n", message);

        if (fgets(input, sizeof(input), stdin) == NULL)
        { // LIRE LA LIGNE ENTIERE
            printf("Erreur de lecture. Veuillez réessayer.\n");
            continue; // EN CAS D'ERREUR DE LECTURE EN RE-ENTRE DANS LA BOUCLE WHILE
        }

        input[strcspn(input, "\n")] = '\0'; // REMPLACER LE \n A LA FIN PAR \0 POUR NE PAS PROVOQUER
                                            // D'ERREUR DANS LES LECTURES SUIVANTES

        if (strcmp(input, "1") == 0)
        { // VERIFIE SI L'ENTREE EST "1"
            return 1;
        }
        else if (strcmp(input, "2") == 0)
        { // VERIFIE SI L'ENTREE EST "2"
            return 2;
        }
        else if (strcmp(input, "3") == 0)
        { // VERIFIE SI L'ENTREE EST "3"
            return 3;
        }
        else
        {
            printf("----------------------ATTENTION-----------------------------\n");
            printf("Entrée invalide.\n");
        }
    }
}