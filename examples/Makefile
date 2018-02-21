
all:
	cd chap01; make
	cd chap02; make
	cd chap03; make
	cd chap04; make
	cd chap05; make
	cd chap06; make
	cd chap07; make
	cd graphics; make
	cd file-io; make

zipfile: clean
	/bin/rm -f examples.zip
	zip -x "*/.svn*" -x "*/.project" -x "*/.classpath" -r examples.zip chap*/ graphics/ file-io/ UML/

clean:
	cd chap01; make clean
	cd chap02; make clean
	cd chap03; make clean
	cd chap04; make clean
	cd chap05; make clean
	cd chap06; make clean
	cd chap07; make clean
	cd graphics; make clean
	cd file-io; make clean
	/bin/rm -f *.log
