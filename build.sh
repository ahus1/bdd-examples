cd cucumber-simple
mvn test || exit $?
cd ..
cd gwen-calculator-junit
mvn test || exit $?
cd jgiven-junit
mvn test || exit $?
cd jgiven-arquillian
mvn test || exit $?