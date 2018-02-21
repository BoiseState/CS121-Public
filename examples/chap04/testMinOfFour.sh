#!/bin/bash


for i in 1 2 3 4
do
	for j in 1 2 3 4
	do
		for k in 1 2 3 4
		do
			for l in 1 2 3 4
			do
				java MinOfFour <<End > test.$i.$j.$k.$l
				$i $j $k $l
End
				numResults=`cat test.$i.$j.$k.$l | awk -F: '(NR > 2) {print $2}' | sort | uniq | wc -l`
				if test "$numResults" != "1"
				then
					echo "Test $i $j $k $l FAILED!"
					exit 1
				else
					echo "Test $i $j $k $l PASSED"
					rm -f test.$i.$j.$k.$l
				fi
			done
		done
	done
done
