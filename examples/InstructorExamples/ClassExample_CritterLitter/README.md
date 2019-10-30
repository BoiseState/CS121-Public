# CritterLitter / Critter annotated class example

## Overview

This project includes two heavily annotated classes as instructional examples.
The CritterLitter driver class creates a list of Critters and loops through rounds of cookie sharing between adjacent Critters until all Critters have a number of cookies that differs by no more than one from their neighbors.

## Files

* CritterLitter.java - the driver class
* Critter.java - class defining properties and behaviors of Critter objects
* README - this file

## Compiling and Running

From the directory containing all source files, compile with the command:
```
 $ javac CritterLitter.java
```

To run, use the command:
```
 $ java CritterLitter  
```

## Design and Concepts

CritterLitter generates 10 Critter objects and adds them to an ArrayList, a linear data structure, so all Critters are side-by-side in a line. Critters at either end of the list have only one neighbor, but most Critters have two neighbors.

When the Critter constructor is called, a Critter object is created with a random six-character name and a random number of 1 to 10 cookies.

In addition to accessor/getter methods that return the Critter's name and current number of cookies, Critters have a giveCookie(Critter otherCritter) method that allows them to give one of their cookies to the other Critter whose reference is passed in. A companion method, receiveCookie(), allows a Critter to receive a cookie.

In a loop in main(), CritterLitter compares the number of cookies of adjacent Critters and has them share a cookie with neighbors if their number of cookies differs by more than one. For example, if one Critter has 5 cookies and a neighbor has 3, the Critter with 5 would give a cookie to the neighbor with 3. If one Critter had 4 cookies and the neighbor has 3, however, they are close enough and no sharing takes place. When no sharing has taken place through a whole pass through the list, the program ends.
