#!/bin/bash

BUILD="build"
RUN="run"
CLEAN="clean"

echo $1

if [ $BUILD == $1 ];
then
    scalac *.scala
    cd ..
fi

if [ $RUN == $1 ];
then
    shift
    scala obfuscator.Obfuscator $@
    cd ..
fi

if [ $CLEAN == $1 ];
then
    rm -rf obfuscator
fi
