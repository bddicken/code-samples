/**
 * This is a daemon that writes a message to the file `/tmp/writer-daemon`
 * every 5 seconds.
 *
 * @author Benjamin Dicken (bddicken@gmail.com)
 */

#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <syslog.h>
#include <string.h>

int main ()
{
    pid_t pid, sid;

    pid = fork();
    if (pid < 0)
        exit(EXIT_FAILURE);

    if (pid > 0)
        exit(EXIT_SUCCESS);

    umask(0);

    sid = setsid();
    if (sid < 0)
        exit(EXIT_FAILURE);

    if ((chdir("/tmp")) < 0)
        exit(EXIT_FAILURE);

    fclose(stdin);
    fclose(stdout);
    fclose(stderr);

    const char *message = "writer-daemon working!\n";
    FILE *messageFile = fopen("writer-daemon", "w+");

    if(!messageFile)
        exit(EXIT_FAILURE);

    fputs("\n---\nWriting message every 5 seconds\n---\n\n", messageFile);

    fclose(messageFile);
    
    while(1)
    {
        FILE *messageFile = fopen("writer-daemon", "a");
        fseek(messageFile, 0, SEEK_END);
        fputs(message, messageFile);
        fclose(messageFile);
        
        sleep(5);
    }

    exit(EXIT_SUCCESS);
}
