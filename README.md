# Docker - SAE2.03

Projet docker de la SAE 2.03 de l'équipe 13.

Contenu du projet : 
Morpion en ligne (en java)

## Instructions pour lancer l'application

- Vérifiez si docker est installé :
```shell
docker --version
```

- Cloner le référentiel :
 ```shell
git clone git@github.com:Antoine-CARON/docker-sae203.git
```

- Se placer dans le référentiel :
```shell
cd docker-sae203
```

- Construisez l'image décrite dans dockerfile avec docker build : 
```shell
docker build -t <choisir-un-nom-pour-l'image> .
```
Attention, ne pas oublier le point a la fin (cela signifie que l'on construit dans le repertoire courant)


- Lancer le conteneur avec l'image que vous venez de creer :
```shell
docker run -d <nom-de-l'image-choisie>
```

- Une fois le conteneur lancer, une nouvelle fenêtre devrait s'ouvrir, vous avez deux possibilités :
```shell
- Vous pouvez jouer en Solo, en cliquant sur le bouton du haut
```
```shell
- Ou alors en multijoueur, pour cela le prrmier utilisateur devra lancer un serveur,
Et ensuite, deux joueur devront rejoindre la partie : 
 ```shell
 - Soit avec la commande suivante dans un terminal bash : nc <adresse-ip du serveur> 4660
 ```
  ```shell
 - Soit directement sur notre appliction, en choisissant d'être le client
 ```
```

- Quand vous avez fini de jouer, n'oubliez d'arreter le conteneur :
```shell
docker stop <CONTAINER ID>
```

- Et si vous n'aurez pas l'occasion de relancer ce conteneur, vous pouvez même le supprimer :
```shell
docker rm <CONTAINER ID>
```
