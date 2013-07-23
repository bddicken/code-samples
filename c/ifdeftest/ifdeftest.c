#include <stdio.h>

int main() {

    #ifdef D1
        printf("D1 is defined.\n");
    #endif
    
    #ifdef D2
        printf("D2 is defined.\n");
    #endif

    printf("prints done.\n");

    return 0;
}
