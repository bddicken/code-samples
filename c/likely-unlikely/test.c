#include <stdio.h>
#include <stdlib.h>

/* define likely */
#ifdef __GNUC__
#define likely(x)       __builtin_expect(!!(x), 1)
#define unlikely(x)     __builtin_expect(!!(x), 0)
#else
#define likely(x)       (x)
#define unlikely(x)     (x)
#endif

long LOOPS;
char *arg;
int i;
static int value = 512;

void likely_loop ()
{
    printf("running likely loop\n");
    for(i=0; i < LOOPS; i++)
    {
        if(i == 7) {
            value--;
        } else if(i == 100) {
            value--;
        } else if(likely(i != value)) {
            value--;
        }
    }
    printf("value: %d\n", value);
}

void unlikely_loop ()
{
    printf("running unlikely loop\n");
    for(i=0; i < LOOPS; i++)
    {
        if(i == 7) {
            value--;
        } else if(i == 100) {
            value--;
        } else if(unlikely(i != value)) {
            value--;
        }
    }
    printf("value: %d\n", value);
}

void normal_loop ()
{
    printf("running normal loop\n");
    for(i=0; i < LOOPS; i++)
    {
        if(i == 7) {
            value--;
        } else if(i == 100) {
            value--;
        } else if(i != value) {
            value--;
        }
    }
    printf("value: %d\n", value);
}

int main (int argc, char** argv)
{
    if (argc < 3) {
        printf("usage: ./test [likely, unlikely, normal] [iterations]\n");
        exit(EXIT_FAILURE);
    }
    
    LOOPS = atol(argv[2]);
    arg = argv[1];

    if(!strcmp(arg, "likely")) {
        likely_loop();
    } else if (!strcmp(arg, "unlikely")) {
        unlikely_loop();
    } else if (!strcmp(arg, "normal")) {
        normal_loop();
    } else {
        printf("unkown argument\n");
    }

    return EXIT_SUCCESS;

}
