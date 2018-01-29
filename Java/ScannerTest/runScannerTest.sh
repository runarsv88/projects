#!/bin/bash
CLASSES="./target/classes/"
echo "Starting shell script..."
echo "Compiling Java program..."
javac -d $CLASSES ./src/main/java/Main.java
echo "Java progam compiled"
echo "Running java program..."
echo "##################################"
echo "##########Program output##########"
echo "##################################"
java -cp $CLASSES Main 5
