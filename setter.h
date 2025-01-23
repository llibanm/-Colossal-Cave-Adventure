#ifndef SETTER_H
#define SETTER_H
#include "syllogisme.h"
#include <stdlib.h>
#include <stdbool.h>
// setteurs
//........
// void init_proposs(Syllogisme *const self, char *sujet, char *predicat, char *M, int fig);

void setU1(Syllogisme *const self, bool v);
void setU2(Syllogisme *const self, bool v);
void setUc(Syllogisme *const self, bool v);

void setA1(Syllogisme *const self, bool v);
void setA2(Syllogisme *const self, bool v);
void setAc(Syllogisme *const self, bool v);

void setS(Syllogisme *const self, bool v);
void setP(Syllogisme *const self, bool v);

void setMoyenTerme(Syllogisme *self, const terme s);
void setSujet(Syllogisme *self, const terme s);
void setPredicat(Syllogisme *self, const terme s);
void setFigure(Syllogisme *self, figure fig);

// void setPropos(Syllogisme *self, const Proposition **propos);

//....
void setUx(Syllogisme *const self, int numProp, bool v);
void setAx(Syllogisme *const self, int numProp, bool v);
bool scanf_bool(char *message);
void scanf_char(char *message, terme *terme );
void scanf_int(char *message, int *number);
void setquantifPx(Syllogisme *const self, int numProp);
int scanf_arg_main(char *message);
int io_strToInt(const char *s);

void scanf_regle(Syllogisme self, int *numRegle);
void activeRegle(Syllogisme self, int numRegle);

#endif