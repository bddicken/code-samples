#
# Created programs that have clique call-graphs
#

VERTICES=$1
FUNCTION_NAME="function"
COUNTER_NAME="counter"

#
# Print prelude
#
echo "#include <stdlib.h>"
echo ""
echo "int turn = 1;"
echo ""

#
# Print headers
#
for X in `seq 1 $VERTICES`; do
    echo "void "$FUNCTION_NAME$X"();"
done
echo ""

#
# Print counters
#
for X in `seq 1 $VERTICES`; do
    echo "int "$COUNTER_NAME$X" = 0;"
done
echo ""

#
# Print functions
#
for X in `seq 1 $VERTICES`; do
    echo "void "$FUNCTION_NAME$X"()"
    echo "{"
    echo "    $COUNTER_NAME$X++;"
    INDEX=1
    START1=`expr $X + 1`
    END1=$VERTICES
    SEQ1=`seq $START1 $END1`
    if [ "$SEQ1" == "10" ];
    then
        SEQ1=""
    else
        for Y in $SEQ1; do
            echo "    if($COUNTER_NAME$X == $INDEX)"
            echo "        "$FUNCTION_NAME$Y"();"
            INDEX=`expr $INDEX + 1`
        done
    fi
    START2=1
    END2=$X
    SEQ2=`seq $START2 $END2`
    for Y in $SEQ2; do
        echo "    if($COUNTER_NAME$X == $INDEX)"
        echo "        "$FUNCTION_NAME$Y"();"
        INDEX=`expr $INDEX + 1`
    done
    echo "}"
done

#
# Print main
#
echo ""
echo " int main ()"
echo "{"
echo "    function1();"
echo "    return 0;"
echo "}"
