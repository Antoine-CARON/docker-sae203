# Utiliser l'image debia officielle comme image parent
FROM debian:latest

# Installer des services et des packages
ENV DEBIAN_FRONTEND=noninteractive

RUN mkdir -p /usr/share/man/man1 /usr/share/man/man2

RUN apt-get update && \
apt-get install -y --no-install-recommends \
        openjdk-11-jre

# Prints installed java version, just for checking
RUN java --version

# Copier les fichiers de l'hôte vers l'image
COPY ./Morpion ./Morpion

# Exposer le port 80
EXPOSE 80

# Lancer le service apache au démarrage du conteneur
CMD ["java", "Controleur"]
