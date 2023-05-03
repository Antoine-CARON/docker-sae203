# Utiliser l'image debian officielle comme image parent
FROM debian:latest

# Installer des services et des packages
RUN apt-get update
RUN apt-get upgrade
RUN apt-get install -y openjdk-11-jdk-headless

COPY ./docker-203 /usr

# Exposer un port
EXPOSE 4660

# Lancer le fichier Controleur.java
RUN ./usr/docker-sae203/src/exec.sh
