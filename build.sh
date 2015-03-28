cd cucumber-simple
mvn test || exit $?
cd ..
cd gwen-calculator-junit
mvn test || exit $?