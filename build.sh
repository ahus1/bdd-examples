#!/usr/bin/env bash
cd cucumber-simple
mvn -B clean test || exit $?
cd ..

cd gwen-calculator-junit
mvn -B clean test || exit $?
cd ..

cd gwen-calculator-testng
mvn -B clean test || exit $?
cd ..

cd gwen-calculator-scalatest
mvn -B clean test || exit $?
cd ..

cd gwen-arquillian
mvn -B clean test || exit $?
cd ..

cd jgiven-junit
mvn -B clean test || exit $?
cd ..

cd jgiven-arquillian
mvn -B clean verify || exit $?
cd ..
