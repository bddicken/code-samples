/**
 * A small program that I used to test the behavior
 * of function pointers when used in a struct.
 */

#include <stdio.h>

typedef struct {
    int (*printNum)(int);
    int (*printStr)(char*);
} printer;

int printNum (int n) {
    printf("number: %d\n", n);
}

int printAddNum (int n) {
    printf("number: %d\n", n+5);
}

int printStr (char* s) {
    printf("string: %s\n", s);
}

int main ()
{
    printer p = {.printNum = printNum, .printStr = printStr};
    
    p.printNum(1);
    p.printStr("one");

    p.printNum = printAddNum;
    
    p.printNum(1);
    p.printStr("one");

    return 0;
}
