
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool one ();
bool two ();
bool three ();
bool four ();
bool live ();
bool die ();
void domorestuff ();

bool one ()
{
    domorestuff();
    return two() | three() | four();
}

bool two ()
{
    if(live())
        domorestuff();
    return three() | four();
}

bool three ()
{
    return four();
}

bool four ()
{
    return live() | domorestuff() | 
}

bool die ()
{
    return false;
}

bool live ()
{
    return true;
}

void domorestuff() {
    strcmp("", "");
    strcoll("","");
    strncmp("", "", 0);
}

void dostuff ()
{
    if(one() | two() | three() | four())
        domorestuff();
}


int main ()
{
   dostuff();
   return EXIT_SUCCESS;
}
