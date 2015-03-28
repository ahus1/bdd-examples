cd cucumber-simple
mvn clean test || exit $?
cd ..

cd gwen-calculator-junit
mvn clean test || exit $?
cd ..

cd gwen-calculator-testng
mvn clean test || exit $?
cd ..

cd gwen-arquillian
mvn clean test || exit $?
cd ..

cd jgiven-junit
mvn clean test || exit $?
cd ..
cd jgiven-arquillian
mvn clean verify || exit $?
cd ..
