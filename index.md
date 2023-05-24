#### Equipe 13 :  Antoine CARON  -  Luc LECARPENTIER  -  Mathys PORET

# Morpion en java en local avec docker

## Présentation du projet

Notre projet est celui d'un morpion avec IHM GUI pour la partie de jeu sur le même poste (solo).
Et une partie en CUI pour le réseau local. 

## Fonctionnement du projet

Le Jeu est un scripte java qui est hébergé dans un contener sur docker ce qui nous permet de jouer en locale ou en réseau.

## Guide pour jouer

La partie commence a partir du moment où 2 joueurs se connectent. Les informations sont données dans le terminal,
il suffit de suivre les instructions pour entrer les coordonnées pour avancer dans la partie.

### Comment jouer au morpion ?
Pour jouer une partie de morpion, il suffit de tracer sur une feuille blanche une grille
de 3 cases sur 3 (selon les variantes, il est possible d’augmenter le nombre de cases).
Le but du jeu est d’aligner avant son adversaire 3 symboles identiques
horizontalement, verticalement ou en diagonale.
Chaque joueur a donc son propre symbole, généralement une croix pour l’un et un
rond pour l’autre. La partie se termine quand l’un des joueurs à aligner 3 symboles ou
quand la grille est complétée sans vainqueur. Il y a alors égalité.
### Comment gagner une partie de Morpion ?
Le premier joueur a aligner 3 symboles identiques gagne la partie. Attention, le joueur
qui débute est toujours avantagé pour gagner. Pensez donc à alterner !

