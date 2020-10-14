#!/usr/bin/env bash
set -e
set -x

cd cucumber-simple
mvn -B clean test
cd ..

cd gwen-calculator-junit
mvn -B clean test
cd ..

cd gwen-calculator-testng
mvn -B clean test
cd ..

cd gwen-calculator-scalatest
mvn -B clean test
cd ..

cd gwen-arquillian
# Travis doesn't install latest Google Chrome any more
# mvn -B clean test
mvn -B clean test-compile
cd ..

cd jgiven-junit
mvn -B clean test
cd ..

cd jgiven-junit5
mvn -B clean test
cd ..

cd jgiven-arquillian
# Travis doesn't install latest Google Chrome any more
# mvn -B clean verify
mvn -B clean test-compile
cd ..

cd junit-bddstyle
mvn -B clean verify
cd ..

cd junit5-bddstyle
mvn -B clean verify
cd ..
