#!bin/sh 
export PATH=$PATH:docker-sae203/src/Morpion/

cat $PATH

javac docker-sae203/src/Morpion/*.java

java docker-sae203/src/Morpion/Controleur
