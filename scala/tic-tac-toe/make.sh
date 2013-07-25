#!/bin/bash

BUILD="build"
RUN="run"
CLEAN="clean"

echo $1

if [ $BUILD == $1 ];
then
    cd src
    scalac model/*.scala main/*.scala
    cd ..
fi

if [ $RUN == $1 ];
then
    cd src
    scala main.TTT
    cd ..
fi

if [ $CLEAN == $1 ];
then
    rm -rf src/*/*.class
fi
