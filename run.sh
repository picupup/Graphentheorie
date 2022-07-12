#!/bin/bash
s=$1;

#s="r0c0=1&r0c1=0&r0c2=2&r1c0=3&r1c1=4&r1c2=4&r2c0=5&r2c1=6&r2c2=0"

a=$(echo $s | tr "&" " ");
#echo $$ >> /tmp/main.log;
#date >> /tmp/main.log;
#echo $s >> /tmp/main.log;
#echo "################################" >> /tmp/main.log;

head="$(cat head.txt)"; 

javac Durchmesser.java
javac run.java
table="$(java run $a)";
foot="$(cat foot.txt)";


echo "$head $table $foot";
