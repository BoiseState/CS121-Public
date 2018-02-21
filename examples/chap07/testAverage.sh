#!/bin/bash

javac Average.java

java Average 10
java Average 100
java Average 1000

for i in 1 2 3 4 5
do
	java Average 10000
done

for i in 1 2 3 4 5
do
	java Average 1000000
done
