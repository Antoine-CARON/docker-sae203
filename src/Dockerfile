# Utiliser l'image debia officielle comme image parent
FROM debian:latest

# Installer des services et des packages
RUN apt-get update
RUN apt-get upgrade
RUN apt-get install -y openjdk-11-jdk-headless
RUN apt install -y git

# Exposer le port 80
EXPOSE 4660

# Lancer le fichier Controleur.java
CMD ["git", "clone", "git@github.com:Antoine-CARON/docker-sae203.git"]
RUN ./docker-sae203/src/exec.sh
