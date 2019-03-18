##
## EPITECH PROJECT, 2018
## Makefile
## File description:
## makefile
##


all:
	./gradlew build
	cp build/libs/JAV_currency-converter_2018.jar dist/
	mv dist/JAV_currency-converter_2018.jar dist/currency-converter-1.0.0.jar

build:	all

package:
	./gradlew assemble

run:
	./gradlew run

test:
	./gradlew test

deps:
	./gradlew dependencies

clean:
	./gradlew clean

re: 	clean all