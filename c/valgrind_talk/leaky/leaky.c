/**
 * leaky.c : Program used to test memcheck.
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char** make_string_array ()
{
    char ** string_array = malloc(sizeof(char*)*10);
    int i = 0;
    for(;i < 10;i++) {
        char* str = (char*) malloc(10);
        int j = 0;
        for(;j < 10;j++) {
            *(str+j) = 'X';
        }
        *(string_array+i) = str;
    }
    return string_array;
}

void print_string_array (char **arr)
{
    printf("Strings:\n");
    int i = 0;
    for(; i < 10; i++) {
        printf("\t\"%s\"\n", *(arr+i));
    }
}

int main (int argc, char **argv)
{
    char **res = make_string_array();
    print_string_array(res);

    return EXIT_SUCCESS;
}
