# Utiliser l'image debia officielle comme image parent
FROM debian:latest

# Installer des services et des packages
RUN apt-get update

RUN apt-get install -y openjdk-7-jre && apt-get clean &&\
             mkdir temp_dir  &&   cd temp_dir && \
             ${JAVA_HOME}/bin/jar -xvf somejar.jar  &&\
             cd ..

# Copier les fichiers de l'hôte vers l'image
COPY ./docker-sae203 /src/Morpion

# Exposer le port 80
EXPOSE 80

# Lancer le service apache au démarrage du conteneur
CMD ["java", "Controleur"]
