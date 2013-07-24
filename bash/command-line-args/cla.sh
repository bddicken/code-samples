#!/bin/bash

#
# Testing command line argument parsing
#

VERBOSE="default"
DEBUG="none"
RUN="no"

index=`expr 1 + 0`

for i in $@;
    do
    index=`expr $index + 1`
    case $i in
        -v | --verbose ) var=`eval "echo $""$index"`; VERBOSE=$var;;
        -d | --debug ) var=`eval "echo $""$index"`; DEBUG=$var;;
        -r | --run ) var=`eval "echo $""$index"`; RUN=$var;;
        -- ) ;;
        *  ) ;;
    esac
done

echo "VERBOSE: ""$VERBOSE"
echo "DEBUG: ""$DEBUG"
echo "RUN: ""$RUN"
