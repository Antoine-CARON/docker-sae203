# Utiliser l'image debian officielle comme image parent
FROM debian:latest

# Installer des services et des packages
RUN  apt-get update &&  \
    apt-get -y install  \
    git                 \
    default-jdk


RUN git clone https://github.com/Antoine-CARON/docker-sae203.git

RUN cp -r docker-sae203 /var/www/

RUN echo $(ls -la docker-sae203)

RUN chmod u+x docker-sae203/run.sh

# Exposer le port 80
EXPOSE 4660


# Lancer le service apache au démarrage du conteneur
CMD ["/bin/bash", "docker-sae203/run.sh"]
