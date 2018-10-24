#!/bin/bash
# Author:  Luke Hindman
# Date: Thu Oct 18 10:38:51 MDT 2018
# Description: Grader for JukeboxHero project

rm *.class > /dev/null 2>&1
rm *.csv > /dev/null 2>&1
rm *.zip > /dev/null 2>&1

grader_file_path="tmp.$$"

echo "---------------------------------"
echo "Download and Unpack Support Files"
echo "---------------------------------"

mkdir ${grader_file_path}
cd ${grader_file_path}
wget https://github.com/BoiseState/CS121-Public/raw/master/projects/p2-jukeboxhero/p2-jukeboxhero-support.zip

if [ ! $? == 0 ];
then
	echo "Error occurred retrieving support files, unable to continue testing :("
	exit 1
fi

unzip p2-jukeboxhero-support.zip
if [ ! $? == 0 ];
then
	echo "Error occurred unpacking support files, unable to continue testing :("
	exit 1
fi

cp *.csv ../
cd ..

echo "-------------------"
echo "Testing Song.java"
echo "-------------------"
echo "Checking SongTest.java for changes..."
diff -w -B Song.java ${grader_file_path}/Song.java
if [ $? == 0 ]
then
        echo "Song.java matches original"
else
        echo "Song.java has been modified by the student. Replacing with original version"
	new_file="Song.java.${USER}"
	mv Song.java ${new_file}
	cp ${grader_file_path}/Song.java Song.java
	echo "Student version of Song.java has been renamed to: ${new_file}" 
fi
echo "-------------------"
 
# Cleanup grader files
rm -Rf "${grader_file_path}"

echo "---------------------------------------"
echo "Compiling JukeboxHero.java using javac"
echo "---------------------------------------"

javac JukeboxHero.java
if [ ! $? == 0 ] # Make sure the program built
then
  echo "FAIL reason: JukeboxHero.java did not compile"
  exit 1
else
  echo "JukeboxHero.java compiled successfully"
fi

echo "--------------------------"
echo "Beginning (L)oad test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
L
music-collection.csv
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: (L)oad test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: Successfully loaded 1125 songs!"
echo "--------------------------"
echo "(L)oad test complete"
echo "--------------------------"

echo "--------------------------"
echo "Beginning (S)earch test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
L
music-collection.csv
S
cheese
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: (S)earch test failed :("
fi
echo "-->Expected: 	Cheese Cake                    Aerosmith            Night In The Ruts                255"
echo "-->Expected: 	Cheeseburger in Paradise       Jimmy Buffett        Songs You Know by Heart          172"
echo "--------------------------"
echo "(S)earch test complete"
echo "--------------------------"

echo "--------------------------"
echo "Beginning (A)nalyse test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
L
music-collection.csv
A
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: (A)nalyze test failed :("
fi
echo "-->Expected: Number of Artists: 9"
echo "-->Expected: Number of Albums: 112"
echo "-->Expected: Number of Songs: 1125"
echo "-->Expected: Catalog Playtime: 79:02:30 or Catalog Playtime: 284550"	
	
echo "--------------------------"
echo "(A)nalyse test complete"
echo "--------------------------"

echo "--------------------------"
echo "Beginning (P)rint test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
L
jimmy_buffett-collection.csv
P
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: (P)rint test failed :("
fi
echo "-->Expected: 23 Jimmy Buffett Song objects displayed using toString()"
	
echo "--------------------------"
echo "(P)rint test complete"
echo "--------------------------"

echo "--------------------------"
echo "Beginning Invalid Command test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
invalid
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: Invalid Command test failed :("
fi
echo "-->Expected: Invalid selection!"
	
echo "--------------------------"
echo "Invalid Command test complete"
echo "--------------------------"

echo "--------------------------"
echo "Beginning Invalid Catalog test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
L
invalid.csv
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: Invalid Catalog test failed :("
fi
echo "-->Expected: Unable to open file: invalid.csv"
	
echo "--------------------------"
echo "Invalid Catalog test complete"
echo "--------------------------"

echo "--------------------------"
echo "Beginning Empty Catalog test"
echo "--------------------------"
java JukeboxHero <<END | awk '{ print "\t" $0 }'
S
cheese
A
P
Q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: Empty Catalog test failed :("
fi
echo "-->Expected: (Search) Found 0 matches"
echo "-->Expected: (Analyze) 0 Artists, 0 Albums, 0 Songs, 0 Playtime" 
echo "-->Expected: (Print) Song list contains 0 songs" 
echo "--------------------------"
echo "Empty Catalog test complete"
echo "--------------------------"

rm *.class
