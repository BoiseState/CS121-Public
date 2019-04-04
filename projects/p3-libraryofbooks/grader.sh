#!/bin/bash
# Author:  Mason Vail, Luke Hindman
# Date: Mon Nov  5 11:04:29 MST 2018
# Description: Grader for LibraryOfBooks project

rm *.class > /dev/null 2>&1
# remove any extra files they may have submitted that are not needed for grading.
rm -rf etext
rm -rf p3-libraryofbooks-support.zip

echo "---------------------------------"
echo "Download and Unpack Support Files"
echo "---------------------------------"

wget https://github.com/BoiseState/CS121-Public/raw/master/projects/p3-libraryofbooks/p3-libraryofbooks-support.zip

if [ ! $? == 0 ];
then
	echo "Error occurred retrieving support files, unable to continue testing :("
	exit 1
fi

unzip -o p3-libraryofbooks-support.zip
if [ ! $? == 0 ];
then
	echo "Error occurred unpacking support files, unable to continue testing :("
	exit 1
fi

echo "------------------"
echo "Testing Book.java "
echo "------------------"

javac BookUnitTester.java
if [ ! $? == 0 ] # Make sure the program built
then
  echo "FAIL reason: BookUnitTester.java did not compile"
  exit 1
fi

echo

timeout --foreground 5 java BookUnitTester
if [ ! $? == 0 ] # Make sure the program exited with success
then
  echo "FAIL reason: BookUnitTester failed"
  exit 1
fi

echo

echo "---------------------"
echo "Testing Library.java "
echo "---------------------"

#cp data/LibraryUnitTesterGrader.java .
javac LibraryUnitTester.java
if [ ! $? == 0 ] # Make sure the program built
then
  echo "FAIL reason: LibraryUnitTester.java did not compile"
  exit 1
fi

echo

timeout --foreground 5 java LibraryUnitTester
if [ ! $? == 0 ] # Make sure the program exited with success
then
  echo "FAIL reason: LibraryUnitTester failed"
  exit 1
fi

echo

echo "------------------------------"
echo "Compiling LibraryOfBooks.java "
echo "------------------------------"

javac LibraryOfBooks.java
if [ ! $? == 0 ];then
  echo "FAIL reason: LibraryOfBooks.java did not compile"
  exit 1
fi

echo

echo "-------------"
echo "Test (p)rint "
echo "-------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
p
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: p,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: some version of empty list and clean exit"
echo "-----------------------"
echo "(p)rint test complete "
echo "-----------------------"

echo

echo "--------------"
echo "Test (d)elete "
echo "--------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
d
0
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: d0,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: some message that there is no book at index 0 and clean exit"
echo "-----------------------"
echo "(d)elete test complete "
echo "-----------------------"

echo

echo "--------------"
echo "Test (r)ead   "
echo "--------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
r
0
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: r0,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: some message that there is no book at index 0 and clean exit"
echo "-----------------------"
echo "(r)ead test complete "
echo "-----------------------"

echo

echo "--------------------"
echo "Test (a)dd, (p)rint "
echo "--------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
p
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,p,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: well formatted list showing Gettysburg Address at index 0 and clean exit"
echo "-----------------------------"
echo "(a)dd, (p)rint test complete "
echo "-----------------------------"

echo

echo "--------------------"
echo "Test (a)dd, (r)ead  "
echo "--------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
r
0
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,r0,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: full text of Gettysburg Address and clean exit"
echo "-----------------------------"
echo "(a)dd, (r)ead test complete  "
echo "-----------------------------"

echo

echo "---------------------------------------"
echo "Test (a)dd, (p)rint, (d)elete, (p)rint "
echo "---------------------------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
p
d
0
p
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,p,d0.p,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: well formatted list showing Gettysburg address at index 0, then some version of empty list and clean exit"
echo "------------------------------------------------"
echo "(a)dd, (p)rint, (d)elete, (p)rint test complete "
echo "------------------------------------------------"

echo

echo "---------------------------"
echo "Test (a)dd, (a)dd, (p)rint "
echo "---------------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
a
Alice in Wonderland
Lewis Carroll
Trippy
etext/Alice-in-Wonderland.txt
p
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,a,p,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: well formatted list showing indexed list of two books and clean exit"
echo "-------------------------------------"
echo "(a)dd, (a)dd, (p)rint test complete  "
echo "-------------------------------------"

echo

echo "----------------------------"
echo "Test (a)dd, (a)dd, (r)ead 0 "
echo "----------------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
a
Alice in Wonderland
Lewis Carroll
Trippy
etext/Alice-in-Wonderland.txt
r
0
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,a,r0,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: full text of Gettysburg Address and clean exit"
echo "-------------------------------------"
echo "(a)dd, (a)dd, (r)ead 0 test complete "
echo "-------------------------------------"

echo

echo "-------------------------------------------"
echo "Test (a)dd, (a)dd, (r)ead 1 (invalid file) "
echo "-------------------------------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
a
Alice in Wonderland
Lewis Carroll
Trippy
etext/Alice-in-Wonderland.txt
r
1
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,a,r1,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: message that the book at index 1 is invalid and clean exit"
echo "----------------------------------------------------"
echo "(a)dd, (a)dd, (r)ead 1 (invalid file) test complete "
echo "----------------------------------------------------"

echo

echo "---------------------------------------"
echo "Test (a)dd, (a)dd, (d)elete 0, (p)rint "
echo "---------------------------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
a
Alice in Wonderland
Lewis Carroll
Trippy
etext/Alice-in-Wonderland.txt
d
0
p
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,a,d0,p,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: list showing Alice in Wonderland at index 0 and clean exit"
echo "------------------------------------------------"
echo "(a)dd, (a)dd, (d)elete 0, (p)rint test complete "
echo "------------------------------------------------"

echo

echo "---------------------------------------"
echo "Test (a)dd, (a)dd, (d)elete 1, (p)rint "
echo "---------------------------------------"
java LibraryOfBooks <<END | awk '{ print "\t" $0 }'
a
Gettysburg Address
Abraham Lincoln
Historical
etext/Gettysburg-Address.txt
a
Alice in Wonderland
Lewis Carroll
Trippy
etext/Alice-in-Wonderland.txt
d
1
p
q
END
if [ ! $? == 0 ];then
  echo
  echo "FAIL reason: a,a,d0,p,q test failed, unable to continue testing :("
  exit 1
fi
echo "-->Expected: list showing Gettysburg Address at index 0 and clean exit"
echo "------------------------------------------------"
echo "(a)dd, (a)dd, (d)elete 1, (p)rint test complete "
echo "------------------------------------------------"

echo

rm *.class
