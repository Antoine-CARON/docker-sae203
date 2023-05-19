# Docker - SAE2.03

Projet docker de la SAE 2.03 de l'équipe 13.

# Contenu du projet : 
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
ne pas oublier le point a la fin (cela signifie que l'on construit dans le repertoire courant)

- Lancer le conteneur avec l'image que vous venez de creer :
```shell
docker run -d <nom-de-l'image-choisie>
```

- Vérifier que le conteneur associé est actif :
```shell
docker ps
```

- La sortie de ```docker ps``` doit être similaire à :
```shell
CONTAINER ID   IMAGE          COMMAND              CREATED          STATUS          PORTS                                   NAMES
b8f8f406b03c   httpd-juanlu   "httpd-foreground"   30 minutes ago   Up 30 minutes   0.0.0.0:8080->80/tcp, :::8080->80/tcp   quirky_tesla
```

- Quand vous avez fini de jouer, n'oubliez d'arreter le conteneur :
```shell
docker stop <CONTAINER ID>
```

- Et si vous n'aurez pas l'occasion de relancer ce conteneur, vous pouvez même le supprimer :
```shell
docker rm <CONTAINER ID>
```
