#!bin/sh 
export PATH=bin/:$PATH

javac docker-sae203/src/Morpion/*.java

java docker-sae203/src/Morpion/Controleur
