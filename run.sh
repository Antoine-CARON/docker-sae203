#!bin/sh
nginx -g daemon off

javac src.@compile.list
java src.Morpion.Controleur
