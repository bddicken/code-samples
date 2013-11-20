/**
 * basic.c: 
 * Example program for showing how to use sigsetjump and siglongjump
 * save yourself from the dreaded sigsegv. Warning: don't do this in 
 * real life.
 */

#include <signal.h>
#include <setjmp.h>
#include <stdio.h>
#include <stdlib.h>

#define SIGSEGV_YES 1
#define SIGSEGV_NO 0

/* variables used for catching SIGSEGV */
struct sigaction act;
unsigned long global_effective_address;
jmp_buf env;

/**
 * Handler for SIGSEGV
 */
void RecordInvalidMemoryAccess(int n)
{
    fprintf(stderr, "handling SIGSEGV\n");
    siglongjmp(env, SIGSEGV_YES);
}

/**
 * Adds a custom handler for SIGSEGV.
 */
void AddSIGSEGVHandler()
{
    act.sa_handler = RecordInvalidMemoryAccess;
    sigemptyset(&act.sa_mask);
    sigaction(SIGSEGV, &act, NULL);
}

/**
 * Removed the custom handler for SIGSEGV (restores to default).
 */
void RemoveSIGSEGVHandler()
{
    act.sa_handler = SIG_DFL;
    sigemptyset(&act.sa_mask);
    sigaction(SIGSEGV, &act, NULL);
}

/**
 * Do SIGSEGV
 */ 
void DoSIGSEGV()
{
    int sv = sigsetjmp(env, 3);

    if(sv == SIGSEGV_NO) {
        int *bad_pointer;
        bad_pointer = 0x0;
        printf("before SIGSEGV\n");
        printf("value: %d\n", *bad_pointer);
        printf("after SIGSEGV\n");
    } 
    else {
        printf("skip SIGSEGV\n");
    }
}

/**
 * Do I gotta explain?
 */
int main()
{
    AddSIGSEGVHandler();
    DoSIGSEGV();
    return 0;
}

